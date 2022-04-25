package com.chuck.common.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.chuck.base.exception.BaseException;
import com.chuck.common.file.config.StorageProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @since 2021/8/25
 * @version 0.0.1
 * @apiNote Value Object
 */
@Service
@Slf4j
@ConditionalOnProperty(prefix = "com.chuck", name = "uploadDir")
public class SimpleStorageServiceImpl implements StorageService {

  private final Path rootLocation;

  @Autowired
  public SimpleStorageServiceImpl(StorageProperties properties) {
    this.rootLocation = Paths.get(properties.getFileLocation());
  }

  @Override
  @PostConstruct
  public void init() {
    try {
      Files.createDirectories(rootLocation);
    } catch (IOException e) {
      throw new BaseException("Cound not initialize storage location", e);
    }
  }

  @Override
  public String store(MultipartFile file) {
    String filename = StringUtils.cleanPath(file.getOriginalFilename());
    this.storeAndRename(file, filename);
    return filename;
  }

  @Override
  public String storeAndRename(MultipartFile file, String newName) {
    return this.storeElseAndRename(file, this.rootLocation, newName);
  }

  @Override
  public String storeElseAndRename(MultipartFile file, Path dir, String newName) {
    try {
      if (file.isEmpty()) {
        throw new BaseException("Failed to store empty file " + newName, BaseException.FILE_EMPTY);
      }
      if (newName.contains("..")) {
        throw new BaseException(
            "Cannot store file with relatvie path outside current directory " + newName,
            BaseException.FILE_STORE_OUTSIDE_CURRENT_DIRECTORY);
      }
      try (InputStream input = file.getInputStream()) {
        Files.copy(input, dir.resolve(newName), StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new BaseException("Failed to store file " + newName + ",cause: " + e.getMessage(),
          BaseException.FILE_UPLOAD_ERROR);
    }
    return newName;
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.rootLocation, 1)
          .filter(path -> !path.equals(this.rootLocation))
          .map(this.rootLocation::relativize);
    } catch (IOException e) {
      throw new BaseException("Failed to read stored files", BaseException.FILE_READ_ERROR);
    }
  }

  @Override
  public Path load(String filename) {
    return rootLocation.resolve(filename);
  }

  @Override
  public Path loadFromElse(Path dir, String filename) {
    return dir.resolve(filename);
  }

  @Override
  public Resource loadAsResource(String filename) {
    try {
      Path file = load(filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new BaseException("Could not read file " + filename);
      }
    } catch (MalformedURLException e) {
      throw new BaseException("Could not read file " + filename, e);
    }
  }

  @Override
  public Resource loadFromElseAsResource(Path dir, String filename) {
    try {
      Path file = loadFromElse(dir, filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new BaseException("Could not read file " + filename);
      }
    } catch (MalformedURLException e) {
      throw new BaseException("Could not read file " + filename, e);
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }

  @Override
  public void delete(Path path) {
    try {
      Files.deleteIfExists(path);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }
}

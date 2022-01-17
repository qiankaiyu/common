package com.chuck.common.utils;

import com.chuck.base.exception.BaseException;
import com.chuck.common.config.StorageProperties;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 * @since 2021/8/25
 * @version 0.0.1
 * @apiNote Value Object
 **/
@Service
public class SimpleStorageServiceImpl implements StorageService {

    private final Path rootLocation;

    @Autowired
    public SimpleStorageServiceImpl(StorageProperties properties) {
        this.rootLocation= Paths.get(properties.getFileLocation());
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new BaseException("Cound not initialize storage location",e);
        }
    }

    @Override
    public String store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new BaseException("Failed to store empty file " + filename, BaseException.FILE_EMPTY);
            }
            if (filename.contains("..")) {
                throw new BaseException("Cannot store file with relatvie path outside current directory " + filename,
                        BaseException.FILE_STORE_OUTSIDE_CURRENT_DIRECTORY);
            }
            try (InputStream input = file.getInputStream()) {
                Files.copy(input, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new BaseException("Failed to store file " + filename, BaseException.FILE_UPLOAD_ERROR);
        }
        return filename;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation))
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
    public Resource loadAsResource(String filename)  {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new BaseException("Could not read file" + filename);
            }
        } catch (MalformedURLException e) {
             throw new BaseException("Could not read file"+filename,e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

}

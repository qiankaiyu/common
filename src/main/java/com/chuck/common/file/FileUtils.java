package com.chuck.common.file;

import com.chuck.common.utils.CodeUtils;
import com.chuck.common.utils.DateUtils;
import com.google.common.io.CharStreams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 6/19/2021
 */
public abstract class FileUtils {

  /**
   * 下载文件
   *
   * @param response
   * @param file
   * @param newFileName
   */
  public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
    try {
      response.setHeader("Content-Disposition", "attachment; filename=" + newFileName);
      BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
      InputStream is = new FileInputStream(file.getAbsolutePath());
      BufferedInputStream bis = new BufferedInputStream(is);
      int length = 0;
      byte[] temp = new byte[1 * 1024 * 10];
      while ((length = bis.read(temp)) != -1) {
        bos.write(temp, 0, length);
      }
      bos.flush();
      bis.close();
      bos.close();
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String timestampFileName(String originalFilename) {
    String suffix = FileUtils.suffix(originalFilename);
    String newName = CodeUtils.code("") + suffix;
    return newName;
  }

  public static String uuidFileName(String originalFilename) {
    String suffix = FileUtils.suffix(originalFilename);
    String newName = UUID.randomUUID() + suffix;
    return newName;
  }

  public static String suffix(String filename) {
    int lastIndex = filename.lastIndexOf(".");
    String suffix = filename.substring(lastIndex);
    return suffix;
  }

  public static BasicFileAttributes fileAttributes(Path path) {
    BasicFileAttributes attr = null;
    try {
      attr = Files.readAttributes(path, BasicFileAttributes.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return attr;
  }

  public static LocalDateTime createTime(Path path) {
    BasicFileAttributes attr = FileUtils.fileAttributes(path);
    LocalDateTime createTime =
        LocalDateTime.ofInstant(attr.creationTime().toInstant(), ZoneId.systemDefault());
    return createTime;
  }

  private static final String SLASH_DATE_FORMAT = "yyyy/MM/dd";

  public static File dateTimeFolder(String parentPath) {
    String format = DateUtils.dateString(LocalDate.now(), SLASH_DATE_FORMAT);
    File folder = new File(parentPath + format);
    if (!folder.isDirectory()) {
      folder.mkdirs();
    }
    return folder;
  }

  public static String dateTimeFolderAndUUFilename(String parentPath, String originalFilename) {
    String format = DateUtils.dateString(LocalDate.now(), SLASH_DATE_FORMAT);
    File folder = new File(parentPath + format);
    if (!folder.isDirectory()) {
      folder.mkdirs();
    }
    return folder.getAbsolutePath() + FileUtils.uuidFileName(originalFilename);
  }

  public static Path dateTimePath(String parentPath) {
    return FileUtils.dateTimeFolder(parentPath).toPath();
  }

  public static String jsonString(File file) {
    String jsonStr = "";
    try (FileInputStream inputStream = new FileInputStream(file)) {
      int length = inputStream.available();
      byte[] bytes = new byte[length];
      inputStream.read(bytes);
      jsonStr = new String(bytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }
    return jsonStr;
  }

  public static String jsonString(MultipartFile file) throws UnsupportedOperationException {
    String jsonStr = "";
    //        TODO
    return jsonStr;
  }

  public static String jsonString(Path path) {
    String jsonStr = "";
    try (Reader reader = Files.newBufferedReader(path); ) {
      jsonStr = CharStreams.toString(reader);
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }
    return jsonStr;
  }
}

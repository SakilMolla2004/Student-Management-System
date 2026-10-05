package ams.util;


import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class FileUploadHelper {


    public static String uploadFile(Part part) throws IOException {

        String fileName = extractFileName(part);

        // Create upload folder if not exists
        String uploadPath = PathConfig.uploadPath;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Rename file using timestamp to avoid duplicate
        String newFileName = System.currentTimeMillis() + "_" + fileName;

        String filePath = uploadPath + File.separator + newFileName;

        part.write(filePath);

        return newFileName;
    }

    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
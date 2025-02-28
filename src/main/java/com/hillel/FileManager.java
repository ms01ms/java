package com.hillel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public static void writeToFile(Path filePath, List<String> content) throws IOException {
        try {
            Files.write(filePath, content);
        } catch (IOException ioException) {
            throw ioException;
        }
    }

    public static List<String> readFromFile(Path filePath) throws IOException {
        try {
            List<String> content = Files.readAllLines(filePath);
            return content;
        } catch (IOException ioException) {
            throw ioException;
        }
    }

    public static void forceDeleteFile(String downloadDir, String fileName) throws IOException {
        Path filePath = Path.of(downloadDir, fileName);
        Files.delete(filePath);
    }
}

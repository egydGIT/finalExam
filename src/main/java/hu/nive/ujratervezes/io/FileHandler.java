package hu.nive.ujratervezes.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public int sumIgnoreComments(String path) {
        Path file = Path.of(path);
        int sum = 0;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(FileHandler.class.getResourceAsStream("path")))) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("//")) {
                    sum += Integer.parseInt(line);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
        return sum;
    }

}

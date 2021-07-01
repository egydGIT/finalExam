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

    // after exam:
    public int sumIgnoreCommentsWithErrCounter(String path) {
        Path file = Path.of(path);
        int sum = 0;
        int errCounter = 1;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(FileHandler.class.getResourceAsStream("path")))) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("//")) {
                    errCounter++;
                }
                if (!line.startsWith("//")) {
                    try {
                        sum += Integer.parseInt(line);
                        errCounter++;
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Wrong data in line: " + errCounter, e);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum1 = new FileHandler().sumIgnoreComments("src/test/resources/numbers.txt");
        System.out.println(sum1);

        int sum2 = new FileHandler().sumIgnoreComments("src/test/resources/numbers_with_comments.txt");
        System.out.println(sum2);

        new FileHandler().sumIgnoreCommentsWithErrCounter("src/test/resources/numbersWithLetter.txt");
    }

}

package exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise1 {
    private static final String INPUT = "sample-text-file.txt";
    private static final Logger logger = LoggerFactory.getLogger(Exercise1.class);

    public static void main(String[] args) {
        logger.warn("Application started");

        Exercise1 main = new Exercise1();
        List<String> words = main.readFromFile(Path.of(INPUT));
        main.showResult(words);

        logger.warn("Application finished");
    }

    public List<String> readFromFile(Path path) {
        logger.warn("Starting reading data");

        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Objects.requireNonNull(path))) {
            while (bufferedReader.ready()) {
                stringList.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            logger.error("Can not read file from path " + path, e);
            throw new IllegalStateException();
        }
        logger.warn("Reading data finished");
        return stringList;
    }

    public  void showResult(List<String> wordList) {
        logger.warn("Method showResult started");

        Collections.sort(wordList);
        AtomicInteger id = new AtomicInteger(1);

        logger.info("ID,Word");
        wordList.forEach(word -> logger.info(id.getAndIncrement() + "," + word));
        logger.warn("Method showResult finished");
    }
}
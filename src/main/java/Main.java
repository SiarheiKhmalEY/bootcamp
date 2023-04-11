

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final String INPUT = "sample-text-fil2e.txt";
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.warn("Application started");

        Main main = new Main();
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
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));

            logger.error("Can not read file from path " + path);
            logger.error(sw.toString());

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;1
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final String INPUT = "sample-text-file.txt";
    private static final String OUTPUT = "output.csv";

    public static void main(String[] args) {
        List<String> words = readFromFile(Path.of(INPUT));
        Collections.sort(words);
        writeToFile(words);
    }

    public static List<String> readFromFile(Path path) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Objects.requireNonNull(path))) {
            while (bufferedReader.ready()) {
                stringList.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("The file was not read");
        }
        return stringList;
    }

    public static void writeToFile(List<String> wordList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(OUTPUT))) {
            AtomicInteger id = new AtomicInteger();
            bufferedWriter.write("ID Word" + "\n");
            wordList.forEach(word -> {
                try {
                    bufferedWriter.write(id.getAndIncrement() + "  " + word + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("The file was not written");
        }
    }
}
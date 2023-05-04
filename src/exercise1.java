import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final String INPUT = "sample-text-file.txt";

    public static void main(String[] args) {
        List<String> words = readFromFile(Path.of(INPUT));
        showResult(words);
    }

    public static List<String> readFromFile(Path path) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Objects.requireNonNull(path))) {
            while (bufferedReader.ready()) {
                stringList.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file from path " + path);
        }
        return stringList;
    }

    public static void showResult(List<String> wordList) {
        Collections.sort(wordList);
        AtomicInteger id = new AtomicInteger(1);
        System.out.println("ID,Word");
        wordList.forEach(word -> System.out.println(id.getAndIncrement() + "," + word));
    }
}

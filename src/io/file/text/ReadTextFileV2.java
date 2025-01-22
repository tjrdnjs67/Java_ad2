package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        // 파일에서 읽기
        List<String> readStrings = Files.readAllLines(path, UTF_8);

        System.out.println("== Read String ==");
        for (String readString : readStrings) {
            System.out.println(readString);
        }

        // 람다 배운 후 이해할 수 있음
        Stream<String> lineStream = Files.lines(path, UTF_8);
        lineStream.forEach(line -> System.out.println(line));
        lineStream.close();
    }
}

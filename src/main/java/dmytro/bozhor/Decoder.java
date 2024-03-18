package dmytro.bozhor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Decoder {
    private static String decode(String messageFile) throws IOException {
        var stringBuilder = new StringBuilder();
        try (var bufferedReader = Files.newBufferedReader(Path.of(messageFile))) {
            var treeMap = new TreeMap<Integer, String>();
            bufferedReader.lines().forEach(line -> {
                var words = line.split(" ");
                treeMap.put(Integer.valueOf(words[0]), words[1]);
            });
            for (int j = 1, i = 1; i <= treeMap.size(); i = i + j + 1, j++) {
                stringBuilder.append(treeMap.get(i)).append(" ");
            }
        }
        return stringBuilder.toString().trim().toLowerCase();
    }

}

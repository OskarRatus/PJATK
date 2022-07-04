package zad1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {

    public static void processDir(String dirName, String resultFileName) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(resultFileName), StandardCharsets.UTF_8);

            Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    bufferedWriter.write(String.join("", Files.readAllLines(file, Charset.forName("CP1250"))));
                    return FileVisitResult.CONTINUE;
                }
            });
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

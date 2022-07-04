package zad2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(resultFileName));


//            Files.walk(dirName, Stand)
            Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.lines(file).forEach(o -> {
                        try {
                            bufferedWriter.write(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    return FileVisitResult.CONTINUE;
                }
            });
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

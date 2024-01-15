package zad1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        try {
            FileChannel fout = new FileOutputStream(resultFileName).getChannel();
            Charset inCharset = Charset.forName("Cp1252"),
                    outCharset = StandardCharsets.UTF_8;

            Files.walkFileTree(Path.of(dirName), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    FileChannel fin = new FileInputStream(file.toFile()).getChannel();
                    ByteBuffer buff = ByteBuffer.allocate((int) fin.size());
                    fin.read(buff);

                    buff.flip();
                    CharBuffer cbuff = inCharset.decode(buff);
                    buff = outCharset.encode(cbuff);

                    fout.write(buff);

                    fin.close();

                    return FileVisitResult.CONTINUE;

                }
            });
            fout.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

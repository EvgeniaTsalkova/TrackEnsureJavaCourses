package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

      try {
            Files.walkFileTree(Paths.get("F://Фильмы"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println("Visiting file: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException e){
            e.printStackTrace();
        }

        /* Второй вариант
          try {
             Files.walk(startingDir)
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
         }
         catch(IOException e){
             e.printStackTrace();
         } */

        /* Третий вариант
        File dir = new File("F://Фильмы");
        readFiles(dir);
         */

    }
    static void readFiles(File start){
            if (start.isDirectory()) {
                for (File file : Objects.requireNonNull(start.listFiles())) {
                    if (file.isFile()) {
                        System.out.println(file.getName() + " is file");
                    } else {
                        System.out.println(file.getName() + " is directory");
                        readFiles(file);
                    }
                }
            }

    }
}

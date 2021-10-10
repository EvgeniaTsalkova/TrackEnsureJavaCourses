package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

//В данном классе реализовано три способа прохода по файловому дереву
public class FilesOutput {
    public void firstOutput(String path){
        try{
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    } catch (
    IOException e) {
        e.printStackTrace();
    }
    }

    public void secondOutput(String path){
        File dir = new File(path);
        readFiles(dir);
    }
    void readFiles(File start){
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

    void thirdOutput(String path){
        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println("Visiting file: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

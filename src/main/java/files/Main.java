package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the path to the start directory:");
          try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String path = bufferedReader.readLine();
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        System.out.println("Visiting file: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        /* // Второй вариант
          try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String path = bufferedReader.readLine();
            Files.walk(path)
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
         } catch (IOException e) {
             e.printStackTrace();
         } */

        /* // Третий вариант
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            File dir = new File(bufferedReader.readLine());
            readFiles(dir);
        } catch (IOException e){
            e.printStackTrace();
        } */


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

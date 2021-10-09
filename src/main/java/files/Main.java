package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            Files.walk(Paths.get("F://Фильмы"))
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the path to the start directory:");
        String path = "";
          try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            path = bufferedReader.readLine();
          } catch (IOException e) {
                e.printStackTrace();
            }

          FilesOutput filesOutput = new FilesOutput();
          filesOutput.firstOutput(path);
        //filesOutput.thirdOutput(path);
        //filesOutput.secondOutput(path);
    }
}

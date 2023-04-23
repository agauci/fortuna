package fortuna.support;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@UtilityClass
public class FileUtils {

    public static void appendToFile(String filename, String message) {
        try {
            Files.write(
               Paths.get(filename),
               message.getBytes(),
               StandardOpenOption.CREATE, StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

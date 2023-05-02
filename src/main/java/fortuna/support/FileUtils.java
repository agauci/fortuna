package fortuna.support;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FileUtils {

    public static void appendToFile(String filename, String message, boolean truncateBeforeWrite) {
        try {
            List<OpenOption> openOptions = new ArrayList<>(List.of(StandardOpenOption.CREATE));
            if (truncateBeforeWrite) {
                openOptions.add(StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                openOptions.add(StandardOpenOption.APPEND);
            }

            Files.write(
               Paths.get(filename),
               message.getBytes(),
               openOptions.toArray(new OpenOption[openOptions.size()])
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

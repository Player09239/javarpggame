package stuff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import dev.mccue.json.Json;

public class Main {
    public static void main(String[] args) throws IOException {
        Json stuff = Json.objectBuilder()
            .put("stuff", false)
            .build();

       

        Files.writeString(Path.of("stuff.json"), Json.write(stuff));
        
        new Game().start();
    }

}

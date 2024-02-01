package lycoris.dungeons.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.HashMap;

import static lycoris.dungeons.Dungeons.player_levels;

public class ReadYaml {

    public static void ReadData() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(new File(FileSystems.getDefault().getPath("./plugins/Dungeons/players.yaml").toUri()));
        player_levels = yaml.load(inputStream);

        if (player_levels == null) {
            player_levels = new HashMap<>();
        }
        System.out.println(player_levels);
    }
}

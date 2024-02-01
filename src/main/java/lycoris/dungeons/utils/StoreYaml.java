package lycoris.dungeons.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.FileSystems;

import static lycoris.dungeons.Dungeons.player_levels;

public class StoreYaml {

    public static void StoreData() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        PrintWriter writer = new PrintWriter(new File(FileSystems.getDefault().getPath("./plugins/Dungeons/players.yaml").toUri()));
        yaml.dump(player_levels, writer);
        System.out.println(player_levels);
    }
}

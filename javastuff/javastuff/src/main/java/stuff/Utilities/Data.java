package stuff.Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.mccue.json.Json;
import dev.mccue.json.JsonDecoder;
import dev.mccue.json.JsonEncodable;
import stuff.Entities.Player;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.UI.Menu;

public class Data {
    public void save(Player p) {
        List<Item> formattedInventory = new ArrayList<>();
        for (Item v : p.getInventory()) {
            if (v != null) {
                formattedInventory.add(v);
            }
        }
        
        record Inventory(List<Item> fInv) implements JsonEncodable {
            @Override
            public Json toJson() {
                return Json.objectBuilder()
                    .put("inventory", this.fInv)
                    .build();
            }
        }

        record Dat(Player plr, Inventory inv) implements JsonEncodable {
            @Override
            public Json toJson() {
                return Json.objectBuilder()
                    .put("maxhp", plr.getMaxHp())
                    .put("hp", plr.getHp())
                    .put("atk", plr.getAtk())
                    .put("cash", plr.getCash())
                    .put("level", plr.getLevel())
                    .put("xp", plr.getXp())
                    .put("defense", plr.getDefense())
                    .put("realhp", plr.getRealHp())
                    .put("healthlv", plr.getHealthLv())
                    .put("attacklv", plr.getAtkLv())
                    .put("hpBuff", plr.getHpBuff())
                    .put("atkBuff", plr.getAtkBuff())
                    .put("inventory", inv)
                    .put("headSlot", plr.getHeadSlot())
                    .put("chestSlot", plr.getChestSlot())
                    .put("leggingsSlot", plr.getLeggingsSlot())
                    .put("bootsSlot", plr.getBootsSlot())
                    .build();
            }
        }
        
        var inv = new Inventory(formattedInventory);
        var data = new Dat(p, inv);

        System.out.println(JsonDecoder.array());
            

        try {
            Files.writeString(Path.of("data.json"), Json.write(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public void load(Scanner input, Player plr) {
        try {
            var reader = Files.newBufferedReader(Path.of("data.json"));
            var output = Json.read(reader);

            System.out.println(output);
            plr.loadPlayer(output, input);
            new Menu().menu(input, plr);
        } catch (IOException e) {}
    }
}

package stuff.Inventory.BaseItemClasses;

import dev.mccue.json.Json;
import dev.mccue.json.JsonEncodable;

public class Item implements JsonEncodable {
    protected String name;
    protected long amt;

    public Item(String name, long amt) {
        this.name = name;
        this.amt = amt;
    }

    public void addtoStack(long amount) {
        amt += amount;
    }

    public void removeStackAmt(long amount) {
        amt -= amount;
        if (amt <= 0) {
            
        }
    }

    public String itemName() {
        return name;
    }

    public long amount() {
        return amt;
    }

    public void setStackamt(long amount) {
        amt = amount;
    }

    public int getHpBuff() {
        return 0;
    }

    public int getAtkBuff() {
        return 0;
    }

    @Override
    public Json toJson() {
        return Json.objectBuilder()
            .put("itemName", name)
            .put("amount", amt)
            .build();
    }
}

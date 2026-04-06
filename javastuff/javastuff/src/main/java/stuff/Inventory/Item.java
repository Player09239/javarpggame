package stuff.Inventory;
public class Item {
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
    }

    public String itemName() {
        return name;
    }

    public long amount() {
        return amt;
    }
}

package stuff.Utilities;

public class Util {
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public String bar(long hp, long maxHp) {
        double pct = ((double) hp / maxHp) * 100;

        if (pct >= 200) return Color.green("[████████████████████] 200%");
        if (pct >= 195) return Color.cyan("[███████████████████") + Color.green("█]") + Color.cyan((long)pct + " %");
        if (pct >= 190) return Color.cyan("[██████████████████") + Color.green("██]") + Color.cyan((long)pct + " %");
        if (pct >= 185) return Color.cyan("[█████████████████") + Color.green("███]") + Color.cyan((long)pct + " %");
        if (pct >= 180) return Color.cyan("[████████████████") + Color.green("████]") + Color.cyan((long)pct + " %");
        if (pct >= 175) return Color.cyan("[███████████████") + Color.green("█████]") + Color.cyan((long)pct + " %");
        if (pct >= 170) return Color.cyan("[██████████████") + Color.green("██████]") + Color.cyan((long)pct + " %");
        if (pct >= 165) return Color.cyan("[█████████████") + Color.green("███████]") + Color.cyan((long)pct + " %");
        if (pct >= 160) return Color.cyan("[████████████") + Color.green("████████]") + Color.cyan((long)pct + " %");
        if (pct >= 155) return Color.cyan("[███████████") + Color.green("█████████]") + Color.cyan((long)pct + " %");
        if (pct >= 150) return Color.cyan("[██████████") + Color.green("██████████]") + Color.cyan((long)pct + " %");
        if (pct >= 145) return Color.cyan("[█████████") + Color.green("███████████]") + Color.cyan((long)pct + " %");
        if (pct >= 140) return Color.cyan("[████████") + Color.green("████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 135) return Color.cyan("[███████") + Color.green("█████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 130) return Color.cyan("[██████") + Color.green("██████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 125) return Color.cyan("[█████") + Color.green("███████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 120) return Color.cyan("[████") + Color.green("████████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 115) return Color.cyan("[███") + Color.green("█████████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 110) return Color.cyan("[██") + Color.green("██████████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 105) return Color.cyan("[█") + Color.green("███████████████████]") + Color.cyan((long)pct + " %");
        if (pct >= 100) return Color.green("[████████████████████] " + (long)pct + "%");
        if (pct >= 95)  return Color.green("[███████████████████ ] " + (long)pct + "%");
        if (pct >= 90)  return Color.green("[██████████████████  ] " + (long)pct + "%");
        if (pct >= 85)  return Color.green("[█████████████████   ] " + (long)pct + "%");
        if (pct >= 80)  return Color.green("[████████████████    ] " + (long)pct + "%");
        if (pct >= 75)  return Color.green("[███████████████     ] " + (long)pct + "%");
        if (pct >= 70)  return Color.yellow("[██████████████      ] " + (long)pct + "%");
        if (pct >= 65)  return Color.yellow("[█████████████       ] " + (long)pct + "%");
        if (pct >= 60)  return Color.yellow("[████████████        ] " + (long)pct + "%");
        if (pct >= 55)  return Color.yellow("[███████████         ] " + (long)pct + "%");
        if (pct >= 50)  return Color.yellow("[██████████          ] " + (long)pct + "%");
        if (pct >= 45)  return Color.orange("[█████████           ] " + (long)pct + "%");
        if (pct >= 40)  return Color.orange("[████████            ] " + (long)pct + "%");
        if (pct >= 35)  return Color.orange("[███████             ] " + (long)pct + "%");
        if (pct >= 30)  return Color.orange("[██████              ] " + (long)pct + "%");
        if (pct >= 25)  return Color.red("[█████               ] " + (long)pct + "%");
        if (pct >= 20)  return Color.red("[████                ] " + (long)pct + "%");
        if (pct >= 15)  return Color.red("[███                 ] " + (long)pct + "%");
        if (pct >= 10)  return Color.red("[██                  ] " + (long)pct + "%");
        if (pct >= 5)   return Color.red("[█                   ] " + (long)pct + "%");

        return Color.red("[                    ] 0%");
    }

    public String abbreviate(long n) {
        if (n < 1000) return Long.toString(n);

        final String[] units = {"", "K", "M", "B", "T", "Qa", "Qi"};
        int unitIndex = (int) (Math.log10(n) / 3);
        double scaled = n / Math.pow(1000, unitIndex);

        return String.format("%.1f%s", scaled, units[unitIndex]);
    }
}

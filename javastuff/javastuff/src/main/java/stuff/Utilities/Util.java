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
        double pct = (hp / (double) maxHp) * 100;

        if (pct >= 100) return "[████████████████████] 100%";
        if (pct >= 95)  return "[███████████████████ ] " + (long)pct + "%";
        if (pct >= 90)  return "[██████████████████  ] " + (long)pct + "%";
        if (pct >= 85)  return "[█████████████████   ] " + (long)pct + "%";
        if (pct >= 80)  return "[████████████████    ] " + (long)pct + "%";
        if (pct >= 75)  return "[███████████████     ] " + (long)pct + "%";
        if (pct >= 70)  return "[██████████████      ] " + (long)pct + "%";
        if (pct >= 65)  return "[█████████████       ] " + (long)pct + "%";
        if (pct >= 60)  return "[████████████        ] " + (long)pct + "%";
        if (pct >= 55)  return "[███████████         ] " + (long)pct + "%";
        if (pct >= 50)  return "[██████████          ] " + (long)pct + "%";
        if (pct >= 45)  return "[█████████           ] " + (long)pct + "%";
        if (pct >= 40)  return "[████████            ] " + (long)pct + "%";
        if (pct >= 35)  return "[███████             ] " + (long)pct + "%";
        if (pct >= 30)  return "[██████              ] " + (long)pct + "%";
        if (pct >= 25)  return "[█████               ] " + (long)pct + "%";
        if (pct >= 20)  return "[████                ] " + (long)pct + "%";
        if (pct >= 15)  return "[███                 ] " + (long)pct + "%";
        if (pct >= 10)  return "[██                  ] " + (long)pct + "%";
        if (pct >= 5)   return "[█                   ] " + (long)pct + "%";

        return "[                    ] 0%";
    }
}

package stuff.Utilities;

public class Util {
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public String bar(int hp, int maxHp) {
        double pct = (hp / (double) maxHp) * 100;

        if (pct >= 100) return "[████████████████████] 100%";
        if (pct >= 95)  return "[███████████████████ ] " + (int)pct + "%";
        if (pct >= 90)  return "[██████████████████  ] " + (int)pct + "%";
        if (pct >= 85)  return "[█████████████████   ] " + (int)pct + "%";
        if (pct >= 80)  return "[████████████████    ] " + (int)pct + "%";
        if (pct >= 75)  return "[███████████████     ] " + (int)pct + "%";
        if (pct >= 70)  return "[██████████████      ] " + (int)pct + "%";
        if (pct >= 65)  return "[█████████████       ] " + (int)pct + "%";
        if (pct >= 60)  return "[████████████        ] " + (int)pct + "%";
        if (pct >= 55)  return "[███████████         ] " + (int)pct + "%";
        if (pct >= 50)  return "[██████████          ] " + (int)pct + "%";
        if (pct >= 45)  return "[█████████           ] " + (int)pct + "%";
        if (pct >= 40)  return "[████████            ] " + (int)pct + "%";
        if (pct >= 35)  return "[███████             ] " + (int)pct + "%";
        if (pct >= 30)  return "[██████              ] " + (int)pct + "%";
        if (pct >= 25)  return "[█████               ] " + (int)pct + "%";
        if (pct >= 20)  return "[████                ] " + (int)pct + "%";
        if (pct >= 15)  return "[███                 ] " + (int)pct + "%";
        if (pct >= 10)  return "[██                  ] " + (int)pct + "%";
        if (pct >= 5)   return "[█                   ] " + (int)pct + "%";

        return "[                    ] 0%";
    }
}

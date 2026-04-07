package stuff.Utilities;

import dev.mccue.color.terminal.ANSIColor;
import dev.mccue.color.terminal.TerminalColor;
import dev.mccue.color.terminal.TerminalStyle;
import dev.mccue.color.terminal.TrueColor;

public class Color {
    public static String red(String str) {
        TerminalColor red = ANSIColor.RED;

        String s = TerminalStyle.builder()
            .foregroundColor(red)
            .apply(str);

        return s;
    }

    public static String green(String str) {
        TerminalColor green = ANSIColor.GREEN;

        String s = TerminalStyle.builder()
            .foregroundColor(green)
            .apply(str);

        return s;
    }

    public static String blue(String str) {
        TerminalColor blue = ANSIColor.BLUE;

        String s = TerminalStyle.builder()
            .foregroundColor(blue)
            .apply(str);

        return s;
    }

    public static String yellow(String str) {
        TerminalColor yellow = ANSIColor.YELLOW;

        String s = TerminalStyle.builder()
            .foregroundColor(yellow)
            .apply(str);

        return s;
    }

    public static String cyan(String str) {
        TerminalColor cyan = ANSIColor.CYAN;

        String s = TerminalStyle.builder()
            .foregroundColor(cyan)
            .apply(str);

        return s;
    }

    public static String magenta(String str) {
        TerminalColor magenta = ANSIColor.MAGENTA;

        String s = TerminalStyle.builder()
            .foregroundColor(magenta)
            .apply(str);

        return s;
    }

    public static String white(String str) {
        TerminalColor white = ANSIColor.WHITE;

        String s = TerminalStyle.builder()
            .foregroundColor(white)
            .apply(str);

        return s;
    }

    public static String black(String str) {
        TerminalColor black = ANSIColor.BLACK;

        String s = TerminalStyle.builder()
            .foregroundColor(black)
            .apply(str);

        return s;
    }

    public static String orange(String str) {
        TerminalColor orange = TrueColor.of(dev.mccue.color.Color.RGB255(255, 165, 0));

        String s = TerminalStyle.builder()
            .foregroundColor(orange)
            .apply(str);

        return s;
    }

    public static String whitebg(String str) {
        TerminalColor white = ANSIColor.WHITE;

        String s = TerminalStyle.builder()
            .backgroundColor(white)
            .foregroundColor(white)
            .apply(str);

        return s;
    }
}

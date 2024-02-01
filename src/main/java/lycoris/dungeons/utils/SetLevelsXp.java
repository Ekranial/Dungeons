package lycoris.dungeons.utils;

import static lycoris.dungeons.Dungeons.needed_xp;

public class SetLevelsXp {

    public static void SetXp() {
        needed_xp.put(0, 0);
        needed_xp.put(1, 600);
        needed_xp.put(2, 1250);
        needed_xp.put(3, 1950);
        needed_xp.put(4, 2700);
        needed_xp.put(5, 3500);
        needed_xp.put(6, 4350);
        needed_xp.put(7, 5250);
        needed_xp.put(8, 6200);
        needed_xp.put(9, 7200);
        needed_xp.put(10, 8250);
    }
}

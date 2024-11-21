package net.thunderstar.quantum_craft.util;

public class Reference {
    public static final String MOD_ID = "quantum_craft";
    public static final String NAME = "Quantum Craft";
    public static final String VERSION = "0.0.1";


    public static boolean inArrayInt(int entry, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == entry) {
                return true;
            }
        }

        return false;
    }
}

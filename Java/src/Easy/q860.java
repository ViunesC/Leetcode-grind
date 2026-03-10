package Easy;

import java.util.Arrays;

public class q860 {
    public static boolean lemonadeChange(int[] bills) {
        int[] notes = new int[2];
        // Arrays.fill(notes, 0);

        for (int bill : bills) {
            // System.out.println("NExt: " + Arrays.toString(notes));
            if (bill == 5)
                notes[0]++;
            else if (bill == 10) {
                if (notes[0] < 1) {
                    // System.out.println("1");
                    return false;
                }
                notes[1]++;
                notes[0]--;
            } else {
                if (notes[1] > 0) {
                    notes[1]--;
                } else {
                    if (notes[0] < 2) {
                        // System.out.println("2");
                        return false;
                    } else
                        notes[0] -= 2;
                }

                if (notes[0] < 1) {
                    // System.out.println("3");
                    // System.out.println(Arrays.toString(notes));
                    return false;
                } else
                    notes[0]--;
            }
        }

        return true;
    }

    public static void testSample() {
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
    }
}

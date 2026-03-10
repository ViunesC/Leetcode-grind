package Easy;
import java.util.HashSet;
import java.util.Set;

public class q202 {
    public static boolean isHappy(int n) {
        if (n == 1)
            return true;

        Set<Integer> produced = new HashSet<>();

        int sum = 0;
        produced.add(n);

        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                sum += (int) Math.pow(n % 10,2);
                n /= 10;
            }

            n = sum;
            if (produced.contains(n))
                return false;
            else
                produced.add(n);
        }

        return true;
    }

    public static void testSample() {
        System.out.println(isHappy(2));
    }
}

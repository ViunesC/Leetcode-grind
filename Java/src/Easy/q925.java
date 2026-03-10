package Easy;

public class q925 {
    public static boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;

        if (name.charAt(0) != typed.charAt(0))
            return false;

        while (i < name.length() && j < typed.length()) {
//            if (name.charAt(i) != typed.charAt(j))
//                return false;
//            System.out.println("i=" + name.charAt(i) + "; j=" +  typed.charAt(j));

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (name.charAt(i-1) == typed.charAt(j))
                    j++;
                else if (name.charAt(i) != typed.charAt(j)) return false;
            }
        }

        if (i < name.length()) return false;

        while (j < typed.length()) {
            if (name.charAt(i-1) == typed.charAt(j))
                j++;
            else
                return false;
        }

        return true;
    }

    public static void testSample() {
        System.out.println(isLongPressedName("alex", "aaleex"));
    }
}

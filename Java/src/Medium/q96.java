package Medium;

public class q96 {
    public static int numTrees(int n) {
        if (n == 1 || n == 2)
            return n;

        // if we view each BST as left sub-BST + right sub-BST
        // then for a tree of size n, we have
        // numTrees = Sum(numTrees of size j left-sub tree * numTrees of size n-j
        // (remaining size available) left-sub tree), where j=1...n
        int[] countSubTree = new int[n+1];
        countSubTree[0] = 1;
        countSubTree[1] = 1;
        countSubTree[2] = 2;

        for (int i=3;i<countSubTree.length;++i) {
            for (int j=1;j<=i;++j) {
                countSubTree[i] += countSubTree[j-1] * countSubTree[i-j];
            }
        }

        return countSubTree[n];
    }

    public static void testSample() {
        System.out.println(numTrees(3));
    }
}

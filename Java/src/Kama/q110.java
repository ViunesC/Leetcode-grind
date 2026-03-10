package Kama;

import java.util.*;

public class q110 {
    /*
     * 卡码网 110. 字符串迁移
     * https://kamacoder.com/problempage.php?pid=1183
     */

    private static int bfs(Set<String> dict, String beginStr, String endStr) {
        int len = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginStr);
        q.add(beginStr);
        q.add(null);
        while (!q.isEmpty()) {
            String node = q.remove();
            //上一层结束，若下一层还有节点进入下一层
            if (node == null) {
                if (!q.isEmpty()) {
                    len++;
                    q.add(null);
                }
                continue;
            }
            char[] charArray = node.toCharArray();
            //寻找邻接节点
            for (int i = 0; i < charArray.length; i++) {
                //记录旧值，用于回滚修改
                char old = charArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newWord = new String(charArray);
                    if (dict.contains(newWord) && !visited.contains(newWord)) {
                        q.add(newWord);
                        visited.add(newWord);
                        //找到结尾
                        if (newWord.equals(endStr)) return len + 1;
                    }
                }
                charArray[i] = old;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = Integer.parseInt(myScanner.nextLine());
        Set<String> dict = new HashSet<>();
        Map<String, Integer> visited = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();

        String next, beginStr = "", endStr = "";
        for (int i=0;i<N+1;++i) {
            next = myScanner.nextLine();

            if (i == 0) {
                String[] temp = next.split(" ");
                beginStr = temp[0];
                endStr = temp[1];
            } else {
                dict.add(next);
            }
        }

        dict.add(beginStr);
        dict.add(endStr);

        System.out.println(bfs(dict, beginStr, endStr));
    }
}

package Misc.Graph;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {
    private int[] father;
    private int N;

    public UnionFind(int N) {
        this.N = N;
        this.father = new int[N];

        for (int i=0;i<N;++i) {
            this.father[i] = i;
        }
    }

    public void join(int u, int v) {
        u-=1;
        v-=1;

        u = find(u);
        v = find(v);

        if (u == v) return;

        this.father[v] = u;
    }

    public int find(int u) {
        // find root of u
        if (this.father[u] == u) return u;

        return this.father[u] = find(this.father[u]);
    }

    public boolean isSame(int u, int v) {
        u-=1;
        v-=1;

        u = find(u);
        v = find(v);

        return u == v;
    }

    public String toString() {
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0;i<N;++i)
            list.add(new ArrayList<>());

        for (int i=0;i<N;++i) {
            list.get(father[i]).add(i);
        }

        List<Integer> temp;
        StringBuilder result = new StringBuilder();
        for (int root=0;root<N;++root) {
            temp = list.get(root);
            result.append(root+1);

            for (int c=0;c<temp.size();++c) {
                if (root == temp.get(c))
                    continue;

                if (c == 0)
                    result.append(" <- ");
                else
                    result.append(",");

                result.append(temp.get(c)+1);
            }

            result.append("\n");
        }

        return result.toString();
    }
}

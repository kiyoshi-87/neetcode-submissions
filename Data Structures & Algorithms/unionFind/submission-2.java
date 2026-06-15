class UnionFind {

    private Map<Integer, Integer> self;
    private Map<Integer, Integer> rank;
    private int numComponents;

    public UnionFind(int n) {
        self = new HashMap<>(); // Map that puts child -> parent
        rank = new HashMap<>(); // Map of element and its rank
        numComponents = n;

        for (int i=0; i<n; i++) {
            self.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int x) {
        int i = x;
        while (self.get(i) != i) {
            i = self.get(i);
        }

        return i;
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int p1 = this.find(x), p2 = this.find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            self.put(p2, p1);
        } else if (rank.get(p1) < rank.get(p2)) {
            self.put(p1, p2);
        } else {
            self.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        numComponents--;
        return true;
    }

    public int getNumComponents() {
        return numComponents;
    }
}

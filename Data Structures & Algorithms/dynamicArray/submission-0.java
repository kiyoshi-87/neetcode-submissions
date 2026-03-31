class DynamicArray {
    int[] arr;
    int size;
    int length;

    public DynamicArray(int capacity) {
        this.size = capacity;
        this.length = 0;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == size) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        int val = arr[length - 1];
        length--;
        return val;
    }

    private void resize() {
        size = size*2;
        int[] temp = arr;
        arr = new int[size];

        for (int i = 0; i<size/2; i++) {
            arr[i] = temp[i];
        }
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return size;
    }
}

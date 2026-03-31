class MinStack {
    private int[] values;
    private int[] mins;
    private int size;
    private int topIndex;

    public MinStack() {
        topIndex = 0;
        size = 20;
        values = new int[size];
        mins = new int[size];
    }
    
    public void push(int val) {
        if(topIndex==size) {
            int[] tempValues = new int[2*size];
            int[] tempMins = new int[2*size];
            values = populate(tempValues, values);
            mins = populate(tempMins, mins);
            size *= 2;
        }
        values[topIndex] = val;
        if (topIndex == 0) {
            mins[topIndex] = val;
        } else {
            mins[topIndex] = Math.min(val, mins[topIndex - 1]);
        }
        topIndex++;
    }
    
    public void pop() {
        topIndex--;
    }
    
    public int top() {
        return values[topIndex-1];
    }
    
    public int getMin() {
        return mins[topIndex-1];
    }

    private int[] populate(int[] temp, int[] values) {
        for(int i=0; i<values.length; i++) {
            temp[i] = values[i];
        }

        return temp;
    }
}
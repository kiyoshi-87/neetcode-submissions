class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
    }

    public LinkedList(int val) {
        head = new ListNode(val);
        tail = head;
    }

    public int get(int index) {
        int i = 0;
        ListNode pointer = head;
        while(pointer!=null) {
            if (index == i) {
                return pointer.val;
            }
            i++;
            pointer = pointer.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            return;
        }

        ListNode temp = head;
        head = new ListNode(val);

        head.next = temp;
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            return;
        }

        ListNode newTail = new ListNode(val);
        tail.next = newTail;
        tail = newTail;
    }

    public boolean remove(int index) {
        if (head == null) return false;

        if (index == 0) {
            head = head.next;
        if (head == null) 
            tail = null;
        return true;
        }

        int i = 0;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (i == index - 1) {
                if (pointer.next == tail) {
                    tail = pointer;
                }
            pointer.next = pointer.next.next;
            return true;
            }
            i++;
            pointer = pointer.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode pointer = head;

        while (pointer!=null) {
            values.add(pointer.val);
            pointer = pointer.next;
        }

        return values;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
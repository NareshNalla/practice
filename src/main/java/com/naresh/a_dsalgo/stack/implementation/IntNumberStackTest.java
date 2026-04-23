package com.naresh.a_dsalgo.stack.implementation;

interface IntNumber {
    void insert(int item);

    int delete();
}


class IntNumberStackImpl implements IntNumber {
    private int stck[]; //Stack array
    private int pos; //position ( where i am right now in the buffer)
//idx : Index , cap: Capacity , sz: size, val:value, ptr:Pointer
    IntNumberStackImpl(int size) {
        stck = new int[size];
        pos = -1;
    }

    public void insert(int item) {
        if (pos == stck.length - 1)
            System.out.println("Overflow");
        else
            stck[++pos] = item;
    }

    public int delete() {
        if (pos < 0) {
            System.out.println("Underflow");
            return 0;
        } else
            return stck[pos--];
    }
    public int pop() {
        return stck[pos];
    }
}

public class IntNumberStackTest {
    public static void main(String args[]) {
        IntNumberStackImpl obj = new IntNumberStackImpl(3);
        for (int i = 0; i < 4; i++) obj.insert(i);

        System.out.println("top: "+obj.pop());

        for (int i = 0; i <= 3; i++)
            System.out.println(obj.delete());
    }
}
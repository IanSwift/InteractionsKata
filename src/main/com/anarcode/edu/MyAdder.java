package main.com.anarcode.edu;

import java.util.List;

public class MyAdder implements OperationInterface{
    @Override
    public int operate(List<Integer> values) {
        int i = 0;
        for (int v : values) {
            i += v;
        }
        return i;
    }
}

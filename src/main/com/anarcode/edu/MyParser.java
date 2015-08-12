package main.com.anarcode.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyParser implements ParserInterface{
    @Override
    public List<Integer> parse(String s) {
        if (s.equals(""))
            return Arrays.asList();

        String[] stringList = (s.split(","));
        List<Integer> intList = new ArrayList<>();

        for (String str : stringList) {
            intList.add((Integer)Integer.parseInt(str));
        }

        return intList;
    }
}

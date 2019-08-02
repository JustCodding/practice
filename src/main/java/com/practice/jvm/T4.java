package com.practice.jvm;

import java.util.ArrayList;
import java.util.List;

public class T4 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 100000000; i++) {
            list.add(new byte[1024*1024]);
        }
    }
}

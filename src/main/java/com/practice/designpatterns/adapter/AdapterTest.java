package com.practice.designpatterns.adapter;

public class AdapterTest {
    public static void main(String[] args) {
          Iphone iphone = new Iphone();
          EarMachine earMachine = new EarMachine();
          IphoneInterface adapter = new EarMachineAdapter(earMachine);
          iphone.earSing(adapter);
    }
}

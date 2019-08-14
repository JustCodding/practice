package com.practice.designpatterns.adapter;

public class EarMachineAdapter implements IphoneInterface {
    private EarMachine earMachine;

    public EarMachineAdapter(EarMachine earMachine) {
        this.earMachine = earMachine;
    }

    @Override
    public void charging() {
        //该转换器没实现充电
    }

    @Override
    public void singMusic(String music) {
        earMachine.earSing(music);
    }
}

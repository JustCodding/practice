package com.practice.designpatterns.adapter;
/*
苹果充电器
*/
public class IphoneCharger implements IphoneInterface {
    private String electric;
    public IphoneCharger(){
    }
    public IphoneCharger(String electric){
        this.electric = electric;
    }
    @Override
    public void charging() {
        System.out.println("充电,输入电流:"+electric);
    }

    @Override
    public void singMusic(String music) {
        //苹果充电器虽然支持苹果接口，但是实现不了播放音乐的功能
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }
}

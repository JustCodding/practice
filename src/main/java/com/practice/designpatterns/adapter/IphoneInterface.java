package com.practice.designpatterns.adapter;
/*
苹果唯一接口，有两种功能，1.支持充电输入电流 2.支持手机输出音乐电信号
*/
public interface IphoneInterface {
    void charging();
    void singMusic(String music);
}

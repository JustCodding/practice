    package com.practice.designpatterns.adapter;

    public class Iphone {
        private String music="夜曲";
        /*
           新的播放音乐的功能，但是只支持插入电源接口
        */
        void earSing(IphoneInterface iphoneInterface){
            iphoneInterface.singMusic(music);
        }
        /*
        iphone去掉了传入耳机来播放音乐的功能,我们这里标注为过期
        **/
        @Deprecated
        void earSing(EarMachine earMachine){
            earMachine.earSing(music);
        }
        /*
        外放音乐功能
        */
        public void pubOut(){
            System.out.println("播放音乐:"+music);
        }
        /*
        充电功能
        */
        public void charging(IphoneInterface chager){
            chager.charging();
        }


    }

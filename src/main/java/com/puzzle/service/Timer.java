package com.puzzle.service;

import org.springframework.stereotype.Component;

@Component
public class Timer implements Runnable{

    int second;

    @Override
    public void run() {
        second = 0;
        try{
            while(true){
                Thread.sleep(1000);
                second++;
            }
        }catch (InterruptedException e){ return; }
    }

    public String getTime(){
        int hour = second / 3600;
        second %= 3600;
        int minute = second / 60;
        second %= 60;
        return String.format("%d시간 %d분 %d초", hour, minute, second);
    }
}

package com.kwai.dp.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author malingling <malingling@kuaishou.com>
 * Created on 2018-11-20
 */
public class Player implements Runnable {

    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;
    public Player(int i, CountDownLatch begin, CountDownLatch end) {
        super();
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    public void run() {
        try{
            begin.await();        //等待begin的状态为0，这里表示等待其他选手就绪，然后一起开始比赛
            Thread.sleep((long)(Math.random()*100)*100);    //随机分配时间，即运动员完成时间
            System.out.println("Play"+id+" arrived.");//选手到达终点
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            end.countDown();    //使end状态减1，最终减至0，为0时比赛结束
        }
    }
}
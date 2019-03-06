package com.zc.hust.controller;


import com.zc.hust.tasks.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test1")
    public String test1() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask1();
        Future<Boolean> b = asyncTask.doTask2();
        Future<Boolean> c = asyncTask.doTask3();

        //如果任务没有完成，接着进行
        while (!a.isDone() || !b.isDone() || !c.isDone()){
            if (a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }
        long time = System.currentTimeMillis() - start;
        String times = "任务总耗时：" + time + "毫秒";
        System.out.println(times);
        return times;

    }
}

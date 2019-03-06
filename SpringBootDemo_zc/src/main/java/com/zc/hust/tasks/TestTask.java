package com.zc.hust.tasks;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    //定义每3秒执行任务
   // @Scheduled(fixedRate = 3000)
    //也可以使用corn表达式，自定义(不支持年)
    //@Scheduled(cron = "1-10 * * * * ?")
    private void reportCurrentTime(){
        System.out.println("现在时间：" + dataFormat.format(new Date()));
    }
}

package com.zc.hust;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mapper包路径
@MapperScan(basePackages = "com.zc.hust.mapper")
//扫描所有需要的包，包含一些自用的工具类包所在的路径
@ComponentScan(basePackages = {"com.zc.hust","org.n3r.idworker"})
//开启定时任务
@EnableScheduling//@Component注解类,@Scheduled注解方法
//开启异步调用方法
@EnableAsync//@Component注解类,@Async注解方法
public class HustApplication {

    public static void main(String[] args) {
        SpringApplication.run(HustApplication.class, args);
    }

}

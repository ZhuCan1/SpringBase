package com.zc.hust.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class User {

    String name;

    int age;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale = "zh",timezone = "GMT+8")
    Date Birthday;

    @JsonIgnore//表示不传递
    String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)//(表示不为空才显示)
    String desc;
 
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public String getPassword() {
        return password;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Birthday=" + Birthday +
                ", password='" + password + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

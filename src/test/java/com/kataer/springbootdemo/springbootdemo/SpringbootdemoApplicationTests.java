package com.kataer.springbootdemo.springbootdemo;

import com.kataer.springbootdemo.springbootdemo.properties.WxConfiguration;
import com.kataer.springbootdemo.springbootdemo.properties.WxProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

@SpringBootTest
class SpringbootdemoApplicationTests {
    @Autowired
    private WxConfiguration wxConfiguration;

    @Test
    void contextLoads() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }


    @Test
    void test() {
        WxProperties properties = wxConfiguration.getProperties();
        System.out.println(properties);
    }

}

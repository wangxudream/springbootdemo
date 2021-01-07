package com.kataer.springbootdemo.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FilterController {

    @GetMapping("/points/testFilter")
    public Result testFilter() {
        System.out.println("testFilter method >>>>>>");
        return new Result(200, "ok");
    }


    @GetMapping("/points/testRedirect")
    public ModelAndView testRedirect(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testRedirect method >>>>>>");
        ModelAndView view = new ModelAndView("forward:testFilter");
        return view;
    }

}

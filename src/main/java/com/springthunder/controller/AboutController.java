/**
 * AboutController.java - This file is part of Spring Thunder organization.
 * Under License CC0 1.0 Universal 2015.
 */
package com.springthunder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AboutController {

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "About OAUTH2 SPRING THUNDER...";
    }
}

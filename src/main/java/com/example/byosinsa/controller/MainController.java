package com.example.byosinsa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {


    @GetMapping("/")
    public String main() {
        return "shop";
    }

    @GetMapping("/sub")
    public String sub() {
        return "sub";
    }



}

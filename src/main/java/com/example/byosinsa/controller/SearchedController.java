package com.example.byosinsa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/search")
public class SearchedController {

    @GetMapping("/register")
    public void searchRegiGet() {

    }
    @PostMapping("/register")
    public void searchRegiPost() {

    }



}

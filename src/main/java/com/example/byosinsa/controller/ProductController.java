package com.example.byosinsa.controller;

import com.example.byosinsa.dto.ProductDTO;
import com.example.byosinsa.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    //등록
    @GetMapping("/register")
    public void productRegister(ProductDTO productDTO){

    }
    @PostMapping("/register")
    public String  gameRegisterP(@Valid ProductDTO productDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/product/register";
        }

        log.info("qwe"+productDTO.getProductImageDTOList());
        productService.productRegister(productDTO);

        return "redirect:/";
    }




}

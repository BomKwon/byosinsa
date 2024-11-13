package com.example.byosinsa.service;

import com.example.byosinsa.controller.SearchedController;
import com.example.byosinsa.repository.ProductRepository;
import com.example.byosinsa.repository.SearchedRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class SearchedService {

    private SearchedRepository searchedRepository;

    private ModelMapper modelMapper;


}

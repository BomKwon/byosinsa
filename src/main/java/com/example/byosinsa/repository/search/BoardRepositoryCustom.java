package com.example.byosinsa.repository.search;

import com.example.byosinsa.dto.PageRequestDTO;
import com.example.byosinsa.dto.search.BoardSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<BoardSearchDTO> getListPage1(PageRequestDTO pageRequestDTO, Pageable pageable);
}

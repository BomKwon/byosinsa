package com.example.byosinsa.repository.search;

import com.example.game.dto.PageRequestDTO;
import com.example.game.dto.search.BoardSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<BoardSearchDTO> getListPage1(PageRequestDTO pageRequestDTO, Pageable pageable);
}

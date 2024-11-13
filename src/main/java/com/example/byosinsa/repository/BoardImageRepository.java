package com.example.byosinsa.repository;

import com.example.byosinsa.entity.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardImageRepository extends JpaRepository<BoardImage, Integer> {
    void deleteByBoard_Bno(int bno);
    List<BoardImage> findByBoard_Bno(int bno);
}

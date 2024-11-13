package com.example.byosinsa.repository;

import com.example.byosinsa.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Integer> {

}

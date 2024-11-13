package com.example.byosinsa.repository;

import com.example.byosinsa.entity.Board;
import com.example.byosinsa.repository.search.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>, BoardRepositoryCustom {

    @Query(value = "select board.bno, board.reg_time, board.update_time, board.b_content, board.b_title, board.b_writer, board.views, bc.cno from board left join game.board_category bc on board.cno = bc.cno where bc.c_name  = '공지사항' order by update_time desc limit 6", nativeQuery = true)
    List<Board> boardNotice();

}

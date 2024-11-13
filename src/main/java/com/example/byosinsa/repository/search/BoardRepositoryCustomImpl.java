package com.example.byosinsa.repository.search;


import com.example.byosinsa.dto.PageRequestDTO;
import com.example.byosinsa.dto.search.BoardSearchDTO;
import com.example.byosinsa.dto.search.QBoardSearchDTO;
import com.example.byosinsa.entity.QBoard;
import com.example.byosinsa.entity.QBoardImage;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private BooleanBuilder getSearch(PageRequestDTO pageRequestDTO){ //Querydsl 처리
        String type = pageRequestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QBoard qboard = QBoard.board;

        String keyword = pageRequestDTO.getKeyword();

        BooleanExpression expression = qboard.bno.gt(0L); // bno > 0 조건만 생성

        booleanBuilder.and(expression);

        if (type == null || type.trim().length() == 0){//검색 조건이 없는 경우
            return booleanBuilder;
        }

        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")){
            conditionBuilder.or(qboard.bTitle.contains(keyword));
        }
        if (type.contains("c")){
            conditionBuilder.or(qboard.bContent.contains(keyword));
        }
        if (type.contains("w")){
            conditionBuilder.or(qboard.bWriter.contains(keyword));
        }
        if (type.contains("n")){
            conditionBuilder.or(qboard.boardCategory.cName.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    @Override
    public Page<BoardSearchDTO> getListPage1(PageRequestDTO pageRequestDTO, Pageable pageable) {
        QBoard qBoard = QBoard.board;
        QBoardImage qBoardImage = QBoardImage.boardImage;

        QueryResults<BoardSearchDTO> results = jpaQueryFactory.select(
                new QBoardSearchDTO(
                        qBoard.bno,
                        qBoard.bTitle,
                        qBoard.bContent,
                        qBoard.bWriter,
                        qBoard.boardCategory,
                        qBoard.views,
                        qBoardImage.boardImgno,
                        qBoardImage.fileName,
                        qBoardImage.uuid,
                        qBoardImage.folderPath
                )
        )
                .from(qBoard)
                .leftJoin(qBoardImage)
                .on(qBoardImage.board.eq(qBoard))
                .where(getSearch(pageRequestDTO))//상품명 검색
                .groupBy(qBoard)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<BoardSearchDTO> content = results.getResults();
        System.out.println("서치레포"+content);
        long total = results.getTotal();

        System.out.println("서치레포토탈"+total);
        return new PageImpl<>(content, pageable, total);
    }
}

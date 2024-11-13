package com.example.byosinsa.service;

import com.example.byosinsa.dto.*;
import com.example.byosinsa.dto.search.BoardSearchDTO;
import com.example.byosinsa.entity.Board;
import com.example.byosinsa.entity.BoardCategory;
import com.example.byosinsa.entity.BoardImage;
import com.example.byosinsa.repository.BoardCategoryRepository;
import com.example.byosinsa.repository.BoardImageRepository;
import com.example.byosinsa.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
@ToString
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;
    private final BoardCategoryRepository boardCategoryRepository;
//    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    public Integer boardRegister(BoardDTO boardDTO) {

        Board board = modelMapper.map(boardDTO, Board.class);

        //카테고리 지정
        board.setBoardCategory(boardCategoryRepository.findById(boardDTO.getCno()).get());

        int bno = boardRepository.save(board).getBno();

        List<BoardImageDTO> boardImageDTOList = boardDTO.getBoardImageDTOList();

        if (boardImageDTOList != null && boardImageDTOList.size() > 0) {
            List<BoardImage> boardImageList = boardImageDTOList.stream()
                    .map(boardImageDTO -> {
                        BoardImage boardImage = BoardImage.builder()
                                .folderPath(boardImageDTO.getFolderPath())
                                .fileName(boardImageDTO.getFileName())
                                .uuid(boardImageDTO.getUuid())
                                .board(board)
                                .build();

                        return boardImage;
                    }).collect(Collectors.toList());

            for (BoardImage boardImage : boardImageList) {
                boardImageRepository.save(boardImage);
            }

        }


        return bno;
    }

//    public List<Board> mainNotice(String cName){
//        return boardRepository.boardNotice();
//    }
//
//    public PageResponseDTO<BoardSearchDTO> getList(PageRequestDTO pageRequestDTO) {
//
//        Pageable pageable = PageRequest
//                .of(pageRequestDTO.getPage() <= 0 ? 0 : pageRequestDTO.getPage()-1,
//                        pageRequestDTO.getSize(),
//                        Sort.by("bno").descending());
//
//        Page<BoardSearchDTO> result = boardRepository.getListPage1(pageRequestDTO ,pageable);
//
//        log.info("변환값" + result);
////        List<BoardSearchDTO> boardSearchDTOList = result.getContent()
////                .stream().map(boardSearch -> modelMapper.map(boardSearch, BoardSearchDTO.class))
////                .collect(Collectors.toList());
//
//        System.out.println("123" + result.getContent());
//
//
//        return PageResponseDTO.<BoardSearchDTO>withAll().build().<BoardSearchDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(result.getContent())
//                .total((int) result.getTotalElements())
//                .build();
//    }
//
//    public Board boardRead(int bno) {
//        Optional<Board> board = boardRepository.findById(bno);
//
//        log.info(board.get());
//
//        return board.get();
//    }
//
//    public Integer boardModify(BoardDTO boardDTO) {
//        Board board = modelMapper.map(boardDTO, Board.class);
//
//        //카테고리 지정
//        board.setBoardCategory(boardCategoryRepository.findById(boardDTO.getCno()).get());
//
//        List<BoardImageDTO> boardImageDTOList = boardDTO.getBoardImageDTOList();
//
//        int bno = boardRepository.save(board).getBno();
//
//        //itemDTO처리
//        if (boardImageDTOList != null && boardImageDTOList.size() > 0) {
//            List<BoardImage> boardImageList = boardImageDTOList.stream()
//                    .map(boardImageDTO -> {
//                        BoardImage boardImage = BoardImage.builder()
//                                .folderPath(boardImageDTO.getFolderPath())
//                                .fileName(boardImageDTO.getFileName())
//                                .uuid(boardImageDTO.getUuid())
//                                .board(board)
//                                .build();
//
//                        return boardImage;
//                    }).collect(Collectors.toList());
//
//            for (BoardImage image : boardImageList) {
//                boardImageRepository.save(image);
//            }
//
//        }
//
//
//        return bno;
//    }
//
//    //이미지와 db삭제 보드삭제
//    @Transactional
//    public void boardDelete(int bno) {
//
//
//        //bno인 파일 이미지 찾기
//        List<BoardImage> boardImageList = boardImageRepository.findByBoard_Bno(bno);
//        //게시판이미지 파일 삭제 및 db삭제
//        for (BoardImage abc : boardImageList){
//            String fileName = abc.getFileName();
//            String uuid = abc.getUuid();
//            String folderPath = abc.getFolderPath();
//            String srcFileName = null;
//            try {
//                srcFileName = URLDecoder.decode(fileName, "UTF-8");
//                File file = new File("c:\\upload" + File.separator + folderPath + File.separator + uuid + "_" + fileName);
//                boolean result = file.delete();
//
//                File thumbnail = new File(file.getParent(), "s_" + file.getName());
//
//                result = thumbnail.delete();
//
//                boardImageRepository.deleteByBoard_Bno(abc.getBoard().getBno());
//            }catch (UnsupportedEncodingException e){
//                e.printStackTrace();
//            }
//        }
//
//
////        replyRepository.deleteByBoard_Bno(bno);
//
//        //게시판 db삭제
//        boardRepository.deleteById(bno);
//    }
//
//
//
//    //조회수
//    public void views(Long bno){
//        Optional<Board> board = boardRepository.findById(bno);
//        //조회수
//        board.get().setViews(board.get().getViews() + 1L);
//        boardRepository.save(board.get());
//    }
//
//    //read이미지
//    public List<BoardImageDTO> imgRead(int bno){
//        List<BoardImage> boardImageList = boardImageRepository.findByBoard_Bno(bno);
//
//        List<BoardImageDTO> board = boardImageList.stream()
//                .map(image ->{
//                    return BoardImageDTO.builder()
//                            .boardImgno(image.getBoardImgno())
//                            .fileName(image.getFileName())
//                            .folderPath(image.getFolderPath())
//                            .uuid(image.getUuid())
//                            .build();
//                }).collect(Collectors.toList());
//
//        log.info(board);
//        return board;
//    }
//
//    @Transactional
//    public void boardImgDelete(Long bno) {
//
//
//        //ino인 파일 이미지 찾기
//        List<BoardImage>  boardImageList = boardImageRepository.findByBoard_Bno(bno);
//        //상품이미지 파일 삭제 및 db삭제
//        for (BoardImage abc : boardImageList){
//            String fileName = abc.getFileName();
//            String uuid = abc.getUuid();
//            String folderPath = abc.getFolderPath();
//            String srcFileName = null;
//            try {
//                srcFileName = URLDecoder.decode(fileName, "UTF-8");
//                File file = new File("c:\\upload" + File.separator + folderPath + File.separator + uuid + "_" + fileName);
//                boolean result = file.delete();
//
//                File thumbnail = new File(file.getParent(), "s_" + file.getName());
//
//                result = thumbnail.delete();
//
//                boardImageRepository.deleteByBoard_Bno(abc.getBoard().getBno());
//            }catch (UnsupportedEncodingException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    //카테고리
//    public BoardCategory categoryadd(BoardCategoryDTO categoryDTO){
//        BoardCategory boardCategory = modelMapper.map(categoryDTO, BoardCategory.class);
//
//        return boardCategoryRepository.save(boardCategory);
//    }
//
    public List<BoardCategory> categoryList(){
        return boardCategoryRepository.findAll();
    }
//
//    public void categoryDel(Long cno){
//        boardCategoryRepository.deleteById(cno);
//    }


}

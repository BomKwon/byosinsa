package com.example.byosinsa.controller;

import com.example.byosinsa.dto.BoardDTO;
import com.example.byosinsa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;


//    @GetMapping("/list")
//    public void boardListG(PageRequestDTO pageRequestDTO, Model model){
//        model.addAttribute("category", boardService.categoryList());
//        model.addAttribute("board", boardService.getList(pageRequestDTO));
//    }

    @GetMapping("/register")
    public void boardRegisterG(Model model){
        model.addAttribute("category", boardService.categoryList());
    }

    @PostMapping("/register")
    public String boardRegisterP(BoardDTO boardDTO, Model model){
        int bno = boardService.boardRegister(boardDTO);
        model.addAttribute("bno", bno);

        return "/board/register";
    }


//    @GetMapping("/read")
//    public void boardReadG(Model model, int bno){
//
//        model.addAttribute("boardImgDTO", boardService.imgRead(bno));
//        model.addAttribute("boardDTO", boardService.boardRead(bno));
//    }
//
//    @GetMapping("/modify")
//    public void boardModifyG(Model model, int bno){
//        model.addAttribute("category", boardService.categoryList());
//        model.addAttribute("boardImgDTO", boardService.imgRead(bno));
//        model.addAttribute("boardDTO", boardService.boardRead(bno));
//    }
//
//
//
//    @PostMapping("/modify")
//    public String boardModifyP(BoardDTO boardDTO, Model model){
//        int bno = boardService.boardModify(boardDTO);
//        model.addAttribute("deletion", bno);
//
//        return "redirect:/board/list";
//    }
//
//    @GetMapping("/delete")
//    public String boardDeleteG(int bno){
//        boardService.boardDelete(bno);
//
//        return "redirect:/board/list";
//    }
//
//
//    //리스폰스바디를 안하면 받는건 되는데 보내는게 안되는듯?
//    @ResponseBody
//    @PostMapping("/delete/{bno}")
//    public void boardDeleteD(Model model,@PathVariable("bno") int bno){
//        boardService.boardImgDelete(bno);
//    }
//
//    @ResponseBody
//    @PostMapping("/views/{bno}")
//    public void views(@PathVariable("bno") int bno){
//        boardService.views(bno);
//    }
//
//    //카테고리
//    @GetMapping("/category")
//    public void CategoryG(Model model){
//        model.addAttribute("category",boardService.categoryList());
//    }
//
//    @GetMapping("/categoryAdd")
//    public void CategoryAddG(){
//    }
//
//    @PostMapping("/categoryAdd")
//    public void CategoryAddP(Model model, CategoryDTO categoryDTO){
//        boardService.categoryadd(categoryDTO);
//    }
//
//    @ResponseBody
//    @PostMapping("/categoryDel/{cno}")
//    public int CategoryDelP(@PathVariable("cno")int cno){
//        boardService.categoryDel(cno);
//
//        return cno;
//    }
}

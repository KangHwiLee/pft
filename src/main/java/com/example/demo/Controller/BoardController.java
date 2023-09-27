package com.example.demo.Controller;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    //@Autowired private BoardService board;
    @Autowired private BoardRepository board;
    @GetMapping("/board")
    public String board(){
        return "board";
    }
    @GetMapping("/board/write")
    public String write(Model model){
        model.addAttribute("Board", new Board());
        return "board/write";
    }

    @PostMapping("/board/write")
    public String board_write(Board vo){
        vo.setWriter(1);
        
        board.save(vo);
        return "redirect:/board";
    }

    @GetMapping("/board/list")
    public String board_list(Model model
                             ,@PageableDefault(size=10) Pageable pageable
                             ,@RequestParam(required = false, defaultValue = "") String searchText){
        Page<Board> boards = board.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        int startPage = Math.max(1,boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getNumber() + 4);
        System.out.println(startPage);
        System.out.println(endPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "AjaxInclude/boardList";
    }
}

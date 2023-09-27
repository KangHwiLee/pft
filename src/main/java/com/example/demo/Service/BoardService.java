package com.example.demo.Service;

import com.example.demo.repository.BoardRepository;
import com.example.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Service
public class BoardService {

    @Autowired private BoardRepository board;

    @Transactional
    public void save(Board vo){
        board.saveAndFlush(vo);
    }

    public void list(Model model, @PageableDefault(size = 2) Pageable pageable
                        ,String searchText){
       // Page<Board> boards = board.findAll(pageable);

    }

}

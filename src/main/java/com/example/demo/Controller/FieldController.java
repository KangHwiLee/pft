package com.example.demo.Controller;

import com.example.demo.entity.Field;
import com.example.demo.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FieldController {

    @Autowired private FieldRepository fieldRepository;

    @PostMapping("/field_list")
    @ResponseBody
    public List<Field> field_list(){
        return fieldRepository.findAll();
    }

    @PostMapping("/field_add")
    public String field_add(@RequestBody Field field){
        System.out.println(field);
        fieldRepository.save(field);
        return "popup/field_add";
    }

}

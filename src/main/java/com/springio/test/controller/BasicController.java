package com.springio.test.controller;

import com.springio.test.domain.Basic;
import com.springio.test.service.BasicService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;


@Controller
@RequestMapping("/basic")
public class BasicController {

    private BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

//    @GetMapping("/")
//    public String list(@PageableDefault Pageable pageable, Model model){
//        model.addAttribute("basicList", basicService.findBasicList(pageable));
//        return "basicindex";
//    }

    @GetMapping("/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "basicitem";
    }

    @PostMapping("/add")
    public  String add(Basic basic, Model model){
        Basic saveBasic = basicService.saveBasic(basic);
        model.addAttribute("basic", saveBasic);
        return "basicitem";
    }

    @GetMapping("/new")
    public String form(Basic basic){
        return "basicnew";
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> updateBasic(@PathVariable("idx") Long idx, @RequestBody Basic basic){
        basicService.updateBasic(basic, idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBasic(@PathVariable("idx") Long idx){
        basicService.deleteByBasicId(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}

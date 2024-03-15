package com.springio.test.service;

import com.springio.test.domain.Basic;
import com.springio.test.repository.BasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findBasicListCollections(){
        return basicRepository.findAll();
    }

//    public Page<Basic> findBasicList(Pageable pageable){
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
//        return basicRepository.findAll(pageable);
//    }

    public Basic findBasicByIdx(Long idx){
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic getsoneBasic(Long idx){
        return basicRepository.getOne(idx);
    }

    public Basic saveBasic(Basic basic){
         return basicRepository.save(basic);
    }

    public void deleteByBasicId(Long idx){
         basicRepository.deleteById(idx);
    }

    public void updateBasic(Basic basic, Long idx) {
        Basic persistBasic = basicRepository.getOne(idx);
        persistBasic.updateBasic(basic);
        basicRepository.save(persistBasic);
    }
}

package com.springio.test.repository;

import com.springio.test.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasicRepository extends JpaRepository<Basic, Long> {

    List<Basic> findAllByName(final  String name);
    Basic findFirstByName(final String name);
}

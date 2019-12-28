package com.onlinequizz.Responsitory;

import com.onlinequizz.Entity.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITest extends JpaRepository<Test,String> {
    @Query("select count(t) from Test t ")
    Integer findNumTest();


}

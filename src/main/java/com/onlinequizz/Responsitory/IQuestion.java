package com.onlinequizz.Responsitory;

import com.onlinequizz.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestion extends JpaRepository<Question,Integer> {
    @Query("select count(q) from Question q ")
    Integer findNumTest();
}

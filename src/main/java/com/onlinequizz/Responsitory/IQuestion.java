package com.onlinequizz.Responsitory;

import com.onlinequizz.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestion extends JpaRepository<Question,Integer> {
}

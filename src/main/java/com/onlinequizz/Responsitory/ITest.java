package com.onlinequizz.Responsitory;

import com.onlinequizz.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITest extends JpaRepository<Test,String> {
}

package com.onlinequizz.Responsitory;


import com.onlinequizz.Entity.TestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestType extends JpaRepository<TestType,String> {
    TestType findByTestTypeName(String name);
}

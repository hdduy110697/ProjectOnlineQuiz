package com.onlinequizz.Service;

import com.onlinequizz.Entity.Test;

import java.util.List;

public interface ITestService {
    void saveTest(Test test);
    List<Test> findAllTest();
}

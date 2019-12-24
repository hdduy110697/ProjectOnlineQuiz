package com.onlinequizz.Service;

import com.onlinequizz.Entity.Test;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITestService {
    void saveTest(Test test);
    List<Test> findAllTest();
    Page<Test> findAllPaging(int page,int record_page);
}

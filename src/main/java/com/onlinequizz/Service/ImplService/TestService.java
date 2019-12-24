package com.onlinequizz.Service.ImplService;

import com.onlinequizz.Entity.Test;
import com.onlinequizz.Responsitory.ITest;
import com.onlinequizz.Service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {
    @Autowired
    ITest iTest;
    @Override
    public void saveTest(Test test) {
        iTest.save ( test );
    }

    @Override
    public List<Test> findAllTest() {
        return iTest.findAll ();
    }

    @Override
    public Page<Test> findAllPaging(int page,int record_page) {
        Page<Test> tests= iTest.findAll ( PageRequest.of(page, record_page, Sort.by("testId").descending()) );
        return tests;
    }
}

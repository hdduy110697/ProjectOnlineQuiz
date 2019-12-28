package com.onlinequizz.Service.ImplService;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Entity.Test;
import com.onlinequizz.Responsitory.ITest;
import com.onlinequizz.Service.ITestService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
    public List<Test> findAllPaging(int page,int record_page) {
        Page<Test> tests= iTest.findAll ( PageRequest.of(page-1, record_page, Sort.by("testId").descending()) );
        List<Test> pageList = tests.getContent();
        return pageList;
    }

    @Override
    public Integer getNumTest() {
        return iTest.findNumTest ();
    }

    @Override
    public Test findById(String id) {
        return iTest.findById ( id ).get ();
    }

    @Override
    @Transactional
    public void saveQuestion(Set<Question> questions,String idTest) {
        Test test=new Test ();
        test=iTest.findById ( idTest ).get ();
        Hibernate.initialize(test.getQuestions ());
/*        Set<Question> questionDb=test.getQuestions ();
        for (Question quest:questions) {
            if (quest)
        }
        questions.add ( question );*/
        test.setQuestions (questions);
        iTest.save ( test );
    }
}

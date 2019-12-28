package com.onlinequizz.Service;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Entity.Test;
import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

public interface ITestService {
    void saveTest(Test test);
    List<Test> findAllTest();
    List<Test> findAllPaging(int page,int record_page);
    Integer getNumTest();
    Test findById(String id);
    void saveQuestion(Set<Question> questions, String idTest);
}

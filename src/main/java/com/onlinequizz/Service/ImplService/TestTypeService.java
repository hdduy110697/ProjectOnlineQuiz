package com.onlinequizz.Service.ImplService;

import com.onlinequizz.Entity.TestType;
import com.onlinequizz.Responsitory.ITestType;
import com.onlinequizz.Service.ITestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTypeService implements ITestTypeService {
    @Autowired
    ITestType iTestType;
    @Override
    public TestType getByTypeName(String name) {
        return iTestType.findByTestTypeName ( name );
    }
}

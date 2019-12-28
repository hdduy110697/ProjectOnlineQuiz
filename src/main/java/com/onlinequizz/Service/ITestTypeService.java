package com.onlinequizz.Service;

import com.onlinequizz.Entity.TestType;

public interface ITestTypeService {
    TestType getByTypeName(String name);
}

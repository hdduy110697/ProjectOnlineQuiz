/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.Dao;

import com.exam.PR27.entity.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HoangMinh
 */
public interface TestTypeDao extends JpaRepository<TestType, Integer>{
    
}

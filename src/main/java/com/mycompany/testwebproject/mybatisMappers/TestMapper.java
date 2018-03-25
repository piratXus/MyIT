/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebproject.mybatisMappers;

import com.mycompany.testwebproject.dao.type.TestType;

import java.util.List;

/**
 *
 * @author piratXus
 */
public interface TestMapper {
    public List<TestType> getStrTest();
    public List<TestType> getAll();
}

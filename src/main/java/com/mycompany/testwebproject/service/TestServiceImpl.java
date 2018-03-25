/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebproject.service;

import com.mycompany.testwebproject.dao.type.TestType;
import com.mycompany.testwebproject.mybatisMappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author piratXus
 */

@Service
@Transactional
public class TestServiceImpl implements TestService
{

    @Autowired
    TestMapper testMapper;
    
    @Override
    public List<TestType> getStrTest() {
        return testMapper.getAll();
    }
    
}

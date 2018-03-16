/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebproject.Controllers;

import javax.websocket.server.PathParam;
import com.mycompany.testwebproject.dao.type.TestType;
import com.mycompany.testwebproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author piratXus
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "mapper", method = RequestMethod.GET)
    public List<String> getAll(){
        return testService.getStrTest();
    }

    @RequestMapping(value = "test/{nameUser}/id", method = RequestMethod.GET)
    public String testControllerName(
            @PathVariable("nameUser") String name,
            @RequestParam(value = "id",
            required = false,defaultValue = "0") Integer id){

        return "Hellow "+ name + " you id = " + id;

    }
    
    
}

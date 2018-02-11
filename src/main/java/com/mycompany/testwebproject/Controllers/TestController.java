/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testwebproject.Controllers;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author piratXus
 */
@RestController
@RequestMapping("/")
public class TestController {
    
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testController(@RequestParam(value = "id",
            required = false,defaultValue = "0") Integer id){
        return "Hellow test id = " + id;
    }
     @RequestMapping(value = "test/{nameUser}/id", method = RequestMethod.GET)
    public String testControllerName(
            @PathVariable("nameUser") String name,
            @RequestParam(value = "id",
            required = false,defaultValue = "0") Integer id){
        return "Hellow "+ name + " you id = " + id;
    }
    
    
}

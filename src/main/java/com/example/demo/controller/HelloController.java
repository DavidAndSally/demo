package com.example.demo.controller;

import com.example.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiw-a
 */
@RestController
public class HelloController {

    @Autowired
    private Girl girl;
    @GetMapping(value = {"/hello/{id}","/hi/{id}"})
    public String say(@PathVariable String id, @RequestParam(value = "pid", defaultValue = "0") Integer pid) {
        return girl.getName() + id + pid;
    }
}

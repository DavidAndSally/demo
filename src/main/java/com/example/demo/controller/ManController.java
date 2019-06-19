package com.example.demo.controller;

import com.example.demo.dao.ManReposity;
import com.example.demo.domain.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author qiw-a
 */
@RestController
@RequestMapping("/man")
public class ManController {
    @Autowired
    private ManReposity manReposity;

    @GetMapping
    public List<Man> findAll() {
        return manReposity.findAll();
    }

    @PostMapping
    public Man addMan(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        Man man = new Man();
        man.setName(name);
        man.setSex(sex);
        return manReposity.save(man);
    }

    @GetMapping("/{id}")
    public Optional<Man> findOne(@PathVariable("id") Long id) {
        return manReposity.findById(id);
    }

    @DeleteMapping("{id}")
    public Boolean delMan(@PathVariable("id") Long id) {
        manReposity.deleteById(id);
        return true;
    }
}

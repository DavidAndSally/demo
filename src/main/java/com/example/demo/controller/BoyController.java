package com.example.demo.controller;

import com.example.demo.dao.BoyReposity;
import com.example.demo.domain.Boy;
import com.example.demo.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author qiw-a
 */
@RestController
@RequestMapping("/boy")
public class BoyController {
    @Autowired
    private BoyReposity boyReposity;
    @Autowired
    private BoyService boyService;

    @GetMapping
    public List<Boy> findAll() {
        return boyReposity.findAll();
    }

    @PostMapping
    public Boy addBoy(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        Boy boy = new Boy();
        boy.setName(name);
        boy.setSex(sex);
        return boyReposity.save(boy);
    }

    @GetMapping("/{id}")
    public Optional<Boy> findOne(@PathVariable("id") Long id) {
        return boyReposity.findById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean delBoy(@PathVariable("id") Long id) {
        boyReposity.deleteById(id);
        return true;
    }

    @PutMapping("/{id}")
    public Boy updateBoy(@PathVariable Long id, @RequestParam(value = "name", required = false) String name,  @RequestParam(value = "sex", required = false) String sex) {
        Boy boy = new Boy();
        boy.setId(id);
        boy.setName(name);
        boy.setSex(sex);
        return boyReposity.save(boy);
    }

    /**
     * 通过性别查询
     */
    @GetMapping("/sex")
    public List<Boy> findBySex(String sex) {
        return boyReposity.findBySex(sex);
    }

    @GetMapping("/more")
    public void saveMore() {
        boyService.saveMore();
    }

}

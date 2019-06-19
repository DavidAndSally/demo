package com.example.demo.dao;

import com.example.demo.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author qiw-a
 */
public interface BoyReposity extends JpaRepository<Boy, Long> {
    /**
     * 通过性别查询
     */
    List<Boy> findBySex(String sex);
}

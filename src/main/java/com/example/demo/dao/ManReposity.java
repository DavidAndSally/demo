package com.example.demo.dao;

import com.example.demo.domain.Boy;
import com.example.demo.domain.Man;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qiw-a
 */
public interface ManReposity extends JpaRepository<Man, Long> {
}

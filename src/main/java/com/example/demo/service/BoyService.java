package com.example.demo.service;

import com.example.demo.dao.BoyReposity;
import com.example.demo.domain.Boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qiw-a
 */
@Service
public class BoyService {
    @Autowired
    private BoyReposity boyReposity;

    @Transactional(rollbackFor = Exception.class)
    public void saveMore() {
        Boy a  = new Boy();
        a.setId(5L);
        a.setName("哈哈");
        a.setSex("男");
        boyReposity.save(a);

        Boy b = new Boy();
        b.setId(100L);
        a.setName("嘻嘻");
        a.setSex("nnaskjdfkdf");
        boyReposity.save(b);

        //验证事务生效
        int i = 1 / 0;
        System.out.println("测试");
    }
}

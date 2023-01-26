package com.petstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAdminService {
    @Autowired
    private AdminService adminService;
    @Test
    void updateStatusById(){
        adminService.updateStatusById(6,2);
    }
}

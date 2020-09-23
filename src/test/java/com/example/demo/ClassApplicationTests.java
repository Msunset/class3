package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
class ClassApplicationTests {

    @Test
    public void Date(){
        Date data = new Date();
        System.out.println(new SimpleDateFormat("yyMMdd"+System.currentTimeMillis()).format(data));
    }

}

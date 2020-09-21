package com.example.demo.domain;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {

    private Integer id;

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private String sex;

    @ExcelProperty(index = 2)
    private Integer age;

    @ExcelProperty(index = 3)
    private String jg;

    @ExcelProperty(index = 4)
    private String record;

    @ExcelProperty(index = 5)
    private String phone;

    @ExcelProperty(index = 6)
    private String idcard;

    @ExcelProperty(index = 7)
    private String certificateNumber;

}


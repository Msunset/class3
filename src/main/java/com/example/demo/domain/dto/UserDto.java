package com.example.demo.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class UserDto {

    private Integer id;
    private Date timeOne;
    private Date timeTwo;
    private String name;
    private String sex;
    private String idcard;
    private String certificateNumber;



}

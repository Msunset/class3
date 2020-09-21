package com.example.demo.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;



@Data
public class UserDto {

    private String date;
    private String name;
    private String sex;
    private String idcard;
    private String certificateNumber;


}

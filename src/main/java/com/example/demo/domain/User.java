package com.example.demo.domain;


import com.alibaba.excel.annotation.ExcelProperty;
import com.example.demo.domain.dto.UserDto;
import lombok.Data;

import java.util.Date;


@Data
public class User  {

    private Integer id;

    @ExcelProperty(index = 0)
//    @ExcelProperty(value = "姓名")
    private String name;

//    @ExcelProperty(value = "性别")
    @ExcelProperty(index = 1)
    private String sex;

//    @ExcelProperty(value = "年龄")
    @ExcelProperty(index = 2)
    private Integer age;

//    @ExcelProperty(value = "籍贯")
    @ExcelProperty(index = 3)
    private String jg;

//    @ExcelProperty(value = "学历")
    @ExcelProperty(index = 4)
    private String record;

//    @ExcelProperty(value = "联系电话")
    @ExcelProperty(index = 5)
    private String phone;

//    @ExcelProperty(value = "身份证号码")
    @ExcelProperty(index = 6)
    private String idcard;

//    @ExcelProperty(value = "证书编号")
    @ExcelProperty(index = 7)
    private String certificateNumber;

    @ExcelProperty(index = 8)
    private Date timeOne;

    @ExcelProperty(index = 9)
    private Date timeTwo;

}


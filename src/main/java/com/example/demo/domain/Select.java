package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Select {

//    @ApiModelProperty(value = "")
    private Integer id;

    @ExcelProperty( index = 0)
    private String title;

    @ExcelProperty( index = 1)
    private String selectA;

    @ExcelProperty( index = 2)
    private String selectB;

    @ExcelProperty( index = 3)
    private String selectC;

    @ExcelProperty( index = 4)
    private String selectD;

    @ExcelProperty( index = 5)
    private String answer;

}
package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("")
public class Judge {

//    @ApiModelProperty(value = "")
    private Integer id;

    @ExcelProperty(index = 0)
    private String title;

    @ExcelProperty(index = 1)
    private String answer;

}
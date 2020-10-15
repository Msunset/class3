package com.example.demo.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class SelectDto {

    @ApiModelProperty(value = "试题")
    private String title;

    @ApiModelProperty(value = "选项A")
    private String selectA;

    @ApiModelProperty(value = "选项B")
    private String selectB;

    @ApiModelProperty(value = "选项C")
    private String selectC;

    @ApiModelProperty(value = "选项D")
    private String selectD;

}

package com.example.demo.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class JudgeDto {
    @ApiModelProperty(value = "索引")
    private Integer index;

    @ApiModelProperty(value = "试题")
    private String title;



}

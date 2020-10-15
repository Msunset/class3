package com.example.demo.mapper;

import com.example.demo.domain.Judge;
import com.example.demo.domain.JudgeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeMapper {
    int countByExample(JudgeExample example);

    int deleteByExample(JudgeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Judge record);

    int insertSelective(Judge record);

    List<Judge> selectByExample(JudgeExample example);

    Judge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Judge record, @Param("example") JudgeExample example);

    int updateByExample(@Param("record") Judge record, @Param("example") JudgeExample example);

    int updateByPrimaryKeySelective(Judge record);

    int updateByPrimaryKey(Judge record);


    void saveJudgeTitle(List<Judge> judges);//判断题插入
}
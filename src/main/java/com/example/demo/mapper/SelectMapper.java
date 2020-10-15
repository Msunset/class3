package com.example.demo.mapper;

import com.example.demo.domain.Select;
import com.example.demo.domain.SelectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectMapper {
    int countByExample(SelectExample example);

    int deleteByExample(SelectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Select record);

    int insertSelective(Select record);

    List<Select> selectByExample(SelectExample example);

    Select selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Select record, @Param("example") SelectExample example);

    int updateByExample(@Param("record") Select record, @Param("example") SelectExample example);

    int updateByPrimaryKeySelective(Select record);

    int updateByPrimaryKey(Select record);


    void saveSelectTitle(List<Select> select);//插入选择题
}
package com.example.demo.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.domain.Judge;
import com.example.demo.domain.Select;
import com.example.demo.domain.dto.JudgeAnswerDto;
import com.example.demo.domain.dto.JudgeDto;
import com.example.demo.domain.dto.SelectAnswerDto;
import com.example.demo.domain.dto.SelectDto;
import com.example.demo.mapper.JudgeMapper;
import com.example.demo.mapper.SelectMapper;
import com.example.demo.utils.CompressUtil;
import com.example.demo.utils.WordUtil;
import freemarker.template.TemplateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TestPaperService {
    @Autowired
    private SelectMapper selectMapper;
    @Autowired
    private JudgeMapper judgeMapper;
    @Value("${source.url}")
    private String source;
    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${target.url}")
    private String target;
    private static final String testPaper="testPaper.ftl";
    private static final String testPaperAnswer="testPaperAnswer.ftl";

    public String randomTestTitle(Integer selectNum, Integer judgeNum) throws IOException, TemplateException {

        ArrayList<SelectDto> selectDtos = new ArrayList<>();
        ArrayList<JudgeDto> judgeDtos = new ArrayList<>();
        ArrayList<SelectAnswerDto> selectAnswerDtos = new ArrayList<>();
        ArrayList<JudgeAnswerDto> judgeAnswerDtos = new ArrayList<>();

        List<Select> selects = selectMapper.selectByExample(null);
        List<Judge> judges = judgeMapper.selectByExample(null);
        if (selects.size()<selectNum||judges.size()<judgeNum)
            return "-1";
        Collections.shuffle(selects);
        List<Select> randomSeries = selects.subList(0, selectNum);
        for (Select randomSery : randomSeries) {
            SelectDto selectDto = new SelectDto();
            SelectAnswerDto selectAnswerDto = new SelectAnswerDto();
            BeanUtils.copyProperties(randomSery,selectDto);
            BeanUtils.copyProperties(randomSery,selectAnswerDto);
            selectDtos.add(selectDto);
            selectAnswerDtos.add(selectAnswerDto);
        }
        Collections.shuffle(judges);
        List<Judge> randomJudges = judges.subList(0, judgeNum);
        for (int i = 0; i < randomJudges.size(); i++) {
            JudgeDto judgeDto = new JudgeDto();
            JudgeAnswerDto judgeAnswerDto = new JudgeAnswerDto();
            judgeAnswerDto.setIndex(selectNum+i+1);
            judgeDto.setIndex(selectNum+i+1);
            BeanUtils.copyProperties(randomJudges.get(i),judgeDto);
            BeanUtils.copyProperties(randomJudges.get(i),judgeAnswerDto);
            judgeDtos.add(judgeDto);
            judgeAnswerDtos.add(judgeAnswerDto);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("list", selectDtos);
        dataMap.put("listV", judgeDtos);
        Map<String,Object> dataMapAnswer = new HashMap<>();
        dataMapAnswer.put("list", selectAnswerDtos);
        dataMapAnswer.put("listV", judgeAnswerDtos);
        String folder =  new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format( new Date());
        //生成试卷
        WordUtil.testPaperWord(dataMap,source,testPaper,"试题",target+folder+"/",folder);
        //生成答案
        WordUtil.testPaperWord(dataMapAnswer,source,testPaperAnswer,"答案",target+folder+"/",folder);
        CompressUtil.compress(target+folder , target+folder);
        return baseUrl+folder+".zip";
    }

    //插入选择题
    public void selectTitle(List<Select> select){

        selectMapper.saveSelectTitle(select);
    }

    //插入判断题
    public void judgeTitle(List<Judge> judges){

        judgeMapper.saveJudgeTitle(judges);
    }

}

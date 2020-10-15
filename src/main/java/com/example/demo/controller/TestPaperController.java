package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.domain.Judge;
import com.example.demo.domain.Select;
import com.example.demo.domain.User;
import com.example.demo.service.TestPaperService;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/TestPaper")
@Api(tags = "试卷控制器")
public class TestPaperController {

    @Autowired
    private TestPaperService testPaperService;

    @GetMapping("/randomTestTitle")
    @ApiOperation("生成随机测试题")
    public String randomTestTitle(@RequestParam(required = false, defaultValue = "20") Integer selectNum,
                                  @RequestParam(required = false, defaultValue = "30") Integer judgeNum) throws IOException, TemplateException {
        return testPaperService.randomTestTitle(selectNum, judgeNum);

    }

    @PostMapping("/excelSelect")
    @ApiOperation("excel选择题导入")
    public String test(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Select.class, new AnalysisEventListener<Select>() {
            private static final int BATCH_COUNT = 3000;
            List<Select> list = new ArrayList<Select>();

            @Override
            public void invoke(Select select, AnalysisContext analysisContext) {
                list.add(select);
                if (list.size() >= BATCH_COUNT) {
                    list.clear();
                }
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                saveData();
            }

            private void saveData() {
                testPaperService.selectTitle(list);
            }
        }).sheet().doRead();

        return "导入成功";
    }

    @PostMapping("/excelJudge")
    @ApiOperation("excel判断题导入")
    public String testOne(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Judge.class, new AnalysisEventListener<Judge>() {
            private static final int BATCH_COUNT = 3000;
            List<Judge> list = new ArrayList<Judge>();

            @Override
            public void invoke(Judge judge, AnalysisContext analysisContext) {
                list.add(judge);
                if (list.size() >= BATCH_COUNT) {
                    list.clear();
                }
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                saveData();
            }

            private void saveData() {
                testPaperService.judgeTitle(list);
            }
        }).sheet().doRead();

        return "导入成功";
    }

}

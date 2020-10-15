package com.example.demo.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.*;
import java.util.Date;
import java.util.Map;


public class WordUtil {

    public static String testPaperWord (Map<String,Object> dataMap,String source,
                                        String sourceFileName,String flag,
                                        String target,String outFileName) throws IOException, TemplateException {
        Configuration configuration = new Configuration(new Version("2.3.0"));
        configuration.setDefaultEncoding("utf-8");

        configuration.setDirectoryForTemplateLoading(new File(source));
        //输出文件名称
        String fileName =  outFileName +"---"+flag+ ".doc";
        File file = new File(target);
        if (!file.exists()){
            file.mkdir();
        }
        File outFile = new File(target+fileName);
        Template template = configuration.getTemplate(sourceFileName, "utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
        template.process(dataMap, out);
        out.close();
        return fileName;
    }
}

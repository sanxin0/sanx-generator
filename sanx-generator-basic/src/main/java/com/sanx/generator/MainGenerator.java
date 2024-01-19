package com.sanx.generator;

import com.sanx.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 * 动静结合：组合调用两个生成器，先复制静态文件，再动态生成文件覆盖即可
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("散心");
        mainTemplateConfig.setOutputText("结果");
        mainTemplateConfig.setLoop(false);
        doGenerator(mainTemplateConfig);
    }

    public static void doGenerator(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);//D:\java\pro\sanxin-generator\code\sanx-generator
        //输入路径
        String inputPath = new File(projectPath,"sanx-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = projectPath;
        //生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
        //生成动态文件  D:\java\pro\sanxin-generator\code\sanx-generator\acm-template
        String inputDynamicFilePath = projectPath + File.separator + "sanx-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/sanx/acm/MainTemplate.java";
        DynamicGenerator.doGenerator(inputDynamicFilePath,outputDynamicFilePath,model);
    }

}

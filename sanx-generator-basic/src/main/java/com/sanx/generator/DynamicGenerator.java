package com.sanx.generator;

import com.sanx.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * 动态文件生成器
 */
public class DynamicGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "sanx-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println(inputPath);
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        System.out.println(outputPath);
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("sanxin");
        mainTemplateConfig.setOutputText("输出结果");
        mainTemplateConfig.setLoop(false);
        doGenerator(inputPath,outputPath,mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(String inputPath,String outputPath,Object model) throws IOException, TemplateException {
        //new出Configuration对象，参数为FreeMarker对象
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

//        String projectPath = System.getProperty("user.dir") + File.separator + "sanx-generator-basic";
//        File parentFile = new File(projectPath);
//        File file = new File(parentFile,"src/main/resources/templates");

        //指定模板文件所在的路径
//        cfg.setDirectoryForTemplateLoading(file);

        //获取文件目录的所在父目录，将其设置为模板目录
        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);

        //设置模板文件使用的字符集
        cfg.setDefaultEncoding("UTF-8");
        cfg.setNumberFormat("0.######");

        //创建模板对象，加载指定模板
        //Template template = cfg.getTemplate("MainTemplate.java.ftl");
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);

        //创建数据模型
//        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
//        mainTemplateConfig.setAuthor("sanxin");
//        mainTemplateConfig.setOutputText("输出结果");
//        mainTemplateConfig.setLoop(true);

        Writer out = new FileWriter(outputPath);

        template.process(model,out);

        out.close();
    }
}

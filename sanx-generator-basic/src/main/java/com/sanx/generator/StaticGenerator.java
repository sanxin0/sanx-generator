package com.sanx.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成器
 */
public class StaticGenerator {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = projectPath + File.separator + "sanx-generator-demo-projects" + File.separator + "acm-template";
        System.out.println(inputPath);

        //输出路径
        String outputPath = projectPath;
        //复制
        copyFilesByHutool(inputPath,outputPath);
    }

    /**
     * 拷贝文件（Hutool实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

}



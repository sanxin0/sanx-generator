package com.sanx.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class MainTemplateConfig {

    /**
     * 动态生成的需求：
     * 1、在代码开头增加@author注解
     * 2、修改程序输出的信息提示
     * 3、将循环读取输入改为单次读取（可选代码）
     */

    private String author = "sanxin";

    private String outputText = "输出结果";

    /**
     * 是否循环
     */
    private boolean loop;
}

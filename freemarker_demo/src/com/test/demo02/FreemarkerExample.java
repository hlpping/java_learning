package com.test.demo02;  
  
import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.HashMap;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.DefaultObjectWrapper;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
  
public class FreemarkerExample {  
  
    /** 
     * @param args 
     * @throws IOException  
     * @throws TemplateException 
     */  
    public static void main(String[] args) throws IOException, TemplateException {  
         /* 在整个应用的生命周期中，这个工作你应该只做一次。 */    
        /* 创建和调整配置。 */   
        Configuration cfg = new Configuration();   
        cfg.setDirectoryForTemplateLoading(new File("src"));   
        cfg.setObjectWrapper(new DefaultObjectWrapper());   
        /* 在整个应用的生命周期中，这个工作你可以执行多次 */    
        /* 获取或创建模板*/   
        Template temp = cfg.getTemplate("test03.ftl");   
        /* 创建数据模型 */   
        Map<String ,Object> root = new HashMap<String ,Object>();   
        root.put("user", "Big Joe");   
        Map<String ,Object> latest = new HashMap<String ,Object>();   
        root.put("latestProduct", latest);   
        latest.put("url", "products/greenmouse.html");   
        latest.put("name", "green mouse");   
        /* 将模板和数据模型合并 */   
        Writer out = new OutputStreamWriter(System.out);   
        //输出到文件  
        //Writer out = new OutputStreamWriter(new FileOutputStream("e:/temp/helloword.html"),"GBK");   
       
        temp.process(root, out);   
        out.flush();   
  
    }  
  
}  
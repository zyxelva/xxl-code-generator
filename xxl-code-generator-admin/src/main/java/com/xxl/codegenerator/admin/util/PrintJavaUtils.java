package com.xxl.codegenerator.admin.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @ClassName: PrintJavaUtils
 * @Author: zyxelva
 * @Date: 18.12.29.029 11:01:21
 * @Version: V1.0.0
 * @Description: 打印java文件至目录当中
 */
@Component
public class PrintJavaUtils {
    private static final Logger logger = LoggerFactory.getLogger(PrintJavaUtils.class);

    private static String filePath;

    @Value("${filePath}")
    public void setFilePath(String filePath) {
        PrintJavaUtils.filePath = filePath;
    }

    public static String getFilePath() {
        return filePath;
    }

    //字符流 (输出流中含有中文时使用字符流)
    public static void charOutStream(String fileName, String sourceString) throws Exception {
        if (StringUtils.isEmpty(fileName)) {
            logger.error("charOutStream, but fileName is null");
            return;
        }
        if (StringUtils.isEmpty(sourceString)) {
            logger.error("charOutStream, but sourceString is null");
            return;
        }
        // 1：利用File类找到要操作的对象
        File file = new File(PrintJavaUtils.getFilePath() + File.separator + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        //2：准备输出流
        Writer out = new FileWriter(file);
        out.write(sourceString);
        out.close();

    }

    //字节流
    public static void byteOutStream(String fileName, String sourceString) throws Exception {
        if (StringUtils.isEmpty(fileName)) {
            logger.error("byteOutStream, but fileName is null");
            return;
        }
        if (StringUtils.isEmpty(sourceString)) {
            logger.error("byteOutStream, but sourceString is null");
            return;
        }
        //1:使用File类创建一个要操作的文件路径
        File file = new File(PrintJavaUtils.getFilePath() + File.separator + fileName);
        if (!file.getParentFile().exists()) { //如果文件的目录不存在
            file.getParentFile().mkdirs(); //创建目录

        }

        //2: 实例化OutputString 对象
        OutputStream output = new FileOutputStream(file);

        //3: 准备好实现内容的输出

//        String msg = "HelloWorld";
        //将字符串变为字节数组
        byte data[] = sourceString.getBytes();
        output.write(data);
        //4: 资源操作的最后必须关闭
        output.close();

    }
}

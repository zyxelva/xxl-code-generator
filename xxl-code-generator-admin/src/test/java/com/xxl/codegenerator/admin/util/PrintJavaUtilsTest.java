package com.xxl.codegenerator.admin.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName: PrintJavaUtilsTest
 * @Author: zyxel
 * @Date: 18.12.29.029 17:32:03
 * @Version: V1.0.0
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintJavaUtilsTest {
    @Autowired
    PrintJavaUtils printJavaUtils;

    @Test
    public void charOutStream() throws Exception {
        PrintJavaUtils.charOutStream("tesssssrrrrrrr.txt","dfdjlsfjlsdfjsdklfjsdlkfjsdlkfjsdlfjsdf");
        System.out.println("==============="+PrintJavaUtils.getFilePath());
    }
}
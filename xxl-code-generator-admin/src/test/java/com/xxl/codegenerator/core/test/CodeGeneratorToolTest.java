package com.xxl.codegenerator.core.test;


import com.xxl.codegenerator.admin.core.CodeGeneratorTool;
import com.xxl.codegenerator.admin.core.model.ClassInfo;
import com.xxl.codegenerator.admin.util.PrintJavaUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xuxueli 2018-05-02 20:30:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGeneratorToolTest {
    @Autowired
    PrintJavaUtils printJavaUtils;

    @Test
    public void codeGeneratorToolTest() throws IOException  {

        // table sql
        FileInputStream fileInputStream = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("table.sql").getPath());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        StringBuffer stringBuffer = new StringBuffer();
        String lineTmp = null;
        while ((lineTmp = bufferedReader.readLine()) != null) {
            stringBuffer.append(lineTmp);
        }
        bufferedReader.close();

        String tableSql = stringBuffer.toString();

        // code generate
        ClassInfo classInfo = CodeGeneratorTool.processTableIntoClassInfo(tableSql);

    }

}

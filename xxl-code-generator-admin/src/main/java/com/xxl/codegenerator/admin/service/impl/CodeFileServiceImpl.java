package com.xxl.codegenerator.admin.service.impl;

import com.xxl.codegenerator.admin.core.model.ClassInfo;
import com.xxl.codegenerator.admin.service.CodeFileService;
import com.xxl.codegenerator.admin.util.PrintJavaUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: CodeFileServiceImpl
 * @Author: zyxel
 * @Date: 18.12.29.029 17:58:39
 * @Version: V1.0.0
 * @Description: TODO
 */
@Service
public class CodeFileServiceImpl implements CodeFileService {
    private static final Logger logger = LoggerFactory.getLogger(CodeFileServiceImpl.class);

    @Async
    @Override
    public void codeFileGenerator(Map<String, String> codeMap, ClassInfo classInfo) throws Exception {
        if (codeMap.isEmpty()) {
            logger.error("codeFileGenerator, but codeMap is empty.");
            return;
        }

        if (null == classInfo) {
            logger.error("codeFileGenerator, but classInfo is null.");
            return;
        }

        logger.info("==================Start to Generate Files.==================");

        if (StringUtils.isNotEmpty(codeMap.get("controller_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + "Controller.java", codeMap.get("controller_code"));
            logger.info("codeFileGenerator, Controller File is Done.");
        }

        if (StringUtils.isNotEmpty(codeMap.get("service_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + "Service.java", codeMap.get("service_code"));
            logger.info("codeFileGenerator, Service File is Done.");
        }

        if (StringUtils.isNotEmpty(codeMap.get("service_impl_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + "ServiceImpl.java", codeMap.get("service_impl_code"));
            logger.info("codeFileGenerator, ServiceImpl File is Done.");
        }

        if (StringUtils.isNotEmpty(codeMap.get("dao_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + "Dao.java", codeMap.get("dao_code"));
            logger.info("codeFileGenerator, Dao File is Done.");
        }

        if (StringUtils.isNotEmpty(codeMap.get("mybatis_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + "Dao.xml", codeMap.get("mybatis_code"));
            logger.info("codeFileGenerator, Xml File is Done.");
        }

        if (StringUtils.isNotEmpty(codeMap.get("model_code"))) {
            PrintJavaUtils.charOutStream(classInfo.getClassName() + ".java", codeMap.get("model_code"));
            logger.info("codeFileGenerator, Model File is Done.");
        }

        logger.info("==================The End.==================");
    }
}

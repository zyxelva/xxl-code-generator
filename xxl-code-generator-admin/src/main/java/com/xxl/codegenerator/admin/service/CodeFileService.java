package com.xxl.codegenerator.admin.service;

import com.xxl.codegenerator.admin.core.model.ClassInfo;

import java.util.Map;

/**
 * @ClassName: CodeFileService
 * @Author: zyxel
 * @Date: 18.12.29.029 17:56:32
 * @Version: V1.0.0
 * @Description:
 */
public interface CodeFileService {
    void codeFileGenerator(Map<String,String> codeMap, ClassInfo classInfo) throws Exception;
}

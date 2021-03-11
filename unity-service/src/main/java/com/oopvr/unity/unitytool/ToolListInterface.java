package com.oopvr.unity.unitytool;

import java.io.File;
import java.util.List;

public interface ToolListInterface {

    /**
     * 磁盘IO,文件夹处理
     * @param fileDir
     * @return
     */
    List<File> readFile(String fileDir);
}

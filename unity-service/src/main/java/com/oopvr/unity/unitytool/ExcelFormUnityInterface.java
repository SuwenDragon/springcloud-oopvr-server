package com.oopvr.unity.unitytool;

import com.oopvr.unity.pojo.*;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface ExcelFormUnityInterface {

    /**
     * 读取明细表数据
     *
     * @param path
     * @return
     * @throws Exception
     */
    Map<String, HashMap<String, NumberData>> readingSheet(String path) throws Exception;

    /**
     * 读取仓库配书表
     *
     * @param path
     * @return
     * @throws Exception
     */
    List<WarehouseData> readingMatchSheet(String path) throws Exception;

    /**
     * 写数据
     *
     * @param sourceExcelData
     * @param path
     * @return
     * @throws Exception
     */
    String writeSheet(SourceExcelData sourceExcelData, String path, int xs) throws Exception;

    String writeMatchSheet(WarehouseMaxData warehouseMaxData, String path) throws Exception;

    Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> list1, List<CompleteData> list2);

    Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> list1);
}

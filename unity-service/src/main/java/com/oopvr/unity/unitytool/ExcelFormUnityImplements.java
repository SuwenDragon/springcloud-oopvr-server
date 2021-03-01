package com.oopvr.unity.unitytool;

import com.oopvr.unity.pojo.NumberData;
import com.oopvr.unity.pojo.SourceExcelData;
import com.oopvr.unity.pojo.WarehouseData;
import com.oopvr.unity.pojo.WarehouseMaxData;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableRead;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableWrite;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelFormUnityImplements implements ExcelFormUnityInterface {
    @Override
    public Map<String, HashMap<String, NumberData>> readingSheet(String path) throws Exception {
        return new SchoolTableRead().readingSheet(path);
    }

    @Override
    public List<WarehouseData> readingMatchSheet(String path) throws Exception {
        return new SchoolTableRead().readingMatchSheet(path);
    }

    @Override
    public String writeSheet(SourceExcelData sourceExcelData, String path) throws Exception {
        return new SchoolTableWrite().writeSheet(sourceExcelData,path);
    }

    @Override
    public String writeMatchSheet(WarehouseMaxData warehouseMaxData, String path) throws Exception {
        return new SchoolTableWrite().writeMatchSheet(warehouseMaxData,path);
    }
}

package com.oopvr.unity.unitytool;

import com.oopvr.unity.pojo.*;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableData;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableRead;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
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
    public String writeSheet(SourceExcelData sourceExcelData, String path,int xs) throws Exception {
        return new SchoolTableWrite().writeSheet(sourceExcelData,path,xs);
    }

    @Override
    public String writeMatchSheet(WarehouseMaxData warehouseMaxData, String path) throws Exception {
        return new SchoolTableWrite().writeMatchSheet(warehouseMaxData,path);
    }

    @Override
    public Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> list1, List<CompleteData> list2) {
        return new SchoolTableData().handleData(list1,list2);
    }

    @Override
    public Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> list) {
        return new SchoolTableData().handleData(list);
    }

}

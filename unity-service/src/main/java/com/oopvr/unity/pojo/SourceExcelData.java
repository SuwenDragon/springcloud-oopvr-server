package com.oopvr.unity.pojo;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.*;

@Data
public class SourceExcelData {
    public String date;  //日期
    public String name;   //名称
    public String frequency;  //(一次性)，（第一次）
    public double discount;    //优惠
    public List<CompleteData>  completeData;
    public Map<String, HashMap<String,NumberData>> map;

}

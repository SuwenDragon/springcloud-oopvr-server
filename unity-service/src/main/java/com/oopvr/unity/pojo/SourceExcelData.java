package com.oopvr.unity.pojo;

import lombok.Data;

import java.util.*;

@Data
public class SourceExcelData {
    public String date;  //日期
    public String name;   //名称
    public String frequency;  //(一次性)，（第一次）
    public double discount;    //优惠
    public List<CompleteData>  completeData;
    public Map<String, HashMap<String,NumberData>> map; //正常数据
    public Map<String, HashMap<String,NumberData>> mapSum; //结算奖状
    public SourceExcelSingleData sourceExcelSingleData;

    public Map<String, HashMap<String,NumberData>> maxMap;
}

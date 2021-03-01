package com.oopvr.unity.pojo;

import lombok.Data;

import java.util.List;

@Data
public class WarehouseMaxData {
    public String date;  //日期
    public String name;   //名称
    public String managerName; //经理
    public String code;   //编号
    public List<WarehouseData> warehouseDataList; //商品统计
    List<CompleteData> list;  //明细


}

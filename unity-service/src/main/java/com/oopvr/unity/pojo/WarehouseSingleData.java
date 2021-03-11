package com.oopvr.unity.pojo;

import lombok.Data;

import java.util.List;

/**
 * 单本统计数据
 */
@Data
public class WarehouseSingleData {
    public List<WarehouseData> warehouseDataList; //商品统计
    public List<CompleteData> list;  //明细
}

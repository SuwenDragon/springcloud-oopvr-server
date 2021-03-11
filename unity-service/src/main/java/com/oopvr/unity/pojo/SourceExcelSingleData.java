package com.oopvr.unity.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 单本明细，统计数据
 */
@Data
public class SourceExcelSingleData {
    public List<CompleteData> completeData;
    public Map<String, HashMap<String,NumberData>> map;
}

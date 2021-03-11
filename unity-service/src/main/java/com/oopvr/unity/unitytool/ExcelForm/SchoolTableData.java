package com.oopvr.unity.unitytool.ExcelForm;

import com.oopvr.unity.pojo.CompleteData;
import com.oopvr.unity.pojo.NumberData;
import com.oopvr.unity.unitytool.ExcelFormUnityImplements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolTableData extends ExcelFormUnityImplements {

    private final String[] str = {"一年级", "二年级","三年级","四年级","五年级","六年级",
            "初一","初二","初三",
            "高一","高二","高三",
            "大一","大二","大三","大四", "小小班", "小班", "中班", "大班", "学前班", "宝宝班", "国际班"};


    @Override
    public Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> list1, List<CompleteData> list2) {
        Map<String, HashMap<String, NumberData>> maxmap = new HashMap<>();
        List<CompleteData> list = addRs(list1, list2);
        for (int i = 0;i<str.length;i++){
            HashMap<String, NumberData> classGroup = new HashMap(); //存班级数据
             for (int j = 0;j<list.size();j++){
                 if (list.get(j).getGrade().contains(str[i])){
                     if (classGroup.containsKey(list.get(j).getGradeClass())){
                         NumberData numberData = classGroup.get(list.get(j).getGradeClass());
                          numberData.addNumber(Integer.valueOf(list.get(j).getNumber()));
                          numberData.addMoney(Double.valueOf(list.get(j).getPaymentMoney()));
                     }else {
                         NumberData numberDatas = new NumberData();
                         numberDatas.setNumber(Integer.valueOf(list.get(j).getNumber()));
                         numberDatas.setMoney(Double.valueOf(list.get(j).getPaymentMoney()));
                         classGroup.put(list.get(j).getGradeClass(),numberDatas);
                     }

                 }
             }
            if (classGroup.size()!= 0) maxmap.put(str[i],classGroup);
        }
        return maxmap;
    }

    @Override
    public Map<String, HashMap<String, NumberData>> handleData(List<CompleteData> listCompleteData) {
        Map<String, HashMap<String, NumberData>> maxmap = new HashMap<>();
        List<CompleteData> list = addRs(listCompleteData);
        for (int i = 0;i<str.length;i++){
            HashMap<String, NumberData> classGroup = new HashMap(); //存班级数据
            for (int j = 0;j<list.size();j++){
                if (list.get(j).getGrade().contains(str[i])){
                    if (classGroup.containsKey(list.get(j).getGradeClass())){
                        NumberData numberData = classGroup.get(list.get(j).getGradeClass());
                        numberData.addNumber(Integer.valueOf(list.get(j).getNumber()));
                        numberData.addMoney(Double.valueOf(list.get(j).getPaymentMoney()));
                    }else {
                        NumberData numberDatas = new NumberData();
                        numberDatas.setNumber(Integer.valueOf(list.get(j).getNumber()));
                        numberDatas.setMoney(Double.valueOf(list.get(j).getPaymentMoney()));
                        classGroup.put(list.get(j).getGradeClass(),numberDatas);
                    }

                }
            }
            if (classGroup.size()!= 0) maxmap.put(str[i],classGroup);

        }
        return maxmap;
    }
    private List<CompleteData> addRs(List<CompleteData> list1,List<CompleteData> list2){

           List<CompleteData> listCompleteData = new ArrayList<>();

           if (list1!=null && list2!=null){
              listCompleteData.addAll(list1);
              listCompleteData.addAll(list2);

//         for (int i = 1;i<list2.size();i++){
//             listCompleteData.add(list2.get(i));
//         }
               return listCompleteData;
           }

           if (list1!=null) listCompleteData = list1;
           if (list2 !=null ) listCompleteData = list2;
        return  listCompleteData;
    }
    private List<CompleteData> addRs(List<CompleteData> list){
        return  list;
    }

}

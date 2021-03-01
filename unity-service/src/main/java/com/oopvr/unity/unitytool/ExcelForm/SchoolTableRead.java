package com.oopvr.unity.unitytool.ExcelForm;

import com.oopvr.unity.pojo.CompleteData;
import com.oopvr.unity.pojo.NumberData;
import com.oopvr.unity.pojo.WarehouseData;
import org.apache.poi.hssf.usermodel.*;
import com.oopvr.unity.unitytool.ExcelFormUnityImplements;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;


public class SchoolTableRead extends ExcelFormUnityImplements {
    private final String[] str = {"一年级", "二年级","三年级","四年级","五年级","六年级",
            "初一","初二","初三",
            "高一","高二","高三",
            "大一","大二","大三","大四", "小小班", "小班", "中班", "大班", "学前班", "宝宝班", "国际班"};
     private int index;
     public List<CompleteData> list;


    @Override
    public Map<String, HashMap<String,NumberData>> readingSheet(String path) throws Exception {
        InputStream ips = new FileInputStream(path);  //磁盘io流
        HSSFWorkbook wb = new HSSFWorkbook(ips);    //得到Excel工作簿对象
        HSSFSheet sheet = wb.getSheetAt(0);  //得到Excel工作表对象
        this.index = sheet.getLastRowNum() + 1;    //获得Excel工作表对象有效行数

            List listGrade = new ArrayList();  //获取所有年级
        this.list = new ArrayList();  //获取所有数据
        CompleteData completeData = new CompleteData();
        HSSFRow row0 = sheet.getRow(0);  //获得Excel工作表对象第0行
        completeData.setSchoolType(row0.getCell((short) 0).toString());
        completeData.setGrade(row0.getCell((short) 1).toString());
        completeData.setGradeClass(row0.getCell((short) 2).toString());
        completeData.setOrderCode(row0.getCell((short) 3).toString());
        completeData.setCommodity(row0.getCell((short) 4).toString());
        completeData.setStudentName(row0.getCell((short) 5).toString());
        completeData.setPaymentMoney(row0.getCell((short) 6).toString());
        completeData.setNumber(row0.getCell((short) 7).toString());
        completeData.setTelephone(row0.getCell((short) 8).toString());
        completeData.setAddress(row0.getCell((short) 9).toString());
        completeData.setDistributionType(row0.getCell((short) 10).toString());
        completeData.setState(row0.getCell((short) 11).toString());
        completeData.setMessage(row0.getCell((short) 12).toString());
        list.add(completeData);
        for (int i = 1; i < index; i++) {
            CompleteData completeDatas = new CompleteData();
            HSSFRow row = sheet.getRow(i);  //获得Excel工作表对象第一行
            HSSFCell cell = row.getCell((short) 1); //得到Excel工作表指定行的单元格
            listGrade.add(cell.toString());

            completeDatas.setSchoolType(row.getCell((short) 0).toString());
            completeDatas.setGrade(row.getCell((short) 1).toString());
            completeDatas.setGradeClass(row.getCell((short) 2).toString());
            completeDatas.setOrderCode(row.getCell((short) 3).toString());
            completeDatas.setCommodity(row.getCell((short) 4).toString());
            completeDatas.setStudentName(row.getCell((short) 5).toString());
            completeDatas.setPaymentMoney(row.getCell((short) 6).toString());
            completeDatas.setNumber(row.getCell((short) 7).toString());
            completeDatas.setTelephone(row.getCell((short) 8).toString());
            completeDatas.setAddress(row.getCell((short) 9).toString());
            completeDatas.setDistributionType(row.getCell((short) 10).toString());
            completeDatas.setState(row.getCell((short) 11).toString());
            completeDatas.setMessage(row.getCell((short) 12).toString());
            list.add(completeDatas);

        }

        Map<String, HashMap<String, NumberData>> map = new HashMap<>();
        if (listGrade != null) {
            for (int i = 0; i < str.length; i++) {   //遍历所有年级
                if (listGrade.contains(str[i])) {
                    HashMap<String, NumberData> classGroup = new HashMap(); //存班级数据
                    for (int j = 1; j < index; j++) {  //获取所有班级
                        HSSFRow row = sheet.getRow(j);
                        HSSFCell cell = row.getCell((short) 1);
                        if (cell.toString().equals(str[i])) {   //如果这个班级的年级对的上就获得
                            NumberData numberData = new NumberData();   //存数量，金额
                            HSSFCell cellClass = row.getCell((short) 2); //得到Excel工作表指定行的单元格
                            if (classGroup.containsKey(cellClass.toString())) {
                                NumberData hnumberData = classGroup.get(cellClass.toString());
                                Double money = hnumberData.getMoney();
                                int number = hnumberData.getNumber();
                                hnumberData.setNumber(Integer.valueOf(row.getCell((short) 7).toString()) + number);
                                hnumberData.setMoney(Double.valueOf(row.getCell((short) 6).toString()) + money);
                            } else {
                                numberData.setMoney(Double.valueOf(row.getCell((short) 6).toString()));
                                numberData.setNumber(Integer.valueOf(row.getCell((short) 7).toString()));
                                classGroup.put(cellClass.toString(), numberData);

                            }

                        }

                    }
                    map.put(str[i], classGroup);

                }
            }
        }
//        System.out.println(map.toString());
        wb.close();
        ips.close();
        return map;
    }
//    public HSSFSheet getSheet(String path) throws Exception {
//
//            InputStream ips = new FileInputStream(path);  //磁盘io流
//            HSSFWorkbook wb = new HSSFWorkbook(ips);    //得到Excel工作簿对象
//          return wb.getSheetAt(0);  //得到Excel工作表对象
//    }
//    public HSSFSheet getSheet(String path,String sheetName) throws Exception {
//        InputStream ips = new FileInputStream(path);  //磁盘io流
//        HSSFWorkbook wb = new HSSFWorkbook(ips);    //得到Excel工作簿对象
//        return wb.getSheet(sheetName);//得到Excel工作表对象
//    }

    @Override
    public List<WarehouseData> readingMatchSheet(String path) throws Exception{
         List<WarehouseData> warehouseDataList = new ArrayList<>();
         WarehouseData warehouseData = new WarehouseData();
        InputStream ips = new FileInputStream(path);  //磁盘io流
        HSSFWorkbook wb = new HSSFWorkbook(ips);    //得到Excel工作簿对象
        HSSFSheet sheet = wb.getSheetAt(0);  //得到Excel工作表对象
        this.index = sheet.getLastRowNum() + 1;    //获得Excel工作表对象有效行数
        HSSFRow row = sheet.getRow(0);
        warehouseData.setCommodity(row.getCell((short) 0).toString());
        warehouseData.setTotal(row.getCell((short) 1).toString());
        warehouseData.setType(row.getCell((short) 2).toString());
        warehouseData.setMoneyAnd(row.getCell((short) 3).toString());
        warehouseData.setMoney("单价");
        warehouseDataList.add(warehouseData);
        for (int i = 1;i<index;i++){
            WarehouseData warehouseDatas = new WarehouseData();
            HSSFRow rowN = sheet.getRow(i);
            warehouseDatas.setCommodity(rowN.getCell((short) 0).toString());
            warehouseDatas.setTotal(rowN.getCell((short) 1).toString());
            warehouseDatas.setType(rowN.getCell((short) 2).toString());
            warehouseDatas.setMoneyAnd(rowN.getCell((short) 3).toString());
            warehouseDataList.add(warehouseDatas);
        }
//        System.out.println(warehouseDataList.toString());
        wb.close();
        ips.close();
        return warehouseDataList;
    }

    public List getList(){
        return this.list;
    }
}

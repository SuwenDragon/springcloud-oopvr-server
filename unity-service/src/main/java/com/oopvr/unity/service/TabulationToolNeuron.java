package com.oopvr.unity.service;

import com.oopvr.unity.pojo.CompleteData;
import com.oopvr.unity.pojo.SourceExcelData;
import com.oopvr.unity.pojo.WarehouseData;
import com.oopvr.unity.pojo.WarehouseMaxData;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableRead;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableWrite;
import com.oopvr.unity.unitytool.ToolListImplements;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class TabulationToolNeuron {

    public boolean makeTableExcel(String source,String toPath) throws Exception{
        ToolListImplements toolListImplements = new ToolListImplements();  //获取路径
        List<File> files = toolListImplements.readFile(source);
        int frequency=0;
        for (File f1: files){
            SchoolTableRead schoolTableRead = new SchoolTableRead();  //读表
            SchoolTableWrite schoolTableWrite = new SchoolTableWrite();
            Thread.sleep(2000);
            if (f1.getName().contains("优惠")){
                SourceExcelData sourceExcelData = new SourceExcelData(); // 初始化实体类
                System.out.println("开始记录");
                frequency++;
                System.out.println("第"+frequency+"次开始");
                int index = f1.getName().indexOf('优');
                String date = f1.getName().substring(0, 4);//记录日期
                String tofrequency = f1.getName().substring(4,9);//记录目标第几次
                String schoolName = f1.getName().substring(9,index);//记录名称
                double discount = Double.valueOf(Integer.valueOf(f1.
                        getName().substring(index+2,index+4))*0.01); //记录优惠
                sourceExcelData.setDate(date);
                sourceExcelData.setFrequency(tofrequency);
                sourceExcelData.setName(schoolName);
                sourceExcelData.setDiscount(discount);  //记录优惠
                sourceExcelData.setMap(schoolTableRead.readingSheet(f1.getPath())); //记录数据
                List<CompleteData> listf1 = schoolTableRead.getList();
                sourceExcelData.setCompleteData(listf1);  //克隆工作表

                for (File f2: files){  //仓库表
                    if(f2.getName().contains(schoolName+"订单明细")){
                        WarehouseMaxData warehouseMaxData = new WarehouseMaxData();
                        int length = f2.getName().length();
                        int f2Index = f2.getName().indexOf('订');
                        warehouseMaxData.setCode(f2.getName().substring(0,7));  //获取编号
                        warehouseMaxData.setName(f2.getName().substring(7,f2Index)); //获取学校名称
                        warehouseMaxData.setDate(date);  //获取日期
                        warehouseMaxData.setManagerName(f2.getName().substring(f2Index+4,length-4));  //获取经理名字
                        warehouseMaxData.setWarehouseDataList(schoolTableRead.readingMatchSheet(f2.getPath())); //获取统计
                        warehouseMaxData.setList(listf1); //获取明细
//                        System.out.println(warehouseMaxData.toString()+"仓库配书表");

                        schoolTableWrite.writeMatchSheet(warehouseMaxData,
                                toPath+date+"\\"+schoolName+"\\"+tofrequency+"\\"+date+
                                        schoolName +"仓库配书表.xlsx");

                        toolListImplements.copyFileUsingFileChannels(new File(f2.getPath()),new File(toPath+date+
                                "\\"+schoolName+"\\"+tofrequency+"\\"+f2.getName())); //复制源文件到新文件夹

                    }

                }




                schoolTableWrite.writeSheet(sourceExcelData,toPath+date+"\\"+schoolName+"\\"+tofrequency+"\\"+date+
                        tofrequency+ schoolName +"各表.xlsx"); //制表

                toolListImplements.copyFileUsingFileChannels(new File(f1.getPath()),new File(toPath+date+
                        "\\"+schoolName+"\\"+tofrequency+"\\"+f1.getName())); //复制源文件到新文件夹
                System.out.println("等待两秒");
//

//                System.out.println(f1.getName().substring(4,9)); //获取类型（第一次，一次性）
//                System.out.println(f1.getName().substring(9,index)+"获取学校");
//                System.out.println(f1.getName().substring(index+2,index+4)+"获取优惠");
//                System.out.println(substring+"日期");
            }

        }

        return true;
    }
}

package com.oopvr.unity.service;

import com.oopvr.unity.pojo.*;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableRead;
import com.oopvr.unity.unitytool.ExcelForm.SchoolTableWrite;
import com.oopvr.unity.unitytool.ExcelFormUnityInterface;
import com.oopvr.unity.unitytool.ToolListImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TabulationToolNeuron {

    @Autowired
    private ExcelFormUnityInterface excelFormUnityInterface;

    /**
     * 表格业务处理
     * @param source
     * @param toPath
     * @param xs
     * @return
     * @throws Exception
     */
    public String makeTableExcel(String source, String toPath,int xs) throws Exception {
        ToolListImplements toolListImplements = new ToolListImplements();  //获取路径
        List<File> files = toolListImplements.readFile(source);
        int frequency = 0;
        for (File f1 : files) {
            SchoolTableRead schoolTableRead = new SchoolTableRead();  //读表
            SchoolTableWrite schoolTableWrite = new SchoolTableWrite();  //写表
            Thread.sleep(2000);
            if (f1.getName().contains("优惠")) {
                SourceExcelData sourceExcelData = new SourceExcelData(); // 初始化实体类
                System.out.println("开始记录");
                frequency++;
                System.out.println("第" + frequency + "次开始");
                int index = f1.getName().indexOf('优');
                String date = f1.getName().substring(0, 4);//记录日期
                String tofrequency = f1.getName().substring(4, 9);//记录目标第几次
                String schoolName = f1.getName().substring(9, index);//记录名称
                double discount = Double.valueOf(Integer.valueOf(f1.
                        getName().substring(index + 2, index + 4)) * 0.01); //记录优惠
                sourceExcelData.setDate(date);
                sourceExcelData.setFrequency(tofrequency);
                sourceExcelData.setName(schoolName);
                sourceExcelData.setDiscount(discount);  //记录优惠
                sourceExcelData.setMap(schoolTableRead.readingSheet(f1.getPath())); //记录数据
                List<CompleteData> listf1 = schoolTableRead.getList();//获得记录所有数据
                sourceExcelData.setCompleteData(listf1);  //克隆工作表


                for (File f2 : files) {//读单本表数据
                    if (f2.getName().contains(schoolName + "（单本）班级")) {
                        SourceExcelSingleData sourceExcelSingleData = new SourceExcelSingleData();
                        sourceExcelSingleData.setMap(schoolTableRead.readingSheet(f2.getPath())); //记录单本数据
                        sourceExcelSingleData.setCompleteData(schoolTableRead.getList());  //记录所有数据
                        sourceExcelData.setSourceExcelSingleData(sourceExcelSingleData);
                        Map<String, HashMap<String, NumberData>> stringHashMapMap =
                                excelFormUnityInterface.handleData(sourceExcelData.getCompleteData(),
                                        sourceExcelSingleData.getCompleteData());
                        sourceExcelData.setMaxMap(stringHashMapMap);//套装和单本统计

                        File fileDir = new File(toPath + date +
                                "\\" + schoolName + "\\" + tofrequency + "\\" + f2.getName());
                        if (!fileDir.getParentFile().exists()) {
                            fileDir.getParentFile().mkdirs();//创建文件夹
                        }
                        toolListImplements.copyFileUsingFileChannels(new File(f2.getPath()), new File(toPath + date +
                                "\\" + schoolName + "\\" + tofrequency + "\\" + f2.getName())); //复制源文件到新文件夹

                    }
                }

                for (File fsum : files) {//读单本表数据
                    if (fsum.getName().contains(schoolName + "总奖状")) {
                        sourceExcelData.setMapSum(schoolTableRead.readingSheet(fsum.getPath()));
                        File fileDirs = new File(toPath + date +
                                "\\" + schoolName + "\\" + tofrequency + "\\" + fsum.getName());
                        if (!fileDirs.getParentFile().exists()) {
                            fileDirs.getParentFile().mkdirs();//创建文件夹
                        }
                        toolListImplements.copyFileUsingFileChannels(new File(fsum.getPath()), new File(toPath + date +
                                "\\" + schoolName + "\\" + tofrequency + "\\" + fsum.getName())); //复制源文件到新文件夹

                    }
                }



                for (File f3 : files) {  //生成仓库表
                    if (f3.getName().contains(schoolName + "订单明细")) {
                        WarehouseMaxData warehouseMaxData = new WarehouseMaxData();
                        int length = f3.getName().length();
                        int f3Index = f3.getName().indexOf('订');
                        warehouseMaxData.setCode(f3.getName().substring(0, 7));  //获取编号
                        warehouseMaxData.setName(f3.getName().substring(7, f3Index)); //获取学校名称
                        warehouseMaxData.setDate(date);  //获取日期
                        warehouseMaxData.setManagerName(f3.getName().substring(f3Index + 4, length - 4));  //获取经理名字
                        warehouseMaxData.setWarehouseDataList(schoolTableRead.readingMatchSheet(f3.getPath())); //获取统计
                        warehouseMaxData.setList(listf1); //获取明细
//                        System.out.println(warehouseMaxData.toString()+"仓库配书表");

                        for (File f4 : files) { //生成单本数据
                            if (f4.getName().contains(schoolName + "（单本）订单明细")) {
                                WarehouseSingleData warehouseSingleData = new WarehouseSingleData();
                                /**
                                 * 获取单本基本数据
                                 */
                                warehouseSingleData.setList(sourceExcelData.getSourceExcelSingleData().getCompleteData());
                                warehouseSingleData.setWarehouseDataList(schoolTableRead.readingMatchSheet(f4.getPath()));
                                warehouseMaxData.setWarehouseSingleData(warehouseSingleData);
                                toolListImplements.copyFileUsingFileChannels(new File(f4.getPath()), new File(toPath + date +
                                        "\\" + schoolName + "\\" + tofrequency + "\\" + f4.getName())); //复制源文件到新文件夹
                            }


                        }


                        schoolTableWrite.writeMatchSheet(warehouseMaxData,
                                toPath + date + "\\" + schoolName + "\\" + tofrequency + "\\" + date +
                                        schoolName + "仓库配书表.xlsx");

                        toolListImplements.copyFileUsingFileChannels(new File(f3.getPath()), new File(toPath + date +
                                "\\" + schoolName + "\\" + tofrequency + "\\" + f3.getName())); //复制源文件到新文件夹

                    }

                }

                if (sourceExcelData.getMaxMap() == null){
                    sourceExcelData.setMaxMap(
                            excelFormUnityInterface.handleData(sourceExcelData.getCompleteData()));
                }



                schoolTableWrite.writeSheet(sourceExcelData, toPath + date + "\\" + schoolName + "\\" + tofrequency + "\\" + date +
                        tofrequency + schoolName + "各表.xlsx",xs); //制表

                toolListImplements.copyFileUsingFileChannels(new File(f1.getPath()), new File(toPath + date +
                        "\\" + schoolName + "\\" + tofrequency + "\\" + f1.getName())); //复制源文件到新文件夹
                System.out.println("等待两秒");
//

//                System.out.println(f1.getName().substring(4,9)); //获取类型（第一次，一次性）
//                System.out.println(f1.getName().substring(9,index)+"获取学校");
//                System.out.println(f1.getName().substring(index+2,index+4)+"获取优惠");
//                System.out.println(substring+"日期");
            }

        }


        return String.valueOf(frequency);
    }
}

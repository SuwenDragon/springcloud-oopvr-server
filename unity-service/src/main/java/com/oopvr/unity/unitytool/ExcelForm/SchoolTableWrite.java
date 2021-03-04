package com.oopvr.unity.unitytool.ExcelForm;

import com.oopvr.unity.pojo.*;
import com.oopvr.unity.unitytool.ExcelFormUnityImplements;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


public class SchoolTableWrite extends ExcelFormUnityImplements {
    private final String[] str = {"一年级", "二年级", "三年级", "四年级", "五年级", "六年级",
            "初一", "初二", "初三",
            "高一", "高二", "高三",
            "大一", "大二", "大三", "大四", "小小班", "小班", "中班", "大班", "学前班", "宝宝班", "国际班"};
   private HSSFWorkbook wb; // create the new Workbook

    @Override
    public String writeSheet(SourceExcelData sourceExcelData, String path) throws Exception {
        this.wb = new HSSFWorkbook();
        try {
/**
 * 建立表格设置。
 */
            HSSFSheet sheete = wb.createSheet("(套装书)透视图"); // create
            HSSFSheet sheetel = wb.createSheet("(单本)透视图"); // create
            HSSFSheet sheetq = wb.createSheet("学校总订单"); // create
            HSSFSheet sheetw = wb.createSheet("华闻（套）明细"); // create
            HSSFSheet sheetp = wb.createSheet("华闻（单）明细"); // create
            HSSFSheet sheet = wb.createSheet("各班级数量老师签收表"); // create
            HSSFSheet sheeto = wb.createSheet("各班级(单本)数量老师签收表"); // create
            HSSFSheet sheet1 = wb.createSheet("各班级数量负责人签收表"); // create
            HSSFSheet sheets = wb.createSheet("各班级(单本)数量负责人签收表"); // create
            HSSFSheet sheet2 = wb.createSheet("各班级奖状汇总配送表"); // create


            setPageStyle(sourceExcelData, sheete);
            setPageStyle(sourceExcelData, sheetel);
            setPageStyle(sourceExcelData, sheetq);
            setPageStyle(sourceExcelData, sheetw);
            setPageStyle(sourceExcelData, sheetp);
            setPageStyle(sourceExcelData, sheet);
            setPageStyle(sourceExcelData, sheeto);
            setPageStyle(sourceExcelData, sheet1);
            setPageStyle(sourceExcelData, sheets);
            setPageStyle(sourceExcelData, sheet2);



/**
 * 打印设置
 */
//            HSSFPrintSetup hps = sheet.getPrintSetup();
//            hps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 设置A4纸
//            sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.1);// 页边距（下）
//            sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.1);// 页边距（左）
//            sheet.setMargin(HSSFSheet.RightMargin, (double) 0.1);// 页边距（右）
//            sheet.setMargin(HSSFSheet.TopMargin, (double) 0.1);// 页边距（上）
//            CellRangeAddress cellAddrss = new CellRangeAddress(0, 0, 0, 5);
//            sheet.addMergedRegion(cellAddrss);
////            setBorderStyle(BorderStyle.THIN, cellAddrss,sheet); //设置合并后的边框线和颜色  无效
////// hps.setLandscape(true); // 将页面设置为横向打印模式
////            sheet.setHorizontallyCenter(true); // 设置打印页面为水平居中
//// sheet.setVerticallyCenter(true); // 设置打印页面为垂直居中
//            Footer footer = sheet.getFooter();
//            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
////            wb.setPrintArea(0, "$A$2:$e$" + rowNum + 2);// 打印区域设置.
/**
 // * 设置表的Footer
 // */
//            HSSFFooter footer = sheet.getFooter();
//// 设置footer的位置和显示的内容
//            footer.setCenter("Time:" + HSSFFooter.date());
//            footer.setRight("Page " + HSSFFooter.page() + " of "
//                    + HSSFFooter.numPages());
/**
 // * 设置表的Header
 // */
//// 设置header的位置,共有三种位置和相应的显示设置
//            HSSFHeader header = sheet.getHeader();
//// header.setRight("Center Header");
//// header.setLeft("Left Header");
//            header.setCenter(HSSFHeader.font("Stencil-Normal", "Italic")
//                    + HSSFHeader.fontSize((short) 30) + args.getHeaderTitle());
//// header.endDoubleUnderline();
//            header.startUnderline();
/**
 * 设置列的宽度
 */
//            sheet.setColumnWidth((short) 0,
//                    (short) ((33 * 8) / ((double) 1 / 10)));
//            sheet.setColumnWidth((short) 1,
//                    (short) ((33 * 8) / ((double) 1 / 10)));
//            sheet.setColumnWidth((short) 2,
//                    (short) ((33 * 8) / ((double) 1 / 10)));
//            sheet.setColumnWidth((short) 3,
//                    (short) ((33 * 8) / ((double) 1 / 10)));
//            sheet.setColumnWidth((short) 4,
//                    (short) ((50 * 8) / ((double) 1 / 20)));
//            sheet.setColumnWidth((short) 5,
//                    (short) ((50 * 8) / ((double) 1 / 20)));
///**
// * 创建第一行,也就是显示的标题, 可以高置的高度,单元格的格式,颜色,字体等设置. 同时可以合并单元格.
// */

//            HSSFFont font = wb.createFont(); // 创建字体格式
//            font.setFontHeightInPoints((short) 12); // 设置字体大小
//            font.setFontName("宋体"); // 设置单元格字体
////            font.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
//            font.setBold(true);  //设置加粗
//            HSSFCellStyle style = wb.createCellStyle();
//            style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
//            style.setAlignment(HorizontalAlignment.CENTER);// 水平
//            style.setBorderBottom(BorderStyle.THIN); // 设置单元格的边框为粗体
//            style.setBorderLeft(BorderStyle.THIN);
//            style.setBorderTop(BorderStyle.THIN);
//            style.setBorderRight(BorderStyle.THIN);
//            style.setRightBorderColor(IndexedColors.BLACK.getIndex());// 设置单元格的边框颜色
//            style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//            style.setWrapText(true);
//            style.setFont(font);


/**
 * 对文件进行输出操作
 *。
 */

            File fileDir = new File(path);
            if (!fileDir.getParentFile().exists()) {
                fileDir.getParentFile().mkdirs();//创建文件夹
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            wb.close();
        }
        return "ok";


    }


    public String writeMatchSheet(WarehouseMaxData warehouseMaxData, String path) throws Exception {
        this.wb = new HSSFWorkbook();
        try {
/**
 * 建立表格设置。
 */
            HSSFSheet sheetw = wb.createSheet("班级明细表"); // create
            HSSFSheet sheetk = wb.createSheet("仓库配书表"); // create
            HSSFSheet sheetu = wb.createSheet("班级(单本)明细表"); // create
            HSSFSheet sheetj = wb.createSheet("仓库（单本）配书表"); // create

            setPageMatchStyle(warehouseMaxData, sheetw);
            setPageMatchStyle(warehouseMaxData, sheetk);
            setPageMatchStyle(warehouseMaxData, sheetu);
            setPageMatchStyle(warehouseMaxData, sheetj);

/**
 * 对文件进行输出操作
 *。
 */
            File fileDir = new File(path);
            if (!fileDir.getParentFile().exists()) {
                fileDir.getParentFile().mkdirs();//创建文件夹
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            wb.close();
        }
        return "ok";
    }

    //生成学校表
    public void setPageStyle(SourceExcelData sourceExcelData, HSSFSheet sheet) {
        HSSFPrintSetup hps = sheet.getPrintSetup();
        hps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 设置A4纸
        sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.1);// 页边距（下）
        sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.1);// 页边距（左）
        sheet.setMargin(HSSFSheet.RightMargin, (double) 0.1);// 页边距（右）
        sheet.setMargin(HSSFSheet.TopMargin, (double) 0.1);// 页边距（上）
        CellRangeAddress cellAddrss = new CellRangeAddress(0, 0, 0, 5); //合并单元格


        //配置列宽
        if (sheet.getSheetName().contains("各班级数量老师签收表")) {
            sheet.addMergedRegion(cellAddrss);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
            sheet.setColumnWidth((short) 0,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((50 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 5,
                    (short) ((50 * 8) / ((double) 1 / 20)));
            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", " ", "签名", "电话号码"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "各班级图书数量签收表（老师签收）"); // 设置单元的内容.
            Map<String, HashMap<String, NumberData>> map = sourceExcelData.getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x300); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x300); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        celly.setCellValue(stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount());
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    celliu.setCellValue(discountSummary);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            cell13.setCellValue(hdiscountSummary);
            cell13.setCellStyle(style);
            rowN.createCell((short) 4).setCellStyle(style);
            rowN.createCell((short) 5).setCellStyle(style);

        }
        if (sheet.getSheetName().contains("各班级(单本)数量老师签收表")) {
            sheet.addMergedRegion(cellAddrss);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
            sheet.setColumnWidth((short) 0,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((33 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((50 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 5,
                    (short) ((50 * 8) / ((double) 1 / 20)));
            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", " ", "签名", "电话号码"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "各班级图书（单本）数量签收表（老师签收）"); // 设置单元的内容.
            SourceExcelSingleData sourceExcelSingleData = sourceExcelData.getSourceExcelSingleData();
            if (sourceExcelSingleData == null) return;
            Map<String, HashMap<String, NumberData>> map = sourceExcelSingleData.getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x300); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x300); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        double v = new BigDecimal(stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount())
                                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        celly.setCellValue(v);
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    double vsum = new BigDecimal(discountSummary)
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    celliu.setCellValue(vsum);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            double vsums = new BigDecimal(hdiscountSummary)
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            cell13.setCellValue(vsums);
            cell13.setCellStyle(style);
            rowN.createCell((short) 4).setCellStyle(style);
            rowN.createCell((short) 5).setCellStyle(style);

        }
        if (sheet.getSheetName().contains("各班级(单本)数量负责人签收表")) {
            CellRangeAddress cellAddrssf = new CellRangeAddress(0, 0, 0, 3);
            sheet.addMergedRegion(cellAddrssf);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
            sheet.setColumnWidth((short) 0,
                    (short) ((38 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 1,
                    (short) ((38 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 2,
                    (short) ((45 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 3,
                    (short) ((45 * 8) / ((double) 1 / 20)));

            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", " "};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "各班级（单本）图书数量表（给负责人）"); // 设置单元的内容.
            SourceExcelSingleData sourceExcelSingleData = sourceExcelData.getSourceExcelSingleData();
            if (sourceExcelSingleData == null) return;
            Map<String, HashMap<String, NumberData>> map = sourceExcelSingleData.getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x300); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x300); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        double v = new BigDecimal(stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount())
                                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        celly.setCellValue(v);
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    double vsum = new BigDecimal(discountSummary)
                            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    celliu.setCellValue(vsum);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            double vsums = new BigDecimal(hdiscountSummary)
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            cell13.setCellValue(vsums);
            cell13.setCellStyle(style);
        }
        if (sheet.getSheetName().contains("各班级数量负责人签收表")) {
            CellRangeAddress cellAddrssf = new CellRangeAddress(0, 0, 0, 3);
            sheet.addMergedRegion(cellAddrssf);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
            sheet.setColumnWidth((short) 0,
                    (short) ((38 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 1,
                    (short) ((38 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 2,
                    (short) ((45 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 3,
                    (short) ((45 * 8) / ((double) 1 / 20)));

            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", " "};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "各班级图书数量表（给负责人）"); // 设置单元的内容.
            Map<String, HashMap<String, NumberData>> map = sourceExcelData.getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x300); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x300); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        celly.setCellValue(stringNumberDataHashMap.get(key).getMoney() * sourceExcelData.getDiscount());
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    celliu.setCellValue(discountSummary);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            cell13.setCellValue(hdiscountSummary);
            cell13.setCellStyle(style);

        }
        if (sheet.getSheetName().contains("各班级奖状汇总配送表")) {
            if (sourceExcelData.getFrequency().contains("一次性") || sourceExcelData.getFrequency().contains("结束了")) {
                CellRangeAddress cellAddrssj = new CellRangeAddress(0, 0, 0, 2);
                sheet.addMergedRegion(cellAddrssj);
                Footer footer = sheet.getFooter();
                footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");
                sheet.setColumnWidth((short) 0,
                        (short) ((53 * 8) / ((double) 1 / 20)));
                sheet.setColumnWidth((short) 1,
                        (short) ((53 * 8) / ((double) 1 / 20)));
                sheet.setColumnWidth((short) 2,
                        (short) ((55 * 8) / ((double) 1 / 20)));


                HSSFCellStyle style = getUnitStyle();
                HSSFRow row = sheet.createRow(0); // 创建1行
                row.setHeight((short) 0x300); // 设直行的高度.
                HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
                cell.setCellStyle(style); // 设置单元格的风格

                String[] strpop = {"年级", "班级", "奖状总数量"};
                HSSFRow row1 = sheet.createRow(1); // 创建2行
                row1.setHeight((short) 0x300); // 设直行的高度.
                for (int i = 0; i < strpop.length; i++) {
                    HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                    cell1.setCellValue(strpop[i]);
                    cell1.setCellStyle(style); // 设置单元格的风格
                    row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
                }
                cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "各班级奖状汇总配送表\n" +
                        "（主跟单用，在最后一次配送时汇总）"); // 设置单元的内容.


                Map<String, HashMap<String, NumberData>> map;
                if (sourceExcelData.getMapSum() == null){
                    map = sourceExcelData.getMap();
                }else {
                    map = sourceExcelData.getMapSum();
                }

                int group = 0;
                int hsummary = 0;
                int index = 0;
                for (int i = 0; i < str.length; i++) {
                    if (map.containsKey(str[i])) {
                        index++;
                        HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                        row2.setHeight((short) 0x300); // 设直行的高度.
                        group++;


                        HSSFCell cell1;
                        for (int js = 1; js < strpop.length; js++) {
                            cell1 = row2.createCell((short) js);
                            cell1.setCellStyle(style);
                        }

                        HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                        cellq.setCellValue(str[i]);
                        cellq.setCellStyle(style);

                        HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                        Set set = stringNumberDataHashMap.keySet(); //获得班级
                        Iterator iter = set.iterator();
                        int summary = 0;
                        while (iter.hasNext()) {
                            String key = (String) iter.next();
                            HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                            row3.setHeight((short) 0x300); // 设直行的高度.
                            for (int uus = 0; uus < strpop.length; uus++) {
                                row3.createCell((short) uus).setCellStyle(style);
                            }

                            summary = summary + stringNumberDataHashMap.get(key).getNumber();

                            HSSFCell cellw = row3.createCell((short) 1);
                            cellw.setCellValue(key);
                            cellw.setCellStyle(style);
                            HSSFCell cellr = row3.createCell((short) 2);
                            cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                            cellr.setCellStyle(style);
                            group++;
                        }
                        hsummary = hsummary + summary;

                        HSSFCell cellu = row2.createCell((short) 2);
                        cellu.setCellValue(summary);
                        cellu.setCellStyle(style);
                    }
                }
                HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
                rowN.setHeight((short) 0x300); // 设直行的高度.
                HSSFCell cell10 = rowN.createCell((short) 0);
                cell10.setCellValue("总计");
                cell10.setCellStyle(style);
                HSSFCell cell11 = rowN.createCell((short) 1);
                cell11.setCellValue(group - index);
                cell11.setCellStyle(style);
                HSSFCell cell12 = rowN.createCell((short) 2);
                cell12.setCellValue(hsummary);
                cell12.setCellStyle(style);
            }
        }

        if (sheet.getSheetName().contains("(套装书)透视图")) {
            CellRangeAddress cellAddrsst = new CellRangeAddress(0, 0, 0, 3);
            sheet.addMergedRegion(cellAddrsst);
            sheet.setColumnWidth((short) 0,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", "金额汇总"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x200); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "(套装书)透视图"); // 设置单元的内容.
            Map<String, HashMap<String, NumberData>> map = sourceExcelData.getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x150); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x150); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        celly.setCellValue(stringNumberDataHashMap.get(key).getMoney());
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    celliu.setCellValue(discountSummary);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            cell13.setCellValue(hdiscountSummary);
            cell13.setCellStyle(style);

        }
        if (sheet.getSheetName().contains("(单本)透视图")) {
            CellRangeAddress cellAddrsst = new CellRangeAddress(0, 0, 0, 3);
            sheet.addMergedRegion(cellAddrsst);
            sheet.setColumnWidth((short) 0,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((55 * 8) / ((double) 1 / 10)));
            HSSFCellStyle style = getUnitStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "汇总", "金额汇总"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x200); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(sourceExcelData.getDate() + sourceExcelData.getName() + "（单本）透视图"); // 设置单元的内容.
//            Map<String, HashMap<String, NumberData>> map = sourceExcelData.getMap();
            Map<String, HashMap<String, NumberData>> map = sourceExcelData.getSourceExcelSingleData().getMap();
            int group = 0;
            int hsummary = 0;
            double hdiscountSummary = 0;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    index++;
                    HSSFRow row2 = sheet.createRow(group + 2); // 创建3行
                    row2.setHeight((short) 0x150); // 设直行的高度.
                    group++;


                    HSSFCell cell1;
                    for (int js = 1; js < strpop.length; js++) {
                        cell1 = row2.createCell((short) js);
                        cell1.setCellStyle(style);
                    }

                    HSSFCell cellq = row2.createCell((short) 0); // 创建0行0列.
                    cellq.setCellValue(str[i]);
                    cellq.setCellStyle(style);

                    HashMap<String, NumberData> stringNumberDataHashMap = map.get(str[i]);
                    Set set = stringNumberDataHashMap.keySet(); //获得班级
                    Iterator iter = set.iterator();
                    int summary = 0;
                    double discountSummary = 0;
                    while (iter.hasNext()) {
                        String key = (String) iter.next();
                        HSSFRow row3 = sheet.createRow(group + 2); // 创建4行
                        row3.setHeight((short) 0x150); // 设直行的高度.
                        for (int uus = 0; uus < strpop.length; uus++) {
                            row3.createCell((short) uus).setCellStyle(style);
                        }

                        summary = summary + stringNumberDataHashMap.get(key).getNumber();
                        discountSummary = discountSummary + stringNumberDataHashMap.get(key).getMoney();

                        HSSFCell cellw = row3.createCell((short) 1);
                        cellw.setCellValue(key);
                        cellw.setCellStyle(style);
                        HSSFCell cellr = row3.createCell((short) 2);
                        cellr.setCellValue(stringNumberDataHashMap.get(key).getNumber());
                        cellr.setCellStyle(style);
                        HSSFCell celly = row3.createCell((short) 3);
                        celly.setCellValue(stringNumberDataHashMap.get(key).getMoney());
                        celly.setCellStyle(style);
                        group++;
                    }
                    hsummary = hsummary + summary;
                    hdiscountSummary = hdiscountSummary + discountSummary;

                    HSSFCell cellu = row2.createCell((short) 2);
                    cellu.setCellValue(summary);
                    cellu.setCellStyle(style);
                    HSSFCell celliu = row2.createCell((short) 3);
                    celliu.setCellValue(discountSummary);
                    celliu.setCellStyle(style);
                }
            }
            HSSFRow rowN = sheet.createRow((short) group + 2); // 创建N行{}
            rowN.setHeight((short) 0x300); // 设直行的高度.

            HSSFCell cell10 = rowN.createCell((short) 0);
            cell10.setCellValue("总计");
            cell10.setCellStyle(style);
            HSSFCell cell11 = rowN.createCell((short) 1);
            cell11.setCellValue(group - index);
            cell11.setCellStyle(style);
            HSSFCell cell12 = rowN.createCell((short) 2);
            cell12.setCellValue(hsummary);
            cell12.setCellStyle(style);
            HSSFCell cell13 = rowN.createCell((short) 3);
            cell13.setCellValue(hdiscountSummary);
            cell13.setCellStyle(style);

        }
        if (sheet.getSheetName().contains("总订单")) {
            List<CompleteData> listcompleteData = sourceExcelData.getCompleteData();
            HSSFRow row = sheet.createRow(0);
            CompleteData o = listcompleteData.get(0);
            row.createCell((short) 0).setCellValue(o.getSchoolType());
            row.createCell((short) 1).setCellValue(o.getGrade());
            row.createCell((short) 2).setCellValue(o.getGradeClass());
            row.createCell((short) 3).setCellValue(o.getOrderCode());
            row.createCell((short) 4).setCellValue(o.getCommodity());
            row.createCell((short) 5).setCellValue(o.getStudentName());
            row.createCell((short) 6).setCellValue(o.getPaymentMoney());
            row.createCell((short) 7).setCellValue(o.getNumber());
            row.createCell((short) 8).setCellValue(o.getTelephone());
            row.createCell((short) 9).setCellValue(o.getAddress());
            row.createCell((short) 10).setCellValue(o.getDistributionType());
            row.createCell((short) 11).setCellValue(o.getState());
            row.createCell((short) 12).setCellValue(o.getMessage());
            int lengths = 0;
            for (int i = 1; i < listcompleteData.size(); i++) {
                lengths++;
                CompleteData completeData1 = listcompleteData.get(i);
                HSSFRow row1 = sheet.createRow(i);
                row1.createCell((short) 0).setCellValue(completeData1.getSchoolType());
                row1.createCell((short) 1).setCellValue(completeData1.getGrade());
                row1.createCell((short) 2).setCellValue(completeData1.getGradeClass());
                row1.createCell((short) 3).setCellValue(completeData1.getOrderCode());
                row1.createCell((short) 4).setCellValue(completeData1.getCommodity());
                row1.createCell((short) 5).setCellValue(completeData1.getStudentName());
                row1.createCell((short) 6).setCellValue(Double.valueOf(completeData1.getPaymentMoney()));
                row1.createCell((short) 7).setCellValue(Integer.valueOf(completeData1.getNumber()));
                row1.createCell((short) 8).setCellValue(completeData1.getTelephone());
                row1.createCell((short) 9).setCellValue(completeData1.getAddress());
                row1.createCell((short) 10).setCellValue(completeData1.getDistributionType());
                row1.createCell((short) 11).setCellValue(completeData1.getState());
                row1.createCell((short) 12).setCellValue(completeData1.getMessage());
            }
            SourceExcelSingleData sourceExcelSingleData = sourceExcelData.getSourceExcelSingleData();  //写入单本数据
            if (sourceExcelSingleData == null) return;
            List<CompleteData> listcompleteSingleData = sourceExcelSingleData.getCompleteData();
           for (int j = 1;j<listcompleteSingleData.size();j++){
               CompleteData completeData1 = listcompleteSingleData.get(j);
               HSSFRow row1 = sheet.createRow(j+lengths);
               row1.createCell((short) 0).setCellValue(completeData1.getSchoolType());
               row1.createCell((short) 1).setCellValue(completeData1.getGrade());
               row1.createCell((short) 2).setCellValue(completeData1.getGradeClass());
               row1.createCell((short) 3).setCellValue(completeData1.getOrderCode());
               row1.createCell((short) 4).setCellValue(completeData1.getCommodity());
               row1.createCell((short) 5).setCellValue(completeData1.getStudentName());
               row1.createCell((short) 6).setCellValue(Double.valueOf(completeData1.getPaymentMoney()));
               row1.createCell((short) 7).setCellValue(Integer.valueOf(completeData1.getNumber()));
               row1.createCell((short) 8).setCellValue(completeData1.getTelephone());
               row1.createCell((short) 9).setCellValue(completeData1.getAddress());
               row1.createCell((short) 10).setCellValue(completeData1.getDistributionType());
               row1.createCell((short) 11).setCellValue(completeData1.getState());
               row1.createCell((short) 12).setCellValue(completeData1.getMessage());
           }


        }

        if (sheet.getSheetName().contains("华闻（套）明细")) {
            List<CompleteData> listcompleteData = sourceExcelData.getCompleteData();

//            System.out.println(sourceExcelData.getCompleteData().toString()+"全部订单信息");
            HSSFRow row = sheet.createRow(0);
            CompleteData o = listcompleteData.get(0);
            row.createCell((short) 0).setCellValue(o.getSchoolType());
            row.createCell((short) 1).setCellValue(o.getGrade());
            row.createCell((short) 2).setCellValue(o.getGradeClass());
            row.createCell((short) 3).setCellValue(o.getOrderCode());
            row.createCell((short) 4).setCellValue(o.getCommodity());
            row.createCell((short) 5).setCellValue(o.getStudentName());
            row.createCell((short) 6).setCellValue(o.getPaymentMoney());
            row.createCell((short) 7).setCellValue(o.getNumber());
            row.createCell((short) 8).setCellValue(o.getTelephone());
            row.createCell((short) 9).setCellValue(o.getAddress());
            row.createCell((short) 10).setCellValue(o.getDistributionType());
            row.createCell((short) 11).setCellValue(o.getState());
            row.createCell((short) 12).setCellValue(o.getMessage());
            for (int i = 1; i < listcompleteData.size(); i++) {
                CompleteData completeData1 = listcompleteData.get(i);
                HSSFRow row1 = sheet.createRow(i);
                row1.createCell((short) 0).setCellValue(completeData1.getSchoolType());
                row1.createCell((short) 1).setCellValue(completeData1.getGrade());
                row1.createCell((short) 2).setCellValue(completeData1.getGradeClass());
                row1.createCell((short) 3).setCellValue(completeData1.getOrderCode());
                row1.createCell((short) 4).setCellValue(completeData1.getCommodity());
                row1.createCell((short) 5).setCellValue(completeData1.getStudentName());
                row1.createCell((short) 6).setCellValue(Double.valueOf(completeData1.getPaymentMoney()));
                row1.createCell((short) 7).setCellValue(Integer.valueOf(completeData1.getNumber()));
                row1.createCell((short) 8).setCellValue(completeData1.getTelephone());
                row1.createCell((short) 9).setCellValue(completeData1.getAddress());
                row1.createCell((short) 10).setCellValue(completeData1.getDistributionType());
                row1.createCell((short) 11).setCellValue(completeData1.getState());
                row1.createCell((short) 12).setCellValue(completeData1.getMessage());
            }


        }
        if(sheet.getSheetName().contains("华闻（单）明细")){
            SourceExcelSingleData sourceExcelSingleData = sourceExcelData.getSourceExcelSingleData();
            if (sourceExcelSingleData == null) return;
            List<CompleteData> listcompleteData = sourceExcelSingleData.getCompleteData();
//            System.out.println(sourceExcelData.getCompleteData().toString()+"全部订单信息");
            HSSFRow row = sheet.createRow(0);
            CompleteData o = listcompleteData.get(0);
            row.createCell((short) 0).setCellValue(o.getSchoolType());
            row.createCell((short) 1).setCellValue(o.getGrade());
            row.createCell((short) 2).setCellValue(o.getGradeClass());
            row.createCell((short) 3).setCellValue(o.getOrderCode());
            row.createCell((short) 4).setCellValue(o.getCommodity());
            row.createCell((short) 5).setCellValue(o.getStudentName());
            row.createCell((short) 6).setCellValue(o.getPaymentMoney());
            row.createCell((short) 7).setCellValue(o.getNumber());
            row.createCell((short) 8).setCellValue(o.getTelephone());
            row.createCell((short) 9).setCellValue(o.getAddress());
            row.createCell((short) 10).setCellValue(o.getDistributionType());
            row.createCell((short) 11).setCellValue(o.getState());
            row.createCell((short) 12).setCellValue(o.getMessage());
            for (int i = 1; i < listcompleteData.size(); i++) {
                CompleteData completeData1 = listcompleteData.get(i);
                HSSFRow row1 = sheet.createRow(i);
                row1.createCell((short) 0).setCellValue(completeData1.getSchoolType());
                row1.createCell((short) 1).setCellValue(completeData1.getGrade());
                row1.createCell((short) 2).setCellValue(completeData1.getGradeClass());
                row1.createCell((short) 3).setCellValue(completeData1.getOrderCode());
                row1.createCell((short) 4).setCellValue(completeData1.getCommodity());
                row1.createCell((short) 5).setCellValue(completeData1.getStudentName());
                row1.createCell((short) 6).setCellValue(Double.valueOf(completeData1.getPaymentMoney()));
                row1.createCell((short) 7).setCellValue(Integer.valueOf(completeData1.getNumber()));
                row1.createCell((short) 8).setCellValue(completeData1.getTelephone());
                row1.createCell((short) 9).setCellValue(completeData1.getAddress());
                row1.createCell((short) 10).setCellValue(completeData1.getDistributionType());
                row1.createCell((short) 11).setCellValue(completeData1.getState());
                row1.createCell((short) 12).setCellValue(completeData1.getMessage());
            }

        }


    }

    //生成仓库表
    public void setPageMatchStyle(WarehouseMaxData warehouseMaxData, HSSFSheet sheet) {
        HSSFPrintSetup hps = sheet.getPrintSetup();
        hps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 设置A4纸
        sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.1);// 页边距（下）
        sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.1);// 页边距（左）
        sheet.setMargin(HSSFSheet.RightMargin, (double) 0.1);// 页边距（右）
        sheet.setMargin(HSSFSheet.TopMargin, (double) 0.1);// 页边距（上）
        CellRangeAddress cellAddrss = new CellRangeAddress(0, 0, 0, 7);
        hps.setLandscape(true); // 将页面设置为横向打印模式
        //配置列宽

        if (sheet.getSheetName().contains("班级明细表")) {
            sheet.addMergedRegion(cellAddrss);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");

            sheet.setColumnWidth((short) 0,
                    (short) ((28 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((28 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((80 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((183 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((18 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 5,
                    (short) ((15 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 6,
                    (short) ((15 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 7,
                    (short) ((25 * 8) / ((double) 1 / 20)));
            HSSFCellStyle style = getMatchStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "产品订单号", "货物明细", "收货人", "总金额", "数量", "手机"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(warehouseMaxData.getDate() + warehouseMaxData.getName() + "班级明细表"); // 设置单元的内容.
            List<CompleteData> warehouseMaxDataList = warehouseMaxData.getList();
            for (int i = 2; i < warehouseMaxDataList.size() + 1; i++) {
                CompleteData completeData = warehouseMaxDataList.get(i - 1);
                HSSFRow row3 = sheet.createRow(i); // 创建2行
                row3.setHeight((short) 0x350); // 设直行的高度.
                HSSFCell cell1 = row3.createCell((short) 0);
                cell1.setCellValue(completeData.getGrade());
                cell1.setCellStyle(style);
                HSSFCell cell2 = row3.createCell((short) 1);
                cell2.setCellValue(completeData.getGradeClass());
                cell2.setCellStyle(style);
                HSSFCell cell3 = row3.createCell((short) 2);
                cell3.setCellValue(completeData.getOrderCode());
                cell3.setCellStyle(style);
                HSSFCell cell4 = row3.createCell((short) 3);
                cell4.setCellValue(completeData.getCommodity());
                cell4.setCellStyle(style);
                HSSFCell cell5 = row3.createCell((short) 4);
                cell5.setCellValue(completeData.getStudentName());
                cell5.setCellStyle(style);
                HSSFCell cell6 = row3.createCell((short) 5);
                cell6.setCellValue(Double.valueOf(completeData.getPaymentMoney()));
                cell6.setCellStyle(style);
                HSSFCell cell7 = row3.createCell((short) 6);
                cell7.setCellValue(Integer.valueOf(completeData.getNumber()));
                cell7.setCellStyle(style);
                HSSFCell cell8 = row3.createCell((short) 7);
                cell8.setCellValue(completeData.getTelephone());
                cell8.setCellStyle(style);
            }


        }

        if (sheet.getSheetName().contains("仓库配书表")) {
            CellRangeAddress cellAddrssc = new CellRangeAddress(0, 0, 1, 2);
            CellRangeAddress cellAddrsso = new CellRangeAddress(0, 0, 3, 4);
            sheet.addMergedRegion(cellAddrssc);
            sheet.addMergedRegion(cellAddrsso);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");

            sheet.setColumnWidth((short) 0,
                    (short) ((220 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((45 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            HSSFCellStyle style = getMatchStyle();
            HSSFCellStyle matchTwoStyle = getMatchTwoStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            HSSFCell cell2 = row.createCell((short) 1); // 创建0行0列.
            HSSFCell cell4 = row.createCell((short) 3); // 创建0行0列.
            cell.setCellStyle(matchTwoStyle); // 设置单元格的风格

            String[] strpop = {"货物明细", "总数量", "单价", "总金额", "单位"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(warehouseMaxData.getDate() + warehouseMaxData.getName()+"仓库配书表"+
                    "--" + warehouseMaxData.getManagerName()); // 设置单元的内容.
            cell2.setCellValue("序号");
            cell2.setCellStyle(style);
            cell4.setCellValue(warehouseMaxData.getCode());
            cell4.setCellStyle(style);

            List<WarehouseData> warehouseDataList = warehouseMaxData.getWarehouseDataList();
            int index = 0;
            int numberTotal = 0;
            double moneyTotal = 0;
            for (int i = 2; i < warehouseDataList.size() + 1; i++) {
                WarehouseData warehouseData = warehouseDataList.get(i - 1);
                HSSFRow row3 = sheet.createRow(i); // 创建3行
                row3.setHeight((short) 0x350); // 设直行的高度.
                HSSFCell cell1n = row3.createCell((short) 0);
                cell1n.setCellValue(warehouseData.getCommodity());
                cell1n.setCellStyle(matchTwoStyle);
                HSSFCell cell2n = row3.createCell((short) 1);
                cell2n.setCellValue(Integer.valueOf(warehouseData.getTotal()));
                numberTotal += Integer.valueOf(warehouseData.getTotal());
                cell2n.setCellStyle(style);
                HSSFCell cell3n = row3.createCell((short) 2);
                double unitPrice = Double.valueOf(warehouseData.getMoneyAnd())
                        / Integer.valueOf(warehouseData.getTotal());
                cell3n.setCellValue(unitPrice);
                cell3n.setCellStyle(style);
                HSSFCell cell4n = row3.createCell((short) 3);
                cell4n.setCellValue(Double.valueOf(warehouseData.getMoneyAnd()));
                moneyTotal += Double.valueOf(warehouseData.getMoneyAnd());
                cell4n.setCellStyle(style);
                HSSFCell cell5n = row3.createCell((short) 4);
                cell5n.setCellValue(warehouseData.getType());
                cell5n.setCellStyle(style);
                index++;
            }
            HSSFRow rowN = sheet.createRow(index + 2); // 创建3行
            rowN.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell1p = rowN.createCell((short) 0);
            cell1p.setCellValue("总计");
            cell1p.setCellStyle(matchTwoStyle);
            HSSFCell cell2p = rowN.createCell((short) 1);
            cell2p.setCellValue(numberTotal);
            cell2p.setCellStyle(style);
            HSSFCell cell3p = rowN.createCell((short) 2);
            cell3p.setCellValue("");
            cell3p.setCellStyle(style);
            HSSFCell cell4p = rowN.createCell((short) 3);
            cell4p.setCellValue(moneyTotal);
            cell4p.setCellStyle(style);
            HSSFCell cell5p = rowN.createCell((short) 4);
            cell5p.setCellValue("");
            cell5p.setCellStyle(style);


        }

        if (sheet.getSheetName().contains("班级(单本)明细表")) {
            sheet.addMergedRegion(cellAddrss);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");

            sheet.setColumnWidth((short) 0,
                    (short) ((28 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((28 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((80 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((183 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((18 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 5,
                    (short) ((15 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 6,
                    (short) ((15 * 8) / ((double) 1 / 20)));
            sheet.setColumnWidth((short) 7,
                    (short) ((25 * 8) / ((double) 1 / 20)));
            HSSFCellStyle style = getMatchStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            cell.setCellStyle(style); // 设置单元格的风格

            String[] strpop = {"年级", "班级", "产品订单号", "货物明细", "收货人", "总金额", "数量", "手机"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(warehouseMaxData.getDate() + warehouseMaxData.getName() + "班级（单本）明细表"); // 设置单元的内容.
            List<CompleteData> warehouseSingleDataList = warehouseMaxData.getWarehouseSingleData().getList();
            for (int i = 2; i < warehouseSingleDataList.size() + 1; i++) {
                CompleteData completeData = warehouseSingleDataList.get(i - 1);
                HSSFRow row3 = sheet.createRow(i); // 创建2行
                row3.setHeight((short) 0x350); // 设直行的高度.
                HSSFCell cell1 = row3.createCell((short) 0);
                cell1.setCellValue(completeData.getGrade());
                cell1.setCellStyle(style);
                HSSFCell cell2 = row3.createCell((short) 1);
                cell2.setCellValue(completeData.getGradeClass());
                cell2.setCellStyle(style);
                HSSFCell cell3 = row3.createCell((short) 2);
                cell3.setCellValue(completeData.getOrderCode());
                cell3.setCellStyle(style);
                HSSFCell cell4 = row3.createCell((short) 3);
                cell4.setCellValue(completeData.getCommodity());
                cell4.setCellStyle(style);
                HSSFCell cell5 = row3.createCell((short) 4);
                cell5.setCellValue(completeData.getStudentName());
                cell5.setCellStyle(style);
                HSSFCell cell6 = row3.createCell((short) 5);
                cell6.setCellValue(Double.valueOf(completeData.getPaymentMoney()));
                cell6.setCellStyle(style);
                HSSFCell cell7 = row3.createCell((short) 6);
                cell7.setCellValue(Integer.valueOf(completeData.getNumber()));
                cell7.setCellStyle(style);
                HSSFCell cell8 = row3.createCell((short) 7);
                cell8.setCellValue(completeData.getTelephone());
                cell8.setCellStyle(style);
            }


        }

        if (sheet.getSheetName().contains("仓库（单本）配书表")) {
            CellRangeAddress cellAddrssc = new CellRangeAddress(0, 0, 1, 2);
            CellRangeAddress cellAddrsso = new CellRangeAddress(0, 0, 3, 4);
            sheet.addMergedRegion(cellAddrssc);
            sheet.addMergedRegion(cellAddrsso);
            Footer footer = sheet.getFooter();
            footer.setCenter("第" + HeaderFooter.page() + "页，共 " + HeaderFooter.numPages() + "页");

            sheet.setColumnWidth((short) 0,
                    (short) ((220 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 1,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 2,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 3,
                    (short) ((45 * 8) / ((double) 1 / 10)));
            sheet.setColumnWidth((short) 4,
                    (short) ((35 * 8) / ((double) 1 / 10)));
            HSSFCellStyle style = getMatchStyle();
            HSSFCellStyle matchTwoStyle = getMatchTwoStyle();
            HSSFRow row = sheet.createRow(0); // 创建1行
            row.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell = row.createCell((short) 0); // 创建0行0列.
            HSSFCell cell2 = row.createCell((short) 1); // 创建0行0列.
            HSSFCell cell4 = row.createCell((short) 3); // 创建0行0列.
            cell.setCellStyle(matchTwoStyle); // 设置单元格的风格

            String[] strpop = {"货物明细", "总数量", "单价", "总金额", "单位"};
            HSSFRow row1 = sheet.createRow(1); // 创建2行
            row1.setHeight((short) 0x300); // 设直行的高度.
            for (int i = 0; i < strpop.length; i++) {
                HSSFCell cell1 = row1.createCell((short) i); // 创建0行0列.
                cell1.setCellValue(strpop[i]);
                cell1.setCellStyle(style); // 设置单元格的风格
                row.createCell((short) i).setCellStyle(style);// 设置第一行单元格的风格
            }
            cell.setCellValue(warehouseMaxData.getDate() + warehouseMaxData.getName()+"仓库（单本）配书表"+
                    "--" + warehouseMaxData.getManagerName()); // 设置单元的内容.
            cell2.setCellValue("序号");
            cell2.setCellStyle(style);
            cell4.setCellValue(warehouseMaxData.getCode());
            cell4.setCellStyle(style);

//            List<WarehouseData> warehouseDataList = warehouseMaxData.getWarehouseDataList();
            List<WarehouseData> warehouseDataList = warehouseMaxData.getWarehouseSingleData().getWarehouseDataList();
            int index = 0;
            int numberTotal = 0;
            double moneyTotal = 0;
            for (int i = 2; i < warehouseDataList.size() + 1; i++) {
                WarehouseData warehouseData = warehouseDataList.get(i - 1);
                HSSFRow row3 = sheet.createRow(i); // 创建3行
                row3.setHeight((short) 0x350); // 设直行的高度.
                HSSFCell cell1n = row3.createCell((short) 0);
                cell1n.setCellValue(warehouseData.getCommodity());
                cell1n.setCellStyle(matchTwoStyle);
                HSSFCell cell2n = row3.createCell((short) 1);
                cell2n.setCellValue(Integer.valueOf(warehouseData.getTotal()));
                numberTotal += Integer.valueOf(warehouseData.getTotal());
                cell2n.setCellStyle(style);
                HSSFCell cell3n = row3.createCell((short) 2);
                double unitPrice = Double.valueOf(warehouseData.getMoneyAnd())
                        / Integer.valueOf(warehouseData.getTotal());
                cell3n.setCellValue(unitPrice);
                cell3n.setCellStyle(style);
                HSSFCell cell4n = row3.createCell((short) 3);
                cell4n.setCellValue(Double.valueOf(warehouseData.getMoneyAnd()));
                moneyTotal += Double.valueOf(warehouseData.getMoneyAnd());
                cell4n.setCellStyle(style);
                HSSFCell cell5n = row3.createCell((short) 4);
                cell5n.setCellValue(warehouseData.getType());
                cell5n.setCellStyle(style);
                index++;
            }
            HSSFRow rowN = sheet.createRow(index + 2); // 创建3行
            rowN.setHeight((short) 0x300); // 设直行的高度.
            HSSFCell cell1p = rowN.createCell((short) 0);
            cell1p.setCellValue("总计");
            cell1p.setCellStyle(matchTwoStyle);
            HSSFCell cell2p = rowN.createCell((short) 1);
            cell2p.setCellValue(numberTotal);
            cell2p.setCellStyle(style);
            HSSFCell cell3p = rowN.createCell((short) 2);
            cell3p.setCellValue("");
            cell3p.setCellStyle(style);
            HSSFCell cell4p = rowN.createCell((short) 3);
            cell4p.setCellValue(moneyTotal);
            cell4p.setCellStyle(style);
            HSSFCell cell5p = rowN.createCell((short) 4);
            cell5p.setCellValue("");
            cell5p.setCellStyle(style);


        }

    }


    public HSSFCellStyle getUnitStyle() {

        HSSFFont font = wb.createFont(); // 创建字体格式
        font.setFontHeightInPoints((short) 12); // 设置字体大小
        font.setFontName("宋体"); // 设置单元格字体
//            font.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
        font.setBold(true);  //设置加粗
        HSSFCellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
        style.setAlignment(HorizontalAlignment.CENTER);// 水平
        style.setBorderBottom(BorderStyle.THIN); // 设置单元格的边框为粗体
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());// 设置单元格的边框颜色
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setFont(font);

        return style;

    }

    public HSSFCellStyle getMatchStyle() {

        HSSFFont font = wb.createFont(); // 创建字体格式
        font.setFontHeightInPoints((short) 11); // 设置字体大小
        font.setFontName("宋体"); // 设置单元格字体
//            font.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
        font.setBold(true);  //设置加粗
        HSSFCellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
        style.setAlignment(HorizontalAlignment.CENTER);// 水平
        style.setBorderBottom(BorderStyle.THIN); // 设置单元格的边框为粗体
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());// 设置单元格的边框颜色
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setFont(font);

        return style;

    }

    public HSSFCellStyle getMatchTwoStyle() {

        HSSFFont font = wb.createFont(); // 创建字体格式
        font.setFontHeightInPoints((short) 11); // 设置字体大小
        font.setFontName("宋体"); // 设置单元格字体
//            font.setColor(HSSFFont.SS_NONE); // 设置单元格字体的颜色.
        font.setBold(true);  //设置加粗
        HSSFCellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直
        style.setAlignment(HorizontalAlignment.CENTER);// 水平
        style.setAlignment(HorizontalAlignment.LEFT);  //靠左
        style.setBorderBottom(BorderStyle.THIN); // 设置单元格的边框为粗体
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());// 设置单元格的边框颜色
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setFont(font);

        return style;

    }

//    private void copyFileUsingFiles(File source, File dest)
//            throws IOException {
//        Files.copy(source.toPath(), dest.toPath());
//    }

}

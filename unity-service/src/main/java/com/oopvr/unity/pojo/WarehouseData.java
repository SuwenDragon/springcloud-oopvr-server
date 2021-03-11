package com.oopvr.unity.pojo;


import lombok.Data;

/**
 * 仓库属性数据
 */
@Data
public class WarehouseData {
    public String commodity;
    public String total;
    public String money;
    public String moneyAnd;
    public String type;


//    public Double getMoney() {
//        try{
//             Integer.parseInt(this.total);
//        }catch(NumberFormatException e){
//             System.err.println("不能bai转换du为zhi整dao型zhuan");
//        }
//        if (this.moneyAnd != null && this.total != null ){
//          return this.money = Double.valueOf(this.moneyAnd) / Integer.valueOf(this.total);
//        }
//        return money;
//    }
}

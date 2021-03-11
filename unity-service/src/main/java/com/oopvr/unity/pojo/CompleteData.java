package com.oopvr.unity.pojo;

import lombok.Data;

/**
 * 订单数据
 */
@Data
public class CompleteData {
    public String schoolType;   //学校类型
    public String grade;         //年级
    public String gradeClass;      //班级
    public String orderCode;     //订单编号
    public String commodity;     //商品详情
    public String studentName;      //客户名字
    public String paymentMoney;   //支付金额
    public String number;         //数量
    public String telephone;      //电话
    public String address;         //快递地址
    public String distributionType;  //配送方式
    public String state;              //状态
    public String message;          //备注
}

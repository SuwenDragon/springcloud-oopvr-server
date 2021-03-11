package com.oopvr.unity.pojo;

import lombok.Data;

@Data
public class NumberData {
    public int number;
    public double money;



    public void addNumber(int i){
        this.number+=i;
    }


    public void addMoney(double d){
        this.money+=d;
    }
}

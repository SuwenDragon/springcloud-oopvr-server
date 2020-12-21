package com.oopvr.production.tool.wrench;

import com.oopvr.production.tool.GearDemandImplements;

public class ScissorsNumber extends GearDemandImplements {
    private static int MAX = 100000000;
    private static int MiN = 1;
    private static int length;



    public int makeNumbers() {
        return cutNumbers();
    }


    private int cutNumbers() {
        long millis = getTime();
        int star = (int) (millis % (MAX - MiN) + MiN);
        return star;
    }


    private long getTime() {
        return System.currentTimeMillis();
    }
}

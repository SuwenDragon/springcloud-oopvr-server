package com.oopvr.production.tool.wrench;

import com.oopvr.production.tool.GearDemandImplements;

public class ScissorsNumber extends GearDemandImplements {
    private static final int MAX = 3111111;
    private static final int MiN = 1;



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

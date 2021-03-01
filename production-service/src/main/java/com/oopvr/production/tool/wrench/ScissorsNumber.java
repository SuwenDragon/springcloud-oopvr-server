package com.oopvr.production.tool.wrench;

import com.oopvr.production.tool.GearDemandImplements;

import java.util.Random;

public class ScissorsNumber extends GearDemandImplements {
    // 验证码字符集
    private static final char[] CHARS = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override
    public String makeNumbers(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        long millis = getTime();
        int codes = (int) (millis >> 8);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(random.nextInt(codes));
        }
        return stringBuffer.toString().substring(0, length);
    }



    @Override
    public String makeShortCode(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        long millis = getTime();
        int codes = (int) (millis >> 16);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(random.nextInt(codes));
        }

        return stringBuffer.toString().substring(0, length);
    }

    @Override
    public String makeToken(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        int number = (int) (getTime() >> 32);
        for (int j = 0; j<length;j++){
            stringBuffer.append(CHARS[random.nextInt(CHARS.length)]);
            stringBuffer.append(random.nextInt(number));
        }
        return stringBuffer.toString().substring(0,length);
    }


    private long getTime() {
        return System.currentTimeMillis();
    }
}

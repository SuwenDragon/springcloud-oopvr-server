package com.oopvr.production.tool;

import com.oopvr.production.tool.wrench.HandleStringDense;
import com.oopvr.production.tool.wrench.ScissorsNumber;

public class GearDemandImplements implements GearDemand {
    @Override
    public String codeEncryption(String str) {
        return new HandleStringDense().codeEncryption(str);
    }

    @Override
    public String codeDecrypt(String str) {
        return new HandleStringDense().codeDecrypt(str);
    }

    @Override
    public String makeNumbers(int length) {
        return new ScissorsNumber().makeNumbers(length);
    }


    @Override
    public String makeShortCode(int length) {
        return new ScissorsNumber().makeShortCode(length);
    }

    @Override
    public String makeToken(int length) {
        return new ScissorsNumber().makeToken(length);
    }
}

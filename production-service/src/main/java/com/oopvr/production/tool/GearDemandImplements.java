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
    public int makeNumbers() {
        return new ScissorsNumber().makeNumbers();
    }


    @Override
    public int makeShortCode(int length) {
        return 0;
    }

    @Override
    public String makeToken(int length) {
        return null;
    }
}

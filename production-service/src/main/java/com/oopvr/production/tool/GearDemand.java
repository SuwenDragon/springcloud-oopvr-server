package com.oopvr.production.tool;


public interface GearDemand {

    /**
     *字符串加密
     * @param str
     * @return
     */
     String codeEncryption(String str);

    /**
     * 字符串解密
     * @param str
     * @return
     */
     String codeDecrypt(String str);


    /**
     * 根據長度生成一串數字(账号)
     * @param
     * @return
     */
     String makeNumbers(int length);


    /**
     * 根據長度生成一串较短的数字验证码，
     * @param length
     * @return
     */
     String makeShortCode(int length);


    /**
     * 根据长度生成令牌
     * @param length
     * @return
     */
     String makeToken(int length);
}

package com.oopvr.production.tool.wrench;

import com.oopvr.production.tool.GearDemandImplements;

public class HandleStringDense extends GearDemandImplements {
    private String str="0123456789)&*^%$";
    private char[] chars;

   public HandleStringDense(){
        this.chars = str.toCharArray();
    }

    public String codeEncryption(String str){
      return stringHexStr(str);
    }

    public String codeDecrypt(String str){
       return hexStrString(str);
    }

    private String stringHexStr(String str){
         StringBuilder sb = new StringBuilder("");
         int bit;
         byte[] bs = str.getBytes();
        for (int i = 0; i < bs.length; i++) {
                 bit = (bs[i] & 0x0f0) >> 4;
              sb.append(chars[bit]);
                  bit = bs[i] & 0x0f;
                sb.append(chars[bit]);
             }
        return sb.toString().trim();
    }

    private String hexStrString(String hexStr) {
          char[] hexs = hexStr.toCharArray();
          byte[] bytes = new byte[hexStr.length() / 2];
            int n;
            for (int i = 0; i < bytes.length; i++) {
                  n = str.indexOf(hexs[2 * i]) * 16;
                   n += str.indexOf(hexs[2 * i + 1]);
                   bytes[i] = (byte) (n & 0xff);
               }
           return new String(bytes);
       }
}

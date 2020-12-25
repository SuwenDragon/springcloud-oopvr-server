package com.oopvr.production.tool.wrench;

import com.oopvr.production.tool.GearDemandImplements;

import java.util.*;

public class HandleStringDense extends GearDemandImplements {
    private final String str = "zxcvbnmjhg)&*^%$";
    private final String chaos = "juyetdfcuaocuxzlsdonotdoitoopvri";
    private char[] chars;
    private char[] chaosAtom;

    public HandleStringDense() {
        this.chars = str.toCharArray();
        this.chaosAtom = chaos.toCharArray();
    }

    public String codeEncryption(String str) {
        return stringHexStr(str);
    }

    public String codeDecrypt(String str) {
        return makeCarding(str);
    }


    /**
     * 字符串转码
     * @param str
     * @return
     */
    private String stringHexStr(String str) {
        StringBuilder sb = new StringBuilder("");
        int bit;
        byte[] bs = str.getBytes();
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return makeMiscibility(sb.toString().trim());
    }

    /**
     * 字符串解码
     * @param hexStr
     * @return
     */
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


    /**
     * 转码后加混稀
     * @param str
     * @return
     */
    private String makeMiscibility(String str) {
        char[] sourceChar = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < sourceChar.length; i++) {
            stringBuffer.append(sourceChar[i]);
            if (i < chaosAtom.length) {
                stringBuffer.append(chaosAtom[i]);
            }
        }
        return stringBuffer.toString();
    }


    /**
     * 解混稀再解码
     * @param str
     * @return
     */
    private String makeCarding(String str) {
        char[] chars = str.toCharArray();
        List<Character> listchar = new LinkedList<Character>();
        StringBuffer stringBuffer = new StringBuffer();
        for (char s: chars) {
            listchar.add(s);
        }
        for (int i = 0;i<chars.length;i++){
            if (i == chaosAtom.length) break;
            if (i == listchar.size()) break;
            listchar.remove(i+1);
        }
        for (char charto: listchar){
            stringBuffer.append(charto);
        }
        return hexStrString(stringBuffer.toString());
    }
}


package tool;

import com.oopvr.production.tool.GearDemand;
import com.oopvr.production.tool.GearDemandImplements;

import java.util.LinkedList;
import java.util.List;

public class TestGearDemand {
  public static void main(String[] args) {
      GearDemand gearDemand = new GearDemandImplements();

     String strM=gearDemand.codeEncryption("ABCW不好了4564");
      System.out.println(strM);
      System.out.println(strM+"加密后");
      String s = gearDemand.codeDecrypt(strM);
      System.out.println(s+"解密后");
//
//
//     String has = "ABCD";
//      char[] chars1 = has.toCharArray();
//      char[] chars = strM.toCharArray();
//
//     StringBuffer stringBuffer = new StringBuffer();
//      for (int i = 0;i < chars.length;i++){
//          stringBuffer.append(chars[i]);
//          if (i < chars1.length){
//              stringBuffer.append(chars1[i]);
//          }
//      }
//      String sta = stringBuffer.toString();
//      System.out.println(stringBuffer.toString()+"混稀加密");
//      String jsj =  gearDemand.codeDecrypt(sta);
//      System.out.println(strM+"加密后");




      List<Character> listchar = new LinkedList<Character>();




    }
}

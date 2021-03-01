package tool;

import com.oopvr.production.tool.GearDemand;
import com.oopvr.production.tool.GearDemandImplements;
import com.oopvr.production.tool.wrench.ScissorsNumber;

import java.util.LinkedList;
import java.util.List;

public class TestGearDemand {
  public static void main(String[] args) {
      GearDemand gearDemand = new GearDemandImplements();

      String strM = gearDemand.codeEncryption("/");
      System.out.println(strM + "加密后");
      String s = gearDemand.codeDecrypt(strM);
      System.out.println(s + "解密后");

      for (int i = 0;i<10;i++){
          System.out.println(gearDemand.makeToken(5));
      }

  }
}

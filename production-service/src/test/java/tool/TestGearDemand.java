package tool;

import com.oopvr.production.tool.GearDemand;
import com.oopvr.production.tool.GearDemandImplements;

public class TestGearDemand {
  public static void main(String[] args) {
      GearDemand gearDemand = new GearDemandImplements();

     String strM=gearDemand.codeEncryption("还是打算789AOOS#T&&((");
      System.out.println(strM);
      System.out.println(gearDemand.codeDecrypt(strM));
    }
}

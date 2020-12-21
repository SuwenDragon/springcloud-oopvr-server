package tool;

import com.oopvr.production.tool.GearDemand;
import com.oopvr.production.tool.GearDemandImplements;

public class TestGearDemand {
  public static void main(String[] args) {
      GearDemand gearDemand = new GearDemandImplements();

     String strM=gearDemand.codeEncryption("ABCWI");
      System.out.println(strM);
      System.out.println(gearDemand.codeDecrypt(strM));

      System.out.println(System.currentTimeMillis()>>16);

      System.out.println(gearDemand.makeNumbers());

      System.out.println(10<<8);
    }
}

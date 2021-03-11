import com.oopvr.unity.service.TabulationToolNeuron;
import com.oopvr.unity.unitytool.ExcelFormUnityInterface;
import com.oopvr.unity.unitytool.ToolListInterface;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
public class Testxlsx {

//    public String filepath = "H:\\testdemo\\1.17\\1.17（一次性）佛山南海区乔治中英文学校优惠15.xls";

    @Autowired
    ExcelFormUnityInterface excelFormUnityInterface;
    @Autowired
    ToolListInterface toolListInterface;

    @Autowired
    TabulationToolNeuron tabulationToolNeuron;


    @Before
    public void setupPoi() {

    }

    @Test
    public void Test() throws Exception {

   }


    @Test
    public void TestUnityExcel() throws Exception{
//        SchoolTableRead schoolTableRead = new SchoolTableRead();
//        SourceExcelData sourceExcelData = schoolTableRead.readingSheet(filepath);
//        System.out.println(sourceExcelData.toString());
    }


    /**
     * 制表工具
     * 源文件路径
     * 结果集路径
     * @throws Exception
     */
    @Test
    public void TestReadFile()  throws Exception{
        TabulationToolNeuron tabulationToolNeuron = new TabulationToolNeuron();
             String s = tabulationToolNeuron.makeTableExcel("H:\\testdemo\\1.17", "H:\\testresult\\",0);
        System.out.println(s);


    }
}

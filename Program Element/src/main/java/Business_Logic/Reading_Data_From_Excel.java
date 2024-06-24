package Business_Logic;





import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP0755c4c8-fbe0-4faf-a314-8fb9e2689207")
public class Reading_Data_From_Excel implements Nlp {
    @InputParams({@InputParam(name = "FilePath", type = "java.util.Properties"),
    	         @InputParam(name = "SheetName", type = "java.lang.String"),
    	         @InputParam(name = "RowValue", type = "java.lang.String"),
    	         @InputParam(name = "CellValue", type = "java.lang.String")})
    @ReturnType(name = "FinaleValue", type = "java.lang.String")

      @Override
      public List<String> getTestParameters() throws NlpException {
        List<String> params = new ArrayList<>();
        return params;
      }

      @Override
      public StringBuilder getTestCode() throws NlpException {
        StringBuilder sb = new StringBuilder();
        return sb;
      }
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
           String result=null;
           Properties properties = new Properties();
         try {
        	 
        	 String FilePath = (String) attributes.get("FilePath");
        	 String SheetName = (String) attributes.get("SheetName");
        	 String RowValue = (String) attributes.get("RowValue");
        	 String CellValue = (String) attributes.get("CellValue");
        	 Integer RowIndex=Integer.parseInt(RowValue);
             Integer CellIndex=Integer.parseInt(CellValue);
             properties.load(new FileInputStream("config.properties"));
        		File file=new File(FilePath);
        	 	FileInputStream fis = new FileInputStream(file);
        	 	
        	 Workbook workbook=  WorkbookFactory.create(fis);
        	  Sheet sheet=workbook.getSheet(SheetName);
        	  Row row=sheet.getRow(RowIndex);
        	  Cell cell=row.getCell(CellIndex);
        	  result=  cell.getStringCellValue();
        	        
        	nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Successfully Get Value From Excel");
        	 	  }
         catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
   			nlpResponseModel.setMessage("Failed To Get Value From Excel");
		}

       
          nlpResponseModel.getAttributes().put("FinaleValue", result);
          return nlpResponseModel;
      }
  } 
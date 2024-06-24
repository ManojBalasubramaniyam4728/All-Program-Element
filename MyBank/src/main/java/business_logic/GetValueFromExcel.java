
package business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPd900321e-7369-46c7-8edb-22d6e941e035")
public class GetValueFromExcel implements Nlp {
    @InputParams({@InputParam(name = "filePath", type = "java.lang.String"), 
    	@InputParam(name = "sheetName", type = "java.lang.String"), 
    	@InputParam(name = "uniqueData", type = "java.lang.String"), 
    	@InputParam(name = "Vertical(true/false)", type = "java.lang.Boolean")})
    @ReturnType(name = "map", type = "java.util.Map")

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
          String filePath = (String) attributes.get("filePath");
          String sheetName = (String) attributes.get("sheetName");
          String uniqueData = (String) attributes.get("uniqueData");
          Boolean vertical = (Boolean) attributes.get("Vertical(true/false)");
          Map map=new LinkedHashMap<String,String>();
          try {
        	  FileInputStream file=new FileInputStream(filePath);
      		Workbook work=new XSSFWorkbook(file);
      		Sheet sheet=work.getSheet(sheetName);
      		CellAddress adress=findCellAdress(sheet,uniqueData);
      		  int rowNumber=adress.getRow();
      		  int columNumber=sheet.getRow(rowNumber).getPhysicalNumberOfCells(); 
      		  if(vertical){
      			  for (int i = rowNumber; i == rowNumber; i++) {
      				  int h = 0;
      				  map.put(sheet.getRow(i).getCell(h).getStringCellValue(),
      				  sheet.getRow(i).getCell(h + 1).getStringCellValue()); 
      				  }
      			  }
      		  else {
      			  for(int i=0;i<columNumber;i++) {
      				  for(int j=rowNumber-1;j<rowNumber;j++) {
      					  j=rowNumber-1;
      					  map.put(sheet.getRow(j).getCell(i).getStringCellValue(),sheet.getRow(j+1).getCell(i).getStringCellValue());
      				  }
      			  }
      		  }
      		
      		nlpResponseModel.setMessage("Fetched Value successfully");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage(e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
          nlpResponseModel.getAttributes().put("map", map);
          return nlpResponseModel;
      }

	private CellAddress findCellAdress(Sheet sheet, String uniqueData) {
		for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(uniqueData)) {
                    return cell.getAddress();
                }
            }
        }
		return null;
	}

	
  } 


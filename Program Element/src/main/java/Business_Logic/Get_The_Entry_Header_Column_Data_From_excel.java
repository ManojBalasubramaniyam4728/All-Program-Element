
package Business_Logic;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLPa90b7241-2d5f-4012-b4b6-ed1bba059ffb")
public class Get_The_Entry_Header_Column_Data_From_excel implements Nlp {
    @InputParams({@InputParam(name = "filePath", type = "java.lang.String"),
    	@InputParam(name = "sheetName", type = "java.lang.String"),
    	@InputParam(name = "columnName", type = "java.lang.String")})
    @ReturnType(name = "expectedColumnData", type = "java.util.ArrayList")

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
          String columnName = (String) attributes.get("columnName");

          ArrayList<String> columnData = new ArrayList<>();
                  try (FileInputStream file = new FileInputStream(filePath)) {
                      Workbook workbook = WorkbookFactory.create(file);
                      Sheet sheet = workbook.getSheet(sheetName);

                      int columnIndex = -1;
                      Row headerRow = sheet.getRow(0);

                      // Find the column index based on the column name
                      for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                          Cell cell = headerRow.getCell(i);
                          if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                              columnIndex = i;
                              break;
                          }
                      }

                      if (columnIndex == -1) {
                    	nlpResponseModel.setStatus(CommonConstants.pass);
              			nlpResponseModel.setMessage("Column not found in The Excel");
                      }

                      // Read column data starting from the second row
                      for (int i = 1; i <= sheet.getPhysicalNumberOfRows()-1; i++) {
                          Row row = sheet.getRow(i);
                          Cell cell = row.getCell(columnIndex);
                          
                          if (cell != null) {
                              switch (cell.getCellType()) {
                                  case STRING:
                                      columnData.add(cell.getStringCellValue());
                                      break;
                                  case NUMERIC:
                                      columnData.add(String.valueOf(cell.getNumericCellValue()));
                                      break;
                                  case BOOLEAN:
                                      columnData.add(String.valueOf(cell.getBooleanCellValue()));
                                      break;
                                  default:
                                      columnData.add(""); // For blank cells
                              }
                          } else {
                              columnData.add(""); // For blank cells
                          }
                      }
                      workbook.close();
                      file.close();
                      nlpResponseModel.setStatus(CommonConstants.pass);
            		  nlpResponseModel.setMessage("Successfully Fatched Headers Column Data From Excel");
                     } 
                  catch (Exception e) {
                	  nlpResponseModel.setStatus(CommonConstants.fail);
            		  nlpResponseModel.setMessage("Failed Fatched Headers Column Data From Excel"+e);
                  }
                  
          nlpResponseModel.getAttributes().put("expectedColumnData", columnData);
          return nlpResponseModel;
      }}
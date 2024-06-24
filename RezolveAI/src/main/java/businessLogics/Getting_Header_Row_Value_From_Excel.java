
package businessLogics;

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
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLPebc2fca7-5ba6-474f-adba-69e96442fef4")
public class Getting_Header_Row_Value_From_Excel implements Nlp {
	@InputParams({@InputParam(name = "FilePath", type = "java.lang.String"),
		          @InputParam(name = "SheetName", type = "java.lang.String")})
	@ReturnType(name = "Key", type = "java.util.ArrayList")

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
		
		String FilePath = (String) attributes.get("FilePath");
		String SheetName = (String) attributes.get("SheetName");
		
		ArrayList<String> values = new ArrayList<String>();
		
		try {
			FileInputStream fis = new FileInputStream(FilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {
					XSSFSheet sheet=workbook.getSheetAt(i);
					Iterator<Row> rows=sheet.rowIterator();
					Row  firstRow  =rows.next();
					Iterator<Cell> cell=firstRow.cellIterator();
					int k=0;
					int coloumn=0;
					while(cell.hasNext()) {
					Cell value=	cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Ticket No")) {
						coloumn=k;
					}

					k++;
					}
					System.out.println(coloumn);
					Iterator<Cell>	cv=firstRow.cellIterator();
						while(cv.hasNext()) {
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
							values.add(c.getStringCellValue());
						       }
							else {
								values.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
		nlpResponseModel.setStatus(CommonConstants.pass);
	    nlpResponseModel.setMessage("Successfully Getted Header Value");
		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
		    nlpResponseModel.setMessage("Failed to Get Header Value"+e);
		}

		nlpResponseModel.getAttributes().put("Key", values);
		return nlpResponseModel;

	}
}
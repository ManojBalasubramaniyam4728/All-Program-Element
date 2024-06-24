package business_Logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
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

@Component("LIC15066_PJT1001_PE_NLP924d9450-f64a-414d-9e6c-650b5c6c8dc7")
public class FetchDataFromExcel implements Nlp {
	@InputParams({@InputParam(name = "ExcelPath", type = "java.lang.String"), @InputParam(name = "SheetName", type = "java.lang.String"),@InputParam(name = "TestCaseId", type = "java.lang.String")})
	@ReturnType(name = "MapData", type = "java.util.Map")

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
		String excelPath = (String) attributes.get("ExcelPath");
		String sheetName = (String) attributes.get("SheetName");
		String expectedTestCaseId = (String) attributes.get("TestCaseId");
		Map<String,String>	value=null;
		try {
			value=getDataFromExcel(excelPath, sheetName, expectedTestCaseId, nlpResponseModel);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Succesfully fetched the data from excel and stored in Map");


		} catch (IOException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch the data from excel");
			e.printStackTrace();
		}


		nlpResponseModel.getAttributes().put("MapData", value);
		return nlpResponseModel;

	}
	public static Map<String,String> getDataFromExcel(String excelPath, String sheetName, String expectedTestCaseId, NlpResponseModel nlpResponseModel) throws IOException {
		FileInputStream fisExcel=new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fisExcel);
		DataFormatter df=new DataFormatter();
		Map<String, String> map=new LinkedHashMap<>();
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index

		String value="";
		for (int i = 0; i <=lastRowNumber; i++) {
			String actualTestcase = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (actualTestcase.equals(expectedTestCaseId)) {
				short lastcellNumber = sheet.getRow(i).getLastCellNum(); //return count/size ==> count-1
				for (int j = 1; j < lastcellNumber-1; j++) {
					String actualKey = df.formatCellValue(sheet.getRow(i-1).getCell(j));
					value = df.formatCellValue(sheet.getRow(i).getCell(j));
					map.put(actualKey, value);
				}
				break;
			}

		}
		System.out.println(value);
		workbook.close();
		fisExcel.close();
		return map;

	}




}




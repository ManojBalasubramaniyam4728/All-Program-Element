package Business_Logic;

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

@Component("LIC15066_PJT1001_PE_NLP1002")
public class FetchDataFromExcelVertical implements Nlp {
	@InputParams({@InputParam(name = "ExcelPath", type = "java.lang.String"), @InputParam(name = "SheetName", type = "java.lang.String"),@InputParam(name = "Key", type = "java.lang.String")})
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
		String expectedTestCaseId = (String) attributes.get("Key");
		Map<String,String>	value=null;
		try {
			value=getAllColumnDataBasedOnTestID(excelPath, sheetName, expectedTestCaseId, nlpResponseModel);
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
	
	public  static LinkedHashMap<String, String> getAllColumnDataBasedOnTestID(String excelPath, String sheetName,String testCaseId,NlpResponseModel nlpResponseModel) throws IOException {
	        FileInputStream fisExcel = new FileInputStream(excelPath);
		    Workbook workbook = WorkbookFactory.create(fisExcel);
			DataFormatter df = new DataFormatter();
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			Sheet sheet = workbook.getSheet(sheetName);

			String value = "";
			String actualTestCaseName = "";
			String actualKey = "";
			for (int i = 1; i <= sheet.getRow(i).getLastCellNum(); i++) {

				try {
					actualTestCaseName = df.formatCellValue(sheet.getRow(0).getCell(i));

				} catch (Exception e) {
				}
				if (actualTestCaseName.equalsIgnoreCase(testCaseId)) {
					for (int j = 0; j <= sheet.getLastRowNum(); j++) {

						try {
							actualKey = df.formatCellValue(sheet.getRow(j).getCell(i-1));
							try {
								value = df.formatCellValue(sheet.getRow(j).getCell(i));
							} catch (Exception e) {
							}

							if ((actualKey.isEmpty()&&value.isEmpty()) ||actualKey.isEmpty()) {
							} else {
								map.put(actualKey, value);
							}
						} catch (Exception e) {
						}
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




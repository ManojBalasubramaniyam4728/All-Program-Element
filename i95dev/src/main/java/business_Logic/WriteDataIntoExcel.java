package business_Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC15066_PJT1001_PE_NLPd1cf0f31-21fe-4d1b-b7d8-35cc7fa08887")
public class WriteDataIntoExcel implements Nlp {


	@InputParams({@InputParam(name = "excelPath", type = "java.lang.String"),
		@InputParam(name = "sheetName", type = "java.lang.String"),
		@InputParam(name = "TestCaseId", type = "java.lang.String"),
		@InputParam(name = "expectedHeader", type = "java.lang.String"),
		@InputParam(name = "value", type = "java.lang.String")})
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		String excelPath = (String) attributes.get("excelPath");
		String sheetName = (String) attributes.get("sheetName");
		String TestCaseId = (String) attributes.get("TestCaseId");
		String expectedHeader = (String) attributes.get("expectedHeader");
		String value = (String) attributes.get("value");


		try {
			WriteDataInToExcel(excelPath, sheetName, TestCaseId, expectedHeader, value);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully written the value "+value +" in the file");
		} catch (EncryptedDocumentException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to write due to"+e );
			e.printStackTrace();
		} catch (IOException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to write due to"+e);

			e.printStackTrace();
		}



		return nlpResponseModel;
	}
	public static String WriteDataInToExcel(String excelPath, String sheetName, String TestCaseId, String expectedHeader,String value) throws EncryptedDocumentException, IOException {
		FileInputStream excelFile = new FileInputStream(new File(excelPath));
		Workbook workbook =  WorkbookFactory.create(excelFile);
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df=new DataFormatter();
		boolean flag = false;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String actualTestCaseName="";
			try {
				actualTestCaseName =df.formatCellValue(sheet.getRow(i).getCell(0));
			} catch (Exception e) {
			}
			if (actualTestCaseName.equalsIgnoreCase(TestCaseId)) {
				for (int j = 1; j <= sheet.getRow(i).getLastCellNum(); j++) {
					String actualKey="";
					try {
						actualKey =df.formatCellValue( sheet.getRow(i - 1).getCell(j));
					} catch (Exception e) {
					}
					if (actualKey.equalsIgnoreCase(expectedHeader)) {
						try {
							sheet.getRow(i).createCell(j).setCellValue(value);
							System.out.println("Data Written");
						} catch (Exception e) {
						}
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();
		workbook.close();

		return value;

	} 
}


package businessLogics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC7818_PJT1001_PE_NLP90df2436-7c61-4b7b-81b7-2284d2f1d166")
public class CompareExcelValueAndFillColour implements Nlp {
	@InputParams({ @InputParam(name = "Excel Path", type = "java.lang.String"),
			@InputParam(name = "Sheet Name", type = "java.lang.String"),
			@InputParam(name = "Row Name", type = "java.lang.String"),
			@InputParam(name = "Header Name", type = "java.lang.String"),
			@InputParam(name = "Expected Text", type = "java.lang.String") })

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
		String ExcelPath = (String) attributes.get("Excel Path");
		String SheetName = (String) attributes.get("Sheet Name");
		String RowName = (String) attributes.get("Row Name");
		String HeaderName = (String) attributes.get("Header Name");
		String ExpectedText = (String) attributes.get("Expected Text");

		try {
			File file = new File(ExcelPath);
			FileInputStream fis = new FileInputStream(file);
			Workbook work = WorkbookFactory.create(fis);
			Sheet sheet = work.getSheet(SheetName);

			// To get header index and // to find rowindex
			Integer headerIndex = -1;
			Integer rowIndex = -1;
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				String row = sheet.getRow(i).getCell(0).getStringCellValue();
				if (row.equalsIgnoreCase(RowName)) {
					rowIndex = i;
					break;
				}
			}
			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				String header = sheet.getRow(0).getCell(i).getStringCellValue();
				if (header.equalsIgnoreCase(HeaderName)) {
					headerIndex = i;
					break;
				}
			}

			String old = sheet.getRow(rowIndex).getCell(headerIndex).getStringCellValue();
			//log.info(old);
			if (!(old.toLowerCase().contains(ExpectedText.toLowerCase()))) {
				Cell r = sheet.getRow(rowIndex).getCell(headerIndex);
				FileOutputStream fos = new FileOutputStream(file);
				r.setCellValue(old + " != " + ExpectedText);
				CellStyle style = work.createCellStyle();
				// style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.THIN_BACKWARD_DIAG);
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				// style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				r.setCellStyle(style);
				work.write(fos);

				fos.close();
			}
			fis.close();
			work.close();
			System.out.println("sdfcvgbhn m");
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully compared in excel");
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Successfully compared in excel");
		}
		return nlpResponseModel;
	}
}
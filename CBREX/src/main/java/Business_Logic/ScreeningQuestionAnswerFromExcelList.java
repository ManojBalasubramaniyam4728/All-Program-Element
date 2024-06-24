package Business_Logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
@Component("LIC10506_PJT1001_PE_NLP6a99be3a-a52e-42ef-a737-fd4ee3e20b13")
public class ScreeningQuestionAnswerFromExcelList implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String"),
			@InputParam(name = "filePath", type = "java.lang.String"),
			@InputParam(name = "SheetName", type = "java.lang.String"),
			@InputParam(name = "cellIndex", type = "java.lang.Integer") })
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
		String Xpath = (String) attributes.get("Xpath");
		String filePath = (String) attributes.get("filePath");
		String SheetName = (String) attributes.get("SheetName");
		Integer cellIndex = (Integer) attributes.get("cellIndex");

		try {
			WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
			// to store questions in list
			List qestionsList = new ArrayList<>();
			List<WebElement> NOofQuestions = driver.findElements(By.xpath(Xpath));
			for (WebElement no : NOofQuestions) {
				qestionsList.add(no.getText());
			}
			//log.info("Questions Stored In List " + NOofQuestions.size());

			// to move on element
			Actions actn = new Actions(driver);
			for (int i = 1; i <= NOofQuestions.size(); i++) {
				WebElement questionNO = driver.findElement(By.xpath("(" + Xpath + ")[" + i + "]"));
				actn.moveToElement(questionNO).build().perform();
				Thread.sleep(1000);
				//log.info("Success to move untill Element");

				// to get answer from excel
				String AnswerforQestion = "";
				String questionText = "";
				try {
					// String questionText=(String) qestionsList.get(i);
					questionText = questionNO.getText();
					if (questionText.contains("*")) {
						questionText = questionText.replace("*", "").trim();
						//log.info(questionText);
					}
				//	log.info("Question is " + questionText);
					// to Store in collection

					List<String> excelList = new ArrayList<String>();
					FileInputStream fis = new FileInputStream(filePath);
					Workbook workbook = WorkbookFactory.create(fis);
					// Workbook workbook = new XSSFWorkbook(fis);
					Sheet sheet = workbook.getSheet(SheetName);
					
					for (int j = 0; j < sheet.getLastRowNum(); j++) {
						String row = sheet.getRow(j).getCell(0).getStringCellValue();
						excelList.add(row);
					}
					//log.info("Excel list is" + excelList);

					int index = -1; // initialize to -1 in case no match is found
					for (int k = 0; k < excelList.size(); k++) {
						String listvalue = excelList.get(k);
						if (questionText.contains(listvalue)) {
							index = k;
							AnswerforQestion = sheet.getRow(k).getCell(1).getStringCellValue();
						//	log.info("fetch value from excel " + AnswerforQestion);
							break;
                         }
					}
                	if (index == -1) {
					//	log.info("Question not found in Excel, Question Added to excel");
						Thread.sleep(500);
						Row row = sheet.createRow(sheet.getLastRowNum() + 1);
						Cell cell = row.createCell(0);
						cell.setCellValue(questionText);
						FileOutputStream fos = new FileOutputStream(filePath);
						workbook.write(fos);
					//	log.info(questionText + "Added into excel");
						workbook.close();
						fos.close();
					}
					workbook.close();
					fis.close();

					Thread.sleep(500);
				}

				catch (Exception e) {
					//log.info("Failed to get data from excel " + e);
				}
//				WebElement dropdown = driver.findElement(By.xpath("(//select[@id])[" + i + "]"));
//				Select select = new Select(dropdown);
//				select.selectByVisibleText(AnswerforQestion);
				//log.info("Started to Answer");
				try {
					// to find Element type
					WebElement type = driver
							.findElement(By.xpath("(//label[@class])[" + i + "]/following-sibling::div/div[1]/*[1]"));
					Thread.sleep(500);
					String tagname = type.getTagName();
					//log.info("tagName is " + tagname);
					if (tagname.equals("select")) {
						WebElement dropdown = driver
								.findElement(By.xpath("//label[contains(text(),\"" + questionText + "\")]/..//select"));
						Select select = new Select(dropdown);
						select.selectByVisibleText(AnswerforQestion);

					} else if (tagname.equals("textarea")) {
						WebElement textareas = driver.findElement(
								By.xpath("//label[contains(text(),\"" + questionText + "\")]/..//textarea"));
						textareas.sendKeys(AnswerforQestion);
					} else if (tagname.equals("input")) {
						WebElement textfield = driver
								.findElement(By.xpath("//label[contains(text(),\"" + questionText + "\")]/..//input"));
						textfield.sendKeys(AnswerforQestion);
					}

					else if (tagname.equals("div")) {
						WebElement option = driver.findElement(By.xpath("//label[contains(text(),\"" + questionText
								+ "\")]/..//div[contains(text(),\"" + AnswerforQestion + "\")]"));
						// driver.findElement(By.xpath("//*[@text='" + text + "']"))
						// driver.findElement(By.xpath("//*[@text=\"" + text + "\"]"))

						Actions actions = new Actions(driver);
						actions.moveToElement(option).build().perform();
						Thread.sleep(500);
						// option.click();
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", option);
					}
					//log.info("Success to clicked on find element");
				}

				catch (Exception e) {
					//log.info("Failed to get element " + e);
				}
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Succesfully Answered for Screening Questions");
		} catch (Exception e1) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Answer for Screening Questions" + e1);
		}

//        String string3 = "Return Value";
//        nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}
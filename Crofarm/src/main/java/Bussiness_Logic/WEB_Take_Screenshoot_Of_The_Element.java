package Bussiness_Logic;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC15856_PJT1001_PE_NLPcb775899-55e1-4701-98ba-28ff5ef7d52a")
public class WEB_Take_Screenshoot_Of_The_Element implements Nlp {
	@InputParams({ @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
		           @InputParam(name = "filePathToSave", type = "java.lang.String"),
               	   @InputParam(name = "nameofTheScreenShoot", type = "java.lang.String"),
                   @InputParam(name = "imageFormateType", type = "java.lang.String"),})

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
		WebElement element = (WebElement) attributes.get("element");
		String filePathToSave = (String) attributes.get("filePathToSave");
		String nameofTheScreenShoot = (String) attributes.get("nameofTheScreenShoot");
		String imageFormateType = (String) attributes.get("imageFormateType");

		try {
			File screenshotFile = element.getScreenshotAs(OutputType.FILE);
            String imageTyp=imageFormateType.toLowerCase();
			File screenshotOfElement = new File(filePathToSave.trim()+"/"+nameofTheScreenShoot.trim()+"."+imageTyp.trim());
			FileUtils.copyFile(screenshotFile, screenshotOfElement);

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Succesfully Taken Screenshot of " + element);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Take Screenshot of " + element + " " + e);
		}
		return nlpResponseModel;
	}
}
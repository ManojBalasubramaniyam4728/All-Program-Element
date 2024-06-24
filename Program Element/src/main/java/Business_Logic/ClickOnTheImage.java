package Business_Logic;
import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sikuli.basics.Settings;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC3277_PJT1002_PE_NLPbee066e2-8209-47e3-b944-ffe8c17e2a5e")
public class ClickOnTheImage implements Nlp {
	@InputParams({ @InputParam(name = "Visual Element", type = "org.openqa.selenium.WebElement")})
	
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
		Map<String, Object> programElementsInput = nlpRequestModel.getAttributes();
		byte[] byteStream = null;
		try {
			System.setProperty("java.awt.headless", "false");
//			List<Locator> locatorsObject  = (List<Locator>) programElementsInput.get("visual testing");
//			Map<String, Object> singleLocator = new ObjectMapper().readValue(locatorsObject.get(0).toString(), Map.class);
//			Map<String, Object> singleLocator = (Map<String, Object>) locatorsObject.get(0);
			programElementsInput.entrySet().forEach(programeElement -> {
				
		        try {
		        	byte[] fileByte = (byte[]) programeElement.getValue();
		        	ByteArrayInputStream byteArray = new ByteArrayInputStream(fileByte);
		        	ByteArrayInputStream ip = byteArray;
					Path tempFilePath = Paths.get(System.getProperty("java.io.tmpdir"), Paths.get("tempImageFile.png").toString());
			        System.out.println("Temp file path is; " + tempFilePath);
					Files.copy(ip, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
					 ip.close();
			        Screen screen = new Screen();
			        Settings.MoveMouseDelay = 0;
			        Pattern pattern = new Pattern(tempFilePath.toString());
			        screen.wait(pattern, 10);
			        screen.mouseMove(pattern);
			        screen.click(pattern);
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					nlpResponseModel.setMessage("Pattern Value : " + " "  + byteStream + " exception is: " + sw);
					nlpResponseModel.setStatus(CommonConstants.fail);
				}
			}
			);
			nlpResponseModel.setMessage("Clicked on image element");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			nlpResponseModel.setMessage(programElementsInput+"Parameters Value : "+ byteStream + " exception is: " + sw);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
	
}







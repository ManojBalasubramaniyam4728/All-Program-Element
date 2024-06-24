
package business_logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component("LIC1002_PJT1016_PE_NLP595ee05f-5eb6-4946-9fb5-6a5e7bba7f3d")
public class IOS_Long_Press_Element implements Nlp {
	@InputParams({ @InputParam(name = "xpath", type = "java.lang."),
		            @InputParam(name = "LongPressWait", type = "java.lang.Integer")})

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
		AppiumDriver driver = (AppiumDriver) nlpRequestModel.getIosDriver();
		String xpath=(String) attributes.get("xpath");
		Integer LongPressWait=(Integer) attributes.get("LongPressWait");
	
		try {
			try {
				WebElement xpathElemet=driver.findElement(By.xpath(xpath));
				//log.info("Found the element. Proceeding to next step1");
	                if(Objects.nonNull(xpathElemet)) {
	                } else {
	                	//log.info("Element not found");
	                    nlpResponseModel.setStatus(CommonConstants.fail);
	                    nlpResponseModel.setMessage(xpathElemet + " " + " not found in first block");
	                }
	            } catch (NoSuchElementException e) {
	            	// log.error("NoSuchElementException in IOS_Long press ", e);
	                nlpResponseModel.setStatus(CommonConstants.fail);
	                nlpResponseModel.setMessage(xpath + " " + " Not found in screen");
	            } catch (Exception e) {
	            //	 log.error("NLP_EXCEPTION in IOS_Long press ", e);
	                nlpResponseModel.setStatus(CommonConstants.fail);
	                nlpResponseModel.setMessage(xpath + " " + " Not found");
	            }
			
			  //Obtaining Location and size
			   WebElement element=driver.findElement(By.xpath(xpath));
			  // log.info("Found the element. Proceeding to next step2");
			    Point location = element.getLocation();
			  //  log.info("Found the element. Proceeding to next step3");
			    Rectangle rect = element.getRect();
			  //  log.info("Found the element. Proceeding to next step4");
			    Integer xCoordinate = location.x + (rect.width / 2);
			  //  log.info("Found the element. Proceeding to next step5");
			    Integer yCoordinate = location.y + (rect.height / 2);
			 //   log.info("Found the element. Proceeding to next step6");
			
			//Point class for w3c Action
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			// log.info("Found the element. Proceeding to next step7");
			Sequence longPress = new Sequence(input, 0);
			// log.info("Found the element. Proceeding to next step8");
			
            // //Performing action That is Long press
			longPress.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xCoordinate, yCoordinate));
			// log.info("Found the element. Proceeding to next step9");
			longPress.addAction(input.createPointerDown(0));
			// log.info("Found the element. Proceeding to next step10");
			longPress.addAction(new Pause(input, Duration.ofSeconds(LongPressWait)));
			// log.info("Found the element. Proceeding to next step11");
			longPress.addAction(input.createPointerUp(0));
			// log.info("Found the element. Proceeding to next step12");
			driver.perform(List.of(longPress));
			// log.info("Found the element. Proceeding to next step13");
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Long Presed On Element");
		}
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Long Presed On Element"+" "+e);
		}
	
		return nlpResponseModel;
	}

}
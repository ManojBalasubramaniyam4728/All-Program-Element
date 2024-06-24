
package businessLogic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1008_PE_NLP279181bb-5d60-47e0-a432-69f068e996d3")
public class MOB_Drag_Source_Element_And_Drop_In_Targeted_Element implements Nlp {
	@InputParams({ @InputParam(name = "sourceXpath", type = "java.lang.String"),
			@InputParam(name = "targetXpath", type = "java.lang.String") })

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
		String sourceXpath = (String) attributes.get("sourceXpath");
		String targetXpath = (String) attributes.get("targetXpath");
		AppiumDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();

		try {
			//Source Element
			WebElement sourceElement= driver.findElement(By.xpath(sourceXpath));
			Point sourceLocationOfSourceElement = sourceElement.getLocation();
			Dimension sourceSizeOfSourceElement = sourceElement.getSize();
			int centerXSourceElement = sourceLocationOfSourceElement.getX() + sourceSizeOfSourceElement.getWidth() / 2;
			int centerYSourceElement = sourceLocationOfSourceElement.getY() + sourceSizeOfSourceElement.getHeight() / 2;
			
			//Target Element
			WebElement targetElement= driver.findElement(By.xpath(targetXpath));
			Point sourceLocationOfTargetElement = targetElement.getLocation();
			Dimension sourceSizeOfTargetElement = targetElement.getSize();
			int centerXTargetElement = sourceLocationOfTargetElement.getX() + sourceSizeOfTargetElement.getWidth() / 2;
			int centerYTargetElement = sourceLocationOfTargetElement.getY() + sourceSizeOfTargetElement.getHeight() / 2;
			
			
			
			//Point class for w3c Action
			PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragNDrop=new Sequence(finger, 1);
	        
	        //Performing action That is Drag and drop
            dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerXSourceElement, centerYSourceElement));
            dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(),centerXTargetElement, centerYTargetElement));
            dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Arrays.asList(dragNDrop));
            nlpResponseModel.setStatus(CommonConstants.pass);
		    nlpResponseModel.setMessage("Successfully Drag Target Element And Droped In Source Element ");
		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
		    nlpResponseModel.setMessage("Failed To Drag Target Element And Droped In Source Element "+e);
		}

		return nlpResponseModel;
	}
}
package Business_Logic;




import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.android.AndroidDriver;

@Component("LIC5197_PJT1002_PE_NLP4071a6a5-496f-4f70-bb7b-e6ebffd030e6")
public class MOB_SwipeUpUntilElementIsVisible implements Nlp {
	@InputParams({@InputParam(name = "xpath", type = "java.lang.String"), @InputParam(name = "Max swipe count", type = "java.lang.Integer")})

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
		String xpath = (String) attributes.get("xpath");
		int maxSwipeCount = (Integer) attributes.get("Max swipe count");

		AppiumDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();
		try {

			Dimension screenSize = driver.manage().window().getSize();//Identify screen dimension
			int screenCenter = (int) (screenSize.getWidth()*0.5);//Identify center point of screen for Y axis
			int startPoint = (int) (screenSize.getHeight()*0.5);//Identify beginning point of scroll for X axis
			int endPoint = (int) (screenSize.getHeight()*0.2);//Identify ending point of scroll
			int count = 0;			

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

			//Search Element until it is available on screen. If no, then perform below operations
			while (driver.findElements(By.xpath(xpath)).isEmpty()) {
				Sequence swipe =  new Sequence(finger, 1);

				//Move finger into starting position
				swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), screenCenter, startPoint));


				//Finger goes up into contact with screen
				swipe.addAction(finger.createPointerDown(0));

				//Finger moves to End Position
				swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), screenCenter, endPoint));

				//Take out finger from screen
				swipe.addAction(finger.createPointerUp(0));

				driver.perform(Arrays.asList(swipe));

				if(++count >= maxSwipeCount) {
					break;
				}
				if(count >= maxSwipeCount) {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Failed to swipe up  until element is visible");
				}
				else {
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Swiped up  until element is visible");
				}
			}
		}
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to swipe up until element is visible");
		}
		return nlpResponseModel;
	}
} 
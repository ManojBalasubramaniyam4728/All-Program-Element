package Business_Logic;



import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLPcc726405-331b-4371-b68f-336b38b43967")
public class Get_Colour_Of_Element implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String"),
    	         @InputParam(name = "CssValue", type = "java.lang.String"),
    	         @InputParam(name = "AsHexValue", type = "java.lang.String"),
    	         @InputParam(name = "ColourType", type = "java.lang.String"),})
    @ReturnType(name = "OutPutColour", type = "java.lang.String")

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
          String ColourIsPresent=null;
          
          try {
        	  String Xpath = (String) attributes.get("Xpath");
              String CssValue = (String) attributes.get("CssValue");
              String AsHexValue = (String) attributes.get("AsHexValue");
              String ColourType = (String) attributes.get("ColourType");
              
              WebDriver driver= (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
        	  WebElement element=	driver.findElement(By.xpath(Xpath));
        	  Thread.sleep(1000);
        	  String colorr=element.getCssValue(CssValue);
        	  Thread.sleep(1000);
        	  String excatcolor=Color.fromString(colorr).asHex();
        	  Thread.sleep(1000);
        	  if(excatcolor.contains(AsHexValue)) {
        		  Thread.sleep(1000);
        		  ColourIsPresent=ColourType;
        	  	}
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage(" Successfully Get_Colour_Of_Element Is"+" "+ColourIsPresent );
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("Failed To Get Colour Of Element"+" "+e );
		}

          

     
          nlpResponseModel.getAttributes().put("OutPutColour", ColourIsPresent);
          return nlpResponseModel;
      }
  } 
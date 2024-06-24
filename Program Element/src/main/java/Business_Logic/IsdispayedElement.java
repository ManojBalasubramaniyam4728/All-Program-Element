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

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP5d37b119-19d2-4186-9f0e-131e10d72e7e")
public class IsdispayedElement implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
        @InputParam(name = "elementType", type = "java.lang.String"),
        @InputParam(name = "elementName", type = "java.lang.String")})
    //@ReturnType(name = "Elementcoordinates", type = "java.lang.String")

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
          String elementType = (String) attributes.get("elementType");
          String elementName = (String) attributes.get("elementName");
         // String Elementcoordinates=null;
  	      WebElement element = (WebElement) attributes.get("element");

         try {
        	 
      	      element.isDisplayed();		  
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage(elementType+" "+elementName+" "+" Getted Elementcoordinates is "+" ");

                      }
         
         catch (Exception e) {
			 try {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage(e.getMessage()+"========="+element.toString());
 
	                          	}
			 catch (Exception e3) {
				 nlpResponseModel.setStatus(CommonConstants.fail);
	             nlpResponseModel.setMessage(e.getMessage()+"=====+++++++");
			}
         }
          return nlpResponseModel;
      }
  } 
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;


import org.springframework.stereotype.Component;

@Component("LIC14821_PJT1001_PE_NLPd0b699dd-cb81-4b9f-9fdb-bd95f22162c5")
public class MOB_Get_Text_From_List_Of_Webelements implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
    @ReturnType(name = "GettedTestList", type = "java.util.List")

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
          
          List<String> textList = new ArrayList<String>();
          try {
        	  
        	  String Xpath = (String) attributes.get("Xpath");
        	  
        	  WebDriver driver = (WebDriver) nlpRequestModel.getAndroidDriver();
        	  List<WebElement> elements = driver.findElements(By.xpath(Xpath));
        	  for (WebElement element : elements) {
        		  String text = element.getText();
        		    textList.add(text);
        	       	}
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Successfully Geted Text From Webelements");
            }
          
          catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Get Text From Webelements"+e);
		      }
         
          nlpResponseModel.getAttributes().put("GettedTestList", textList);
          return nlpResponseModel;
      }
  } 

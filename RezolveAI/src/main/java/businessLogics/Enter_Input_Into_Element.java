package businessLogics;




import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLP1d65d21d-2cde-457e-915a-f95d59f34a24")
public class Enter_Input_Into_Element implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
    	           @InputParam(name = "Input", type = "java.lang.String")})
    	
   

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
          try {
        	  WebDriver driver=(WebDriver)nlpRequestModel.getDriver().getSpecificIDriver();
        	  WebElement element = (WebElement) attributes.get("element");
        	 String Input = (String) attributes.get("Input");
        	  element.sendKeys(Input);
        	  nlpResponseModel.setStatus(CommonConstants.pass);
                nlpResponseModel.setMessage("Successfully Enter Input Into Element");
        	 }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed To Enter Input Into Element");
		}
          return nlpResponseModel;
      }
  } 
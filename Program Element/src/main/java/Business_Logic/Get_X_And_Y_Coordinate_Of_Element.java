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

@Component("LIC8536_PJT1001_PE_NLP9c0105bb-3d35-48a3-b6ce-5dc6b66265eb")
public class Get_X_And_Y_Coordinate_Of_Element implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
        @InputParam(name = "elementType", type = "java.lang.String"),
        @InputParam(name = "elementName", type = "java.lang.String")})
    @ReturnType(name = "Elementcoordinates", type = "java.lang.String")

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
          String Elementcoordinates=null;
          
         try {
        	 
      	      WebElement element = (WebElement) attributes.get("element");
      	      Point coordinates = (Point) element.getLocation();
              int Xcoordinates = coordinates.getX();
              int Ycoordinates = coordinates.getY();
              Elementcoordinates=(Xcoordinates +" "+Ycoordinates);
            		  
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage(elementType+" "+elementName+" "+" Getted Elementcoordinates is "+" "+Elementcoordinates);

                      }
         
         catch (Exception e) {
			 
        	 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage(elementType+" "+elementName+" "+ " Fail to Get Elementcoordinates ");
 
	                          	}
         
          
          nlpResponseModel.getAttributes().put("Elementcoordinates", Elementcoordinates);
          return nlpResponseModel;
      }
  } 
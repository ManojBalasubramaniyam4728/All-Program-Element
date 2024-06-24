
package default_package;

import com.tyss.optimize.common.util.*;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.nlp.util.annotation.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component("LIC3277_PJT1002_PE_NLP27d7a498-a8cd-4db8-9658-48fe122e46be")
public class AddTwoNumbers implements Nlp {
    @InputParams({@InputParam(name = "Number 1", type = "java.lang.Integer"), @InputParam(name = "Number 2", type = "java.lang.Integer")})
    @ReturnType(name = "Sum of Two numbers", type = "java.lang.Integer")

      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> programElementsInput = nlpRequestModel.getAttributes();
          Integer num1 = (Integer) programElementsInput.get("Number 1");
          Integer num2 = (Integer) programElementsInput.get("Number 2");
          int returnValue=0;

          try {
           // Your program element business logic starts here ...
              returnValue=num1+num2;
              nlpResponseModel.setMessage("Added two numbers");
              nlpResponseModel.setStatus(CommonConstants.pass);
              }
          catch(Exception e) {
           // Your program element Exception goes here ...
              nlpResponseModel.setMessage("Failed to add numbers");
              nlpResponseModel.setStatus(CommonConstants.fail);
              }

          // Your program element business logic ends here ...
          nlpResponseModel.getAttributes().put("Sum of Two numbers", returnValue);
          return nlpResponseModel;
      }

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
  } 
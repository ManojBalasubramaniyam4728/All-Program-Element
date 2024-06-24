
package default_package;

import com.tyss.optimize.common.util.*;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.nlp.util.annotation.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component("LIC3168_PJT1031_PE_NLPd25f37c2-c1e8-4a09-90b8-01d3998fcc23")
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
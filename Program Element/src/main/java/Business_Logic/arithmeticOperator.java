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

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;



@Component("LIC8536_PJT1001_PE_NLP50449097-e61a-469a-8842-e02cf1fa3fd2")
public class arithmeticOperator implements Nlp {
    @InputParams({@InputParam(name = "Input1", type = "java.lang.String"),
    	@InputParam(name = "Input2", type = "java.lang.String"),
    	          @InputParam(name = "Operator", type = "java.lang.String")})
    @ReturnType(name = "Result", type = "java.lang.Integer")

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
          String Input1 = (String) attributes.get("Input1");
          String Input2 = (String) attributes.get("Input2");
          String Operator = (String) attributes.get("Operator");
         Integer input1=Integer.parseInt(Input1);
         Integer input2=Integer.parseInt(Input2);
          
          // Your program element business logic goes here ...
         long result=0;
          try {
              switch (Operator) {
                  case "+":
                      result = input1 + input2;
                      break;
                  case "-":
                      result = input1 - input2;
                      break;
                  case "*":
                      result = input1 * input2;
                      break;
                  case "/":
                      result = input1 / input2;
                      break;
                      
              }
              nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Successfull Performed Arithmetic Operator ");
              }
          catch (ArithmeticException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Performed Arithmetic Operator"+e);
		}

          nlpResponseModel.getAttributes().put("Result", result);
          return nlpResponseModel;
      }
  } 


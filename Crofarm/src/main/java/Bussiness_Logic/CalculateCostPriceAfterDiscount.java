package Bussiness_Logic;


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




@Component("LIC15856_PJT1001_PE_NLPfcd86271-964a-40f6-a0b9-8163b559999f")
public class CalculateCostPriceAfterDiscount implements Nlp {
    @InputParams({@InputParam(name = "InputMarketPrice", type = "java.lang.Integer")})
    @ReturnType(name = "Result", type = "java.lang.String")

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
          Integer Input1 = (Integer) attributes.get("InputMarketPrice");
          
          
          // Your program element business logic goes here ...
         String result=null;
          try {
        	  int i =Input1;
      		double j =(15.0/100)*i;
      		double b=i-j;
      		//System.out.println(j);
      		//System.out.println(b);
      		 String s=null;
      		if (b % 1 != 0)
      	    {
      	    //System.out.print ("Decimal");
      	   double f= (((long)(b * 1e1)) / 1e1);
      	 //  System.out.println(f);
      	 result=Double.toString(f);
      	    }
      	else
      	    {
      	   // System.out.print ("Integer");
      	    int y = (int) b;
      	//    System.out.println(y);
      	  result=Integer.toString(y);
      	    }
                      
              
              nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Successfully Performed Calculation ");
              }
          catch (ArithmeticException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Calculation"+e);
		}

          nlpResponseModel.getAttributes().put("Result", result);
          return nlpResponseModel;
      }
  } 


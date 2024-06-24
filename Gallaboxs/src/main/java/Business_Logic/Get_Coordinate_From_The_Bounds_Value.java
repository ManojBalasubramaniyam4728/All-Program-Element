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


import org.springframework.stereotype.Component;

@Component("LIC13397_PJT1001_PE_NLP4d5af82d-b05a-4bd3-a8d6-f41e69794dad")
public class Get_Coordinate_From_The_Bounds_Value implements Nlp {
    @InputParams({@InputParam(name = "BoundsValue", type = "java.lang.String"),
    	         @InputParam(name = "XorYCoordinate", type = "java.lang.String")})
    @ReturnType(name = "Coordinates", type = "java.lang.String")

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
      private static boolean isNumber(String value) {
	        try {
	           
	            Double.parseDouble(value);
	            return true; 
	        } catch (java.lang.NumberFormatException e) {
	            return false; 
	        }
	    }
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
         NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          
          String BoundsValue = (String) attributes.get("BoundsValue");
          String  XorYCoordinate= (String) attributes.get("XorYCoordinate");
    	  String Coordinates="";
          try {
        		    	 String input =BoundsValue;
        		    	ArrayList<Integer> list=new ArrayList<Integer>();
        		    	  char[]a=input.toCharArray();
        		          String s="";
        		    	  for (int i = 0; i < a.length; i++) {
        		    		   if(Character.isDigit(a[i])) {
        		    			   s=s+a[i];
        		    			   continue;
        		    		   }
        		    		   else {   		   
        		    			   if(isNumber(s)) {
        		    				   list.add(Integer.parseInt(s));
        		    			   }
        		    			   s="";
        		    		   }
        				}
        		          if(XorYCoordinate.equalsIgnoreCase("x")) {
        		        	  int x=(list.get(0)+list.get(2))/2;
        		        	  Coordinates=x+"";
        		          }
        		          else if(XorYCoordinate.equalsIgnoreCase("y")) {
        		        	  int y=(list.get(1)+list.get(3))/2;
        		        	  Coordinates=y+"";
        		          }
        		    	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  			   nlpResponseModel.setMessage("Successfully Get User Defined Coordinate From The Bounds Value"+Coordinates);
        			
		} 
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
 			   nlpResponseModel.setMessage("Failed To Get User Defined Coordinate From The Bounds Value"+e);
		} 

          nlpResponseModel.getAttributes().put("Coordinates", Coordinates);
          return nlpResponseModel;
      }
      
  } 
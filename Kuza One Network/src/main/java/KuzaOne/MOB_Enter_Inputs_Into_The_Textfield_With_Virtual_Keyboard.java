package KuzaOne;




import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.springframework.stereotype.Component;

@Component("LIC14333_PJT1002_PE_NLP6f978fe0-e797-46f1-87f6-229eecc46376")
public class MOB_Enter_Inputs_Into_The_Textfield_With_Virtual_Keyboard implements Nlp {
    @InputParams({@InputParam(name = "Input", type = "java.lang.String")})
   
    
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
      	  String Input = (String) attributes.get("Input");
      	  AndroidDriver driver = (AndroidDriver)  nlpRequestModel.getAndroidDriver();
      	  
     
				
   	       	  char ch[]=Input.toCharArray();

      	
      	  for(int i=0;i<ch.length;i++) {
      		  Thread.sleep(1000);
      	  switch (ch[i]) {
			case '1':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
				break;
			case '2':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
				break;
			case '3':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
				break;
			case '4':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
				break;
			case '5':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
				break;
			case '6':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
				break;
			case '7':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_7));
				break;
			case '8':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_8));
				break;
			case '9':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_9));
				break;
			case '0':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
				break;
			case 'A':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
				break;
			case 'B':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.B));
				break;
			case 'C':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.C));
				break;
			case 'D':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.D));
				break;
			case 'E':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.E));
				break;
			case 'F':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.F));
				break;
			case 'G':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.G));
				break;
			case 'H':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.H));
				break;
			case 'I':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
				break;
			case 'J':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.J));
				break;
			case 'K':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.K));
				break;
			case 'L':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.L));
				break;
			case 'M':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.M));
				break;
			case 'N':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.N));
				break;
			case 'O':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.O));
				break;
			case 'P':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.P));
				break;
			case 'Q':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.Q));
				break;
			case 'R':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.R));
				break;
			case 'S':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.S));
				break;
			case 'T':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
				break;
			case 'U':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.U));
				break;
			case 'V':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.V));
				break;
			case 'W':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.W));
				break;
			case 'X':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.X));
				break;
			case 'Y':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.Y));
				break;
			case 'Z':
	        	  driver.pressKey(new KeyEvent().withKey(AndroidKey.Z));
				break;
			case',':
				driver.pressKey(new KeyEvent().withKey(AndroidKey.COMMA));
				break;
      	    case' ':
			driver.pressKey(new KeyEvent().withKey(AndroidKey.SPACE));
			break;
		}
        }
   		   nlpResponseModel.setStatus(CommonConstants.pass);
         	   nlpResponseModel.setMessage("Clicked on Dial Keypad ");
        }
        catch(Exception e)
        {
    		   nlpResponseModel.setStatus(CommonConstants.fail);
     	   nlpResponseModel.setMessage("Failed to click on Dial Keypad"+e);    	  
        }
		return nlpResponseModel;
    }
} 
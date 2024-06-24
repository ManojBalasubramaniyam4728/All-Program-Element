package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;


import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1004_PE_NLPfc73bd1e-ce68-4930-9a0d-ec82d21148e0")
public class MOB_Switching_Native_To_Web_Context implements Nlp {
	@InputParams({ @InputParam(name = "contextHandleName", type = "java.lang.String")})
    //@ReturnType(name = "string3", type = "java.lang.String")

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
          String contextHandleName = (String) attributes.get("contextHandleName");
          //String string2 = (String) attributes.get("string2");

          // Your program element business logic goes here ...
          AndroidDriver driver=nlpRequestModel.getAndroidDriver();
          
try {
	Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
	for (String contextHandle : contextHandles) {
		if (contextHandle.contains(contextHandleName)) {
			((SupportsContextSwitching) driver).context(contextHandle);
			break;
		}
	}
	nlpResponseModel.setStatus(CommonConstants.pass);
	nlpResponseModel.setMessage("Switched to Web View");
} catch (Exception e) {
	nlpResponseModel.setStatus(CommonConstants.fail);
	nlpResponseModel.setMessage("Not Switched to Web View"+e);
}
          //String string3 = "Return Value";
          //nlpResponseModel.getAttributes().put("string3", string3);
          return nlpResponseModel;
      }
  } 
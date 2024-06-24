package business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPda563601-95aa-4caa-9a48-39374512fe17")
public class CommandRunnerInCmdPrompt implements Nlp {
	@InputParams({ @InputParam(name = "Command", type = "java.lang.String") })

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
		String command = (String) attributes.get("Command");

        try {
            // Execute the command and get the process
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            	System.out.println(line);
            }
            if (exitCode==0) {
            	nlpResponseModel.setMessage(line);
    			nlpResponseModel.setStatus(CommonConstants.pass);
			}
            else {
            	nlpResponseModel.setMessage("Error to run this code");
    			nlpResponseModel.setStatus(CommonConstants.fail);
			}
        } catch (Exception e) {
        	nlpResponseModel.setMessage(e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
        }
		
		return nlpResponseModel;
	}
}

package Business_Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1001_PE_NLP1014599c-b9d1-44bb-a79f-546e43a52dd9")
public class Connect_The_VPN_If_It_Is_In_Disconnected_State implements Nlp {
	@InputParams({ @InputParam(name = "ipToManageInput", type = "java.lang.String"),
			@InputParam(name = "sophosSccliexcFilePath", type = "java.lang.String") })

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
		String ipToManageInput = (String) attributes.get("ipToManageInput");
		String sophosSccliexcFilePath = (String) attributes.get("sophosSccliexcFilePath");

		try {
			// Replace '14.192.2.179' with the actual IP address you want to manage
			String ipToManage = ipToManageInput;

			// Build the command to check the network connection status
			String[] checkCommand = {sophosSccliexcFilePath , "status", "-n", ipToManage };

			try {
				ProcessBuilder checkProcessBuilder = new ProcessBuilder(checkCommand);
				Process checkProcess = checkProcessBuilder.start();

				// Read the output of the check command
				BufferedReader checkReader = new BufferedReader(new InputStreamReader(checkProcess.getInputStream()));
				String checkOutput = checkReader.readLine();
				checkProcess.waitFor();
				System.out.println(checkOutput);

				if (checkOutput != null && checkOutput.contains("enabled")) {
					// Add code here to handle the case when the connection is already enabled.
				}
				else {
					// Build the command to enable the network connection
					String[] enableCommand = { sophosSccliexcFilePath, "enable", "-n",
							ipToManage };

					ProcessBuilder enableProcessBuilder = new ProcessBuilder(enableCommand);
					Process enableProcess = enableProcessBuilder.start();

					Boolean enableExitCode = enableProcess.waitFor(20, TimeUnit.SECONDS);

					if (enableExitCode == true) {
						nlpResponseModel.setStatus(CommonConstants.pass);
						nlpResponseModel.setMessage("Network connection enabled successfully");
					} else {
						nlpResponseModel.setStatus(CommonConstants.fail);
						nlpResponseModel.setMessage("Failed to enable network connection. Exit code: " + enableExitCode);
					}
				}
			} 
			catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("The network connection attempt Failed"+e);
		}
		return nlpResponseModel;
	}
}
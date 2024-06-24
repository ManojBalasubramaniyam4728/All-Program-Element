
package clipboard;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import java.util.Map;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLPb7b1ee85-c3b5-4f09-aea7-048010b154ce")
public class CopiedToString implements Nlp {

	@ReturnType(name = "Copiedvalue", type = "java.lang.String")

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
          String Copiedvalue=null;
		try {
			System.setProperty("java.awt.headless", "false");
		    Copiedvalue=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully copied");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to copy");

		}
		// String string3 = "Return Value";
		 nlpResponseModel.getAttributes().put("CopiedValue", Copiedvalue);
		return nlpResponseModel;
	}
}
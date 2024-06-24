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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP3411b46b-dad2-4b59-a7c9-86b0829e0dca")
public class Get_The_Status_Code_Of_Link implements Nlp {
	@InputParams({ @InputParam(name = "Link", type = "java.lang.String") })
	@ReturnType(name = "StatusCode", type = "java.lang.String")

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

		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		Integer code = null;
		String Link = (String) attributes.get("Link");
		try {

			URL url = new URL(Link);
			HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
			// httpurlconnection.setConnectTimeout(5000);
			// httpurlconnection.setRequestMethod("POST");
			httpurlconnection.connect();
			code = httpurlconnection.getResponseCode();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Status of link " + code);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to check Status of links");
		}
		nlpResponseModel.getAttributes().put("StatusCode", code);
		return nlpResponseModel;
	}
}

package Business_Logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1001_PE_NLPe9ab84dc-69b4-4c6e-981c-5f7244c9192b")
public class Obtain_Tat_Date implements Nlp {
	@InputParams({ @InputParam(name = "DaysInCount", type = "java.lang.String"),
			       @InputParam(name = "DataFormat", type = "java.lang.String") })
	@ReturnType(name = "FinalDate", type = "java.lang.String")

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
	
	public static String getDateInURCSTATFormate(String daysInCount,String DataFormat) {
		int tatDate = Integer.parseInt(daysInCount);

		Calendar cal  = Calendar.getInstance();
		//subtracting a day
		cal.add(Calendar.DATE, -tatDate);

		SimpleDateFormat s = new SimpleDateFormat(DataFormat);
		String result = s.format(new Date(cal.getTimeInMillis()));
		
		return result;
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String daysInCount = (String) attributes.get("DaysInCount");
		String DataFormat = (String) attributes.get("DataFormat");
		String result = "";

		try {
			result=getDateInURCSTATFormate(daysInCount, DataFormat);
			 nlpResponseModel.setStatus(CommonConstants.pass);
			 nlpResponseModel.setMessage("Successfully Obtained Tat Date"+" "+result);
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Get Tat Date"+e);
		}
		
		
		nlpResponseModel.getAttributes().put("FinalDate", result);
		return nlpResponseModel;
	}
}
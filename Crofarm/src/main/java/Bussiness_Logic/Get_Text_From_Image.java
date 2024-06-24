package Bussiness_Logic;



import java.io.File;
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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

import org.springframework.stereotype.Component;


@Component("LIC15856_PJT1001_PE_NLP302f42be-2e9d-4d69-8e66-ffbb65903fa4")
public class Get_Text_From_Image implements Nlp {
	@InputParams({ @InputParam(name = "PNGImagePath", type = "java.lang.String") })
	@ReturnType(name = "TextFromImage", type = "java.lang.String")

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
		String PNGImagePath = (String) attributes.get("PNGImagePath");
		String TextFromImage = "";

		try {
			Tesseract tesseract = new Tesseract();

			// Set the Tesseract data path
			File tessDataFolder = LoadLibs.extractTessResources("tessdata");
			tesseract.setDatapath(tessDataFolder.getAbsolutePath());

			// Perform OCR on an image
			TextFromImage = tesseract.doOCR(new File(PNGImagePath));
			 nlpResponseModel.setStatus(CommonConstants.pass);
       	     nlpResponseModel.setMessage("Successfull Obtained Text From Image");
		} 
		catch (Exception e) {
		  nlpResponseModel.setStatus(CommonConstants.fail);
       	  nlpResponseModel.setMessage("Failed Obtained Text From Image"+e);
	

		}

		nlpResponseModel.getAttributes().put("TextFromImage", TextFromImage);
		return nlpResponseModel;
	}
}
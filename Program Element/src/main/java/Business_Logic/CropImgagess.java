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

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP5629f806-8037-48dd-9e89-01adf8163652")
public class CropImgagess implements Nlp {
	@InputParams({ @InputParam(name = "x", type = "java.lang.Integer"),
			@InputParam(name = "y", type = "java.lang.Integer"),
			@InputParam(name = "width", type = "java.lang.Integer"),
			@InputParam(name = "height", type = "java.lang.Integer"),
			@InputParam(name = "ImgfilePath", type = "java.lang.String"),
			@InputParam(name = "CropImgfilePath", type = "java.lang.String") })
	@ReturnType(name = "string3", type = "java.lang.String")

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
		Integer x = (Integer) attributes.get("x");
		Integer y = (Integer) attributes.get("y");
		Integer width = (Integer) attributes.get("width");
		Integer height = (Integer) attributes.get("height");
		String ImgfilePath = (String) attributes.get("ImgfilePath");
		String CropImgfilePath = (String) attributes.get("CropImgfilePath");

		try {
			File file2 = new File(ImgfilePath);
			BufferedImage image = ImageIO.read(file2);
			// Crop the image
			BufferedImage croppedImage = image.getSubimage(x, y, width, height);
			// Save the cropped image to a file
			File outputfile = new File(CropImgfilePath);
			ImageIO.write(croppedImage, "png", outputfile);
			Thread.sleep(2000);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Image Croped");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to crop Imag" + e);
		}

//		String string3 = "Return Value";
//		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}

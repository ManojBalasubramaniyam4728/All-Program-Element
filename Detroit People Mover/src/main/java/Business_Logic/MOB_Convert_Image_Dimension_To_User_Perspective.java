
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO; 
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;


import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1004_PE_NLP0a10d4d3-93b9-42ac-ab5a-fa7384e15b82")
public class MOB_Convert_Image_Dimension_To_User_Perspective implements Nlp {
    @InputParams({@InputParam(name = "FilePathOfImageToModify", type = "java.lang.String"),
    	         @InputParam(name = "WidthWantToChange", type = "java.lang.Integer"),
    	         @InputParam(name = "HeightWantToChange", type = "java.lang.Integer"),
    	         @InputParam(name = "FilePathOfModifyedImageToSave", type = "java.lang.String"),
    	         @InputParam(name = "ImageFormatType", type = "java.lang.String")})
    @ReturnType(name = "isConverted", type = "java.lang.String")

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
          String FilePathOfImageToModify = (String) attributes.get("FilePathOfImageToModify");
          Integer WidthWantToChange = (Integer) attributes.get("WidthWantToChange");
          Integer HeightWantToChange = (Integer) attributes.get("HeightWantToChange");
          String FilePathOfModifyedImageToSave = (String) attributes.get("FilePathOfModifyedImageToSave");
          String ImageFormatType = (String) attributes.get("ImageFormatType");
          Boolean isConverted=false;

          try {
              // Load the image
              BufferedImage originalImage = ImageIO.read(new File(FilePathOfImageToModify));


              // Define the new dimensions Set your desired width and hight
              int newWidth = WidthWantToChange; 
              int newHeight = HeightWantToChange; 

              // Create a new BufferedImage with the desired dimensions
              BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

              // Create a graphics object to draw the scaled image
              Graphics2D g = resizedImage.createGraphics();
              g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
              g.dispose();

              // Save the resized image to a file
              String ImageFormatTypeToLowerCase=ImageFormatType.toLowerCase();
              ImageIO.write(resizedImage,ImageFormatTypeToLowerCase, new File(FilePathOfModifyedImageToSave));
              isConverted=true;
              nlpResponseModel.setStatus(CommonConstants.pass);
  			  nlpResponseModel.setMessage("Sucessfully Convert Image Dimension To"+" "+newWidth+" "+"X"+" "+newHeight);
          }
          catch (IOException e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Failed Convert Image Dimension"+e);
          }
          
          nlpResponseModel.getAttributes().put("isConverted", isConverted);
          return nlpResponseModel;
      }
  } 
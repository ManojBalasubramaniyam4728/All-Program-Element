
package businessLogics;

import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLP4e3f01ff-b46a-4883-9a54-b342ad0eb5d4")
public class Geting_Values_From_The_UI_And_Storing_In_List implements Nlp {
    @InputParams({@InputParam(name = "updatekeyValue", type = "java.util.Map")})
    @ReturnType(name = "lowercaseValuesTextList", type = "java.util.ArrayList")

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
          
          Map<String, String> updatekeyValue = (Map<String, String>) attributes.get("updatekeyValue");
          
          List<String> lowercaseValuesTextList = new ArrayList<String>();
          List<String> textList = new ArrayList<String>();
          
          try {
        	  WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();

      		if (updatekeyValue.containsKey("Ticket No")) {
    			Thread.sleep(500);
    			String TicketNo = driver.findElement(By.xpath("//span[@class='ticket-icon']/..//span[@class and(text())]")).getText();
    			textList.add(TicketNo.trim());
    		}
    		if (updatekeyValue.containsKey("Subject")) {
    			Thread.sleep(500);
    			String Subject = driver.findElement(By.xpath("//label/..//input[@name='subject']")).getAttribute("value");
    			textList.add(Subject.trim());
    		}
    		if (updatekeyValue.containsKey("Source")) {
    			Thread.sleep(500);
    			String Source = driver.findElement(By.xpath("//label[text()='Source']/..//div[text()]")).getText();
    			textList.add(Source.trim());
    		}
    		if (updatekeyValue.containsKey("Status")) {
    			Thread.sleep(500);
    			String Status = driver.findElement(By.xpath("//label[text()='Status']/..//div/p")).getText();
    			textList.add(Status.trim());
    		}
    		if (updatekeyValue.containsKey("Priority")) {
    			Thread.sleep(500);
    			String Priority = driver.findElement(By.xpath("//label[text()='Priority']/..//div[text()]")).getText();
    			textList.add(Priority.trim());
    		}
    		if (updatekeyValue.containsKey("Description")) {
    			Thread.sleep(500);
    			String Description = driver.findElement(By.xpath("//label[text()='Description']/..//span//span")).getText();
    			textList.add(Description.trim());
    		}
    		if (updatekeyValue.containsKey("Attachments")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[@for='Attachments']/../following::a/../i/a/span")).isDisplayed()){
    				String	Attachments	=driver.findElement(By.xpath("//label[@for='Attachments']/../following::a/../i/a/span")).getText();
    				textList.add(Attachments.trim());
    				}
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    	
    		if (updatekeyValue.containsKey("Queue")) {
    			Thread.sleep(500);
    			String Queue = driver.findElement(By.xpath("//label[text()='Queue']/..//div[text()]")).getText();
    			textList.add(Queue.trim());
    		}
    		if (updatekeyValue.containsKey("Domain")) {
    			Thread.sleep(500);
    			String Domain = driver.findElement(By.xpath("//label[text()='Domain']/..//div[text()]")).getText();
    			textList.add(Domain.trim());
    		}
    		if (updatekeyValue.containsKey("Category")) {
    			Thread.sleep(500);
    			String Category = driver.findElement(By.xpath("//label[text()='Category']/..//div[text()]")).getText();
    			textList.add(Category.trim());
    		}
    		if (updatekeyValue.containsKey("Sub Category")) {
    			Thread.sleep(500);
    			String SubCategory = driver.findElement(By.xpath("//label[text()='Subcategory']/..//div[text()]")).getText();
    			textList.add(SubCategory.trim());
    		}
    		if (updatekeyValue.containsKey("Submitted By (Name)")) {
    			Thread.sleep(500);
    			String SubmittedBy = driver.findElement(By.xpath("//label[text()='Submitted By']/..//p[text()]")).getText();
    			String SubmittedByName = SubmittedBy.replaceAll("\\(.*?\\)", "");
    			textList.add(SubmittedByName.trim());
    		}
    		if (updatekeyValue.containsKey("Submitted By (username)")) {
    			Thread.sleep(500);
    			String SubmittedBy = driver.findElement(By.xpath("//label[text()='Submitted By']/..//p[text()]")).getText();
    	        // Extract the value inside brackets
    	        int startIndex = SubmittedBy.indexOf('(');
    	        int endIndex = SubmittedBy.indexOf(')');
    	        String SubmittedByUsername = SubmittedBy.substring(startIndex + 1, endIndex);
    			textList.add(SubmittedByUsername.trim());
    		}
    		if (updatekeyValue.containsKey("Reported for (Name)")) {
    			Thread.sleep(500);
    			Thread.sleep(500);
    			String SubmittedBy = driver.findElement(By.xpath("//label[text()='Submitted By']/..//p[text()]")).getText();
    			String ReportedforName = SubmittedBy.replaceAll("\\(.*?\\)", "");
    			textList.add(ReportedforName.trim());
    		}
    		if (updatekeyValue.containsKey("Reported for (username)")) {
    			Thread.sleep(500);
    			String SubmittedBy = driver.findElement(By.xpath("//label[text()='Submitted By']/..//p[text()]")).getText();
    	        // Extract the value inside brackets
    	        int startIndex = SubmittedBy.indexOf('(');
    	        int endIndex = SubmittedBy.indexOf(')');
    	        String ReportedforUsername = SubmittedBy.substring(startIndex + 1, endIndex);
    			textList.add(ReportedforUsername.trim());
    		}
    		if (updatekeyValue.containsKey("Assignee (Name)")) {
    			Thread.sleep(500);
    			try {
    			if(driver.findElement(By.xpath("//label[text()='Assigned To']/..//div[text()]")).isDisplayed()) {
    			String Assigneename = driver.findElement(By.xpath("//label[text()='Assigned To']/..//div[text()]")).getText();
    	        String[] parts = Assigneename.split("@");
    	        String AssigneeNames = parts[0];
    	        String AssigneeName = AssigneeNames.replace(".", " ");
    			textList.add(AssigneeName.trim());
    		         }
    			}
    			catch (Exception e) {
    				textList.add("");
    			}
    		}
    		if (updatekeyValue.containsKey("Assignee (username)")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Assigned To']/..//div[text()]")).isDisplayed()) {
    					String AssigneeUsername = driver.findElement(By.xpath("//label[text()='Assigned To']/..//div[text()]")).getText();
    					textList.add(AssigneeUsername.trim());
    			} 
    			}
    			catch (Exception e) {
    					textList.add("NA");
    			
    		}
    		}
    		if (updatekeyValue.containsKey("Watchers (username)")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//button[@class='watchers-eye btn btn-secondary']/..//span[text()]")).isDisplayed()) {
    					String WatchersUsername = driver.findElement(By.xpath("//button[@class='watchers-eye btn btn-secondary']/..//span[text()]")).getText();
    					textList.add(WatchersUsername.trim());
    				}
    			}
    			catch (Exception e) {
    				textList.add("NA");
    			}
    			
    		}
    		if (updatekeyValue.containsKey("Is Closed")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//button[text()='Reopen']")).isDisplayed()){
    					textList.add("Yes");
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("No");
    				}
    			}
    		if (updatekeyValue.containsKey("Created At (MM-DD-YY)")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Submitted On']/../div//p")).isDisplayed()){
    					String timeStr =driver.findElement(By.xpath("//label[text()='Submitted On']/../div//p")).getText();
    				        // Step 1: Parse the given time string
    				        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a", Locale.ENGLISH);
    				        LocalDateTime dateTime = LocalDateTime.parse(timeStr, inputFormatter);
    				        // Step 2: Convert to the desired format
    				        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'");
    				        String CreatedAt = dateTime.format(outputFormatter);
    					    textList.add(CreatedAt);
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    		if (updatekeyValue.containsKey("Last Updated At (MM-DD-YY)")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Last Updated']/../div//p")).isDisplayed()){
    					String timeStr =driver.findElement(By.xpath("//label[text()='Last Updated']/../div//p")).getText();
    				        // Step 1: Parse the given time string
    				        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a", Locale.ENGLISH);
    				        LocalDateTime dateTime = LocalDateTime.parse(timeStr, inputFormatter);
    				        // Step 2: Convert to the desired format
    				        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'");
    				        String LastUpdated = dateTime.format(outputFormatter);
    					    textList.add(LastUpdated);
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    		if (updatekeyValue.containsKey("Resolved At (MM-DD-YY)")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Submitted On']/../div//p")).isDisplayed()){
    					String timeStr =driver.findElement(By.xpath("//label[text()='Submitted On']/../div//p")).getText();
    				        // Step 1: Parse the given time string
    				        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a", Locale.ENGLISH);
    				        LocalDateTime dateTime = LocalDateTime.parse(timeStr, inputFormatter);
    				        // Step 2: Convert to the desired format
    				        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'");
    				        String ResolvedAt = dateTime.format(outputFormatter);
    					    textList.add(ResolvedAt);
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    		if (updatekeyValue.containsKey("Closed At (MM-DD-YY)")) {

    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Last Updated']/../div//p")).isDisplayed()){
    					String timeStr =driver.findElement(By.xpath("//label[text()='Last Updated']/../div//p")).getText();
    				        // Step 1: Parse the given time string
    				        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a", Locale.ENGLISH);
    				        LocalDateTime dateTime = LocalDateTime.parse(timeStr, inputFormatter);
    				        // Step 2: Convert to the desired format
    				        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'");
    				        String ClosedAt = dateTime.format(outputFormatter);
    					    textList.add(ClosedAt);
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    		if (updatekeyValue.containsKey("Resolution Notes")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//strong[@class='h4span']/parent::p[text()]")).isDisplayed()){
    				List<WebElement> Elements=	driver.findElements(By.xpath("//strong[@class='h4span']/parent::p[text()]"));
    				for (WebElement Element : Elements) {
    					String d= Element.getText();
    					int s=d.indexOf("\"");
    					String S1=d.substring(s+1);
    					int b1=S1.indexOf("\"");
    					String res=S1.substring(0, b1);
    					if(res.equalsIgnoreCase("Resolution Note")) {
    						textList.add("Resolution Note");
    					       }
    				        }
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("N/A");
    				}
    			}
    		if (updatekeyValue.containsKey("Chase Note")) {
    			Thread.sleep(500);
    			try {
    				if(driver.findElement(By.xpath("//label[text()='Chase']")).isDisplayed()){
    					  JavascriptExecutor scroll=(JavascriptExecutor)driver;
    			    	   scroll.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//label[text()='Chase']")) );
    			    	   Thread.sleep(500);
    					driver.findElement(By.xpath("//label[text()='Chase']")).click();
    				List<WebElement> Elements=	driver.findElements(By.xpath("//strong[@class='h4span']/parent::p[text()]"));
    				for (WebElement Element : Elements) {
    					String d= Element.getText();
    					int s=d.indexOf("\"");
    					String S1=d.substring(s+1);
    					int b1=S1.indexOf("\"");
    					String res=S1.substring(0, b1);
    					if(res.equalsIgnoreCase("Chase Note")) {
    						textList.add("Chase Note");
    					       }
    				        }
    				    }
    			     }
    				catch (Exception e) {
    					textList.add("");
    				}
    			}
    		
    		JavascriptExecutor scroll=(JavascriptExecutor)driver;
       	   scroll.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//button[text()='Back to Ticket List']")));
       	   Thread.sleep(500);
       	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
       	jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Back to Ticket List']")));
         Thread.sleep(5000);
        
       	  if (updatekeyValue.containsKey("SLA")) {
    		Thread.sleep(500);
    		try {
    			if(driver.findElement(By.xpath("//th[4]//span[text()='Met']")).isDisplayed()){
    					textList.add("Met");
    			         }
    		     }
    			catch (Exception e) {
    				textList.add("Not Met");
    			}
    		}
        		 for (String v : textList) {
        			lowercaseValuesTextList.add(v.toLowerCase());
        	        }
        		 nlpResponseModel.setStatus(CommonConstants.pass);
           	    nlpResponseModel.setMessage("Successfully Geted Value Form the UI");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("Failed To Get Value Form the UI"+e);
		    }

  
          nlpResponseModel.getAttributes().put("lowercaseValuesTextList", lowercaseValuesTextList);
          return nlpResponseModel;
      }
  } 
package LoginPage;


import java.io.IOException;

import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Open_mrsB.Base;

public class Login1 extends Base{
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
    WebElement password;
	
    @FindBy(xpath="//input[@id='loginButton']")
    WebElement submitbtn;
    
    @FindBy(xpath="//li[@id='Inpatient Ward']")
    WebElement Session_Location; 
   
    
     public Login1() throws IOException {
     super();
     PageFactory.initElements(driver,this);
   }
     

	 public void invalid(String st1, String str1) throws Exception {
		 driver.switchTo().activeElement().sendKeys(st1); 
	    
	     password.sendKeys(str1);
	    submitbtn.click();


	// TODO Auto-generated method stub
	
}
     public void signin(String st, String str) throws Exception {
    	 driver.navigate().refresh();
    	 Thread.sleep(2000);
     driver.switchTo().activeElement().sendKeys(st);
     
     password.sendKeys(str);
     Session_Location.click(); 
     submitbtn.click();
     
    
     }
     
}

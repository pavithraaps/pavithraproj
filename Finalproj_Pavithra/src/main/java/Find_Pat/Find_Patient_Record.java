package Find_Pat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Find_Patient_Record {

	 
    @FindBy(xpath="//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]")
   public static  WebElement find_patient;
    
    @FindBy(xpath="//input[@id='patient-search']")
  public static   WebElement searchbox;
}

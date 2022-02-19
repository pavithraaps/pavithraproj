package Testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Find_Pat.Find_Patient_Record;
import HomePage.Capture_Vitals;
import LoginPage.Login1;
import Open_mrsB.Base;

public class TestCase_Mrs extends Base {
public Login1 lp;

public TestCase_Mrs() throws IOException {
super(); 
// TODO Auto-generated constructor stub
lp=new Login1();
}

@BeforeSuite
public void Launching_Browser()
{
initialisation();
}
@BeforeMethod
public void BeforeTest() throws IOException {
lp=new Login1();

PageFactory.initElements(driver,Capture_Vitals.class);
PageFactory.initElements(driver,Find_Patient_Record.class);
}
@Test
public void log_in() throws Exception {
	lp.invalid("Admin", "Admin123");
	
}
@Test(dependsOnMethods = "log_in")
public void Sign_in() throws Exception {
lp.signin("Admin","Admin123");


}

@Test(dependsOnMethods = "Sign_in")
public void Find_patient() throws InterruptedException {
	Find_Patient_Record.find_patient.click();
	Find_Patient_Record.searchbox.sendKeys("Rober Taylor");
	Thread.sleep(2000);
}


@Test(dependsOnMethods = "Find_patient")
public void CaptureVitals()
{ 
	
	driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
    Capture_Vitals.CaptureTab.click();
    Capture_Vitals.SearchTab.sendKeys("1002KL"+Keys.ENTER);
    String Name=Capture_Vitals.patienttab.getText();
    System.out.println(Name);
    String Expected="Patient ID 1002KL";
    Assert.assertEquals(Name, Expected);

}
}


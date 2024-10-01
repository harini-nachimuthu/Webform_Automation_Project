package Web_automation_form_details_filling;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Formfilling {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	 
	
  @BeforeSuite
  public void beforesuites() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      js = (JavascriptExecutor) driver; 
  }
  
  @BeforeClass
  public void beforeclasse() {
	  driver.get("https://only-testing-blog.blogspot.com/?fname=aravind&lname=v");
  }
  
  @AfterSuite
  public void aftrsuite() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }
  
  @Test(priority=1)
  public void form1() throws InterruptedException {
	  WebElement formtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Relationship')]")));
	
	  String title=formtitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", formtitle);
	  js.executeScript("arguments[0].click()", formtitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement grandparent1=driver.findElement(By.cssSelector("input[id=gparent_1]"));
	  grandparent1.sendKeys("Granny1");
	  WebElement parent1=driver.findElement(By.cssSelector("input[id=parent_1]"));
	  parent1.sendKeys("Parent1");
	  WebElement child1=driver.findElement(By.cssSelector("input[id=child_1]"));
	  child1.sendKeys("Child1");
	  
	  WebElement grandparent2=driver.findElement(By.cssSelector("input[id=gparent_2]"));
	  grandparent2.sendKeys("Granny2");
	  WebElement parent2=driver.findElement(By.cssSelector("input[id=parent_2]"));
	  parent2.sendKeys("Parent2");
	  WebElement child2=driver.findElement(By.cssSelector("input[id=child_2]"));
	  child2.sendKeys("Child2");
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=2)
  public void form2() throws InterruptedException {
	  WebElement tooltipexample=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Tooltip']")));
	  
	  String title=tooltipexample.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", tooltipexample);
	  js.executeScript("arguments[0].click()", tooltipexample);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement name=driver.findElement(By.xpath("//input[@id='tooltip-1']"));
	  name.sendKeys("Aravind");
	  
	  WebElement surname=driver.findElement(By.xpath("//input[@id='sname']"));
	  surname.sendKeys("Rajasekaran");
	  
	  WebElement address=driver.findElement(By.xpath("//input[@id='yaddress']"));
	  address.sendKeys("No-1 Anna nagar street");
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=3)
  public void form3() throws InterruptedException {
	  WebElement frame=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='iframe1']")));
	  
	  String title=frame.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", frame);
	  js.executeScript("arguments[0].click()", frame);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  driver.switchTo().frame(0);
	  Thread.sleep(200);
	  
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(1);
	  Thread.sleep(200);
	  
	  driver.switchTo().defaultContent();
	  WebElement town=driver.findElement(By.xpath("//input[@id='text1']"));
	  town.sendKeys("City1");
	  
	  WebElement country=driver.findElement(By.xpath("//input[@id='text2']"));
	  country.sendKeys("Country1");
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=4)
  public void form4() throws InterruptedException {
	  WebElement check=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Table With Checkbox']")));
	  
	  String title=check.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", check);
	  js.executeScript("arguments[0].click()", check);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  List<WebElement> list_checkboxes =driver.findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
	  int size=list_checkboxes.size();
	  
	  for(WebElement list_checkbox:list_checkboxes) {
		  if(!list_checkbox.isSelected()) {
			  list_checkbox.click();
		  }else {
			  list_checkbox.click();
		  }
	  }
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=5)
  public void form5() throws InterruptedException {
	  WebElement selectable=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Selectable']")));
	  
	  String title=selectable.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", selectable);
	  js.executeScript("arguments[0].click()", selectable);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement itemclick=driver.findElement(By.xpath("//ol[@id='selectable']//li[4]"));
	  itemclick.click();
	  
	  WebElement date=driver.findElement(By.xpath("//input[@id='datepicker']"));
	  date.click();
	  WebElement clicknext=driver.findElement(By.xpath("//span[.='Next']"));
	  clicknext.click();
	  WebElement clickdate=driver.findElement(By.xpath("//tbody//tr//td//a[.='3']"));
	  clickdate.click();
	  
	  Thread.sleep(500);
	  
	  WebElement doubleclick=driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
	  Actions action=new Actions(driver);
	  action.doubleClick(doubleclick);
	  action.build().perform();
	  
	  wait = new WebDriverWait(driver, Duration.ofSeconds(35));
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  Alert al=driver.switchTo().alert();
	  al.accept();
	  
	  WebElement scroll=driver.findElement(By.xpath("//div[@class='scroll']"));
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	  Thread.sleep(500);
	  
	  WebElement imageclick=driver.findElement(By.xpath("//div[@class='separator']//a"));
	  imageclick.click();
	  WebElement close=driver.findElement(By.xpath("//div[@class='CSS_LIGHTBOX_BTN_CLOSE CSS_LIGHTBOX_BTN_CLOSE_POS']"));
	  close.click();
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
	
  }
  
  @Test(priority=6)
  public void form6() throws InterruptedException {
	  WebElement dragtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Drag and Drop']")));
	  
	  String title=dragtitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", dragtitle);
	  js.executeScript("arguments[0].click()", dragtitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement dragging =driver.findElement(By.xpath("//div[@id='dragdiv']"));
	  WebElement dropping=driver.findElement(By.xpath("//div[@id='dropdiv']"));
	  String beforedrop=dropping.getText();
	  System.out.println("Before drop: "+beforedrop);
	  System.out.println("Before colour : "+dropping.getCssValue("background-color"));
	  Actions action=new Actions(driver);
	  action.dragAndDrop(dragging, dropping).build().perform();
	  String afterdrop=dropping.getText();
	  System.out.println("After drop: "+afterdrop);
	  System.out.println("After colour : "+dropping.getCssValue("background-color"));
	  
	  
	  WebElement resizableElement = driver.findElement(By.xpath("//div[@id='resizable']"));
	  action.clickAndHold(resizableElement).moveByOffset(10, 10).release().perform();
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=7)
  public void form7() throws InterruptedException {
	  WebElement Temptitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Temp']")));
	  
	  String title=Temptitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", Temptitle);
	  js.executeScript("arguments[0].click()", Temptitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement fname=driver.findElement(By.xpath("//input[@name='fname']"));
	  fname.sendKeys("Fname1");
	  
	  WebElement lname=driver.findElement(By.xpath("//input[@name='lname']"));
	  lname.sendKeys("Lname1");
	  
	  WebElement sname=driver.findElement(By.xpath("//input[@name='sname']"));
	  sname.sendKeys("Sname1");
	  
	  List<WebElement> boxes=driver.findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
	  int size=boxes.size();
	  
	  for(int i=0;i<size;i++) {
		  if(i%2==1) {
			  boxes.get(i).click();
		  }else {
			  continue;
		  }
	  }
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test
  public void form8() throws InterruptedException {
	  WebElement alerttitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Alert']")));
	  
	  String title=alerttitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", alerttitle);
	  js.executeScript("arguments[0].click()", alerttitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement fname=driver.findElement(By.xpath("//input[@name='fname']"));
	  fname.sendKeys("Fname1");
	  
	  wait = new WebDriverWait(driver, Duration.ofSeconds(35));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert al=driver.switchTo().alert();
	  al.accept();
	  
	  WebElement lname=driver.findElement(By.xpath("//input[@name='lname']"));
	  lname.sendKeys("Lname1");
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  
  @Test(priority=9)
  public void form9() throws InterruptedException {
	  WebElement formtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Form']")));
	  
	  String title=formtitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", formtitle);
	  js.executeScript("arguments[0].click()", formtitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement fname=driver.findElement(By.xpath("//input[@name='FirstName']"));
	  fname.sendKeys("Firstname");
	  
	  WebElement lname=driver.findElement(By.xpath("//input[@name='LastName']"));
	  lname.sendKeys("Lastname");
	  
	  WebElement email=driver.findElement(By.xpath("//input[@name='EmailID']"));
	  email.sendKeys("Firstlast@gmail.com");
	  
	  WebElement mobile=driver.findElement(By.xpath("//input[@name='MobNo']"));
	  mobile.sendKeys("5643982314");
	  
	  WebElement companyno=driver.findElement(By.xpath("//input[@name='Company']"));
	  companyno.sendKeys("251389");
	  
	  WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
	  submit.click();
	  
	  Alert al=driver.switchTo().alert();
	  al.accept();
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  @Test(priority=10)
  public void form10() throws InterruptedException, IOException {
	  WebElement logtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='LogIn']")));
	  
	  String title=logtitle.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", logtitle);
	  js.executeScript("arguments[0].click()", logtitle);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement textfile=driver.findElement(By.xpath("//a[.='Download Text File']"));
	  textfile.click();
	  
	  Thread.sleep(200);
	  
	  String path1 = "\"C:\\AutoIT_file\\filedownloading.exe\"";  
	  ProcessBuilder builder1 = new ProcessBuilder(path1);
	  builder1.start();

	  
	  Thread.sleep(500);
	  
	  WebElement pdffile=driver.findElement(By.xpath("//a[.='Download PDF File']"));
	  pdffile.click();
	  
	  Thread.sleep(200);
	  builder1.start();
	  Thread.sleep(500);
	  
	  WebElement csvfile=driver.findElement(By.xpath("//a[.='Download CSV File']"));
	  csvfile.click();
	  
	  Thread.sleep(200);
	  builder1.start();
	  Thread.sleep(500);
	  
	  WebElement excelfile=driver.findElement(By.xpath("//a[.='Download Excel File']"));
	  excelfile.click();
	  
	  Thread.sleep(200);
	  builder1.start();
	  Thread.sleep(500);
	  
	  WebElement docfile=driver.findElement(By.xpath("//a[.='Download Doc File']"));
	  docfile.click();
	  
	  Thread.sleep(200);
	  builder1.start();
	  Thread.sleep(500);
	  
	  WebElement username=driver.findElement(By.xpath("//input[@name='userid']"));
	  username.sendKeys("username");
	  
	  WebElement password=driver.findElement(By.xpath("//input[@name='pswrd']"));
	  password.sendKeys("username123");
	  
	  WebElement cancel=driver.findElement(By.xpath("//input[@value='Cancel']"));
	  cancel.click();
	  
	  username.sendKeys("username");
	  password.sendKeys("username123");
	  Thread.sleep(500);
	  
	  WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
	  loginbtn.click();
	  Alert al=driver.switchTo().alert();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(35));
	  wait.until(ExpectedConditions.alertIsPresent());
	  System.out.println("alert text is : "+al.getText());
	  al.accept();
	  
	  WebElement fname=driver.findElement(By.xpath("//input[@name='fname']"));
	  fname.sendKeys("fname");
	  
	  WebElement lname=driver.findElement(By.xpath("//input[@name='lname']"));
	  lname.sendKeys("lname");
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
  @Test(priority=11)
  public void form11() throws InterruptedException {
	  WebElement multi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Mul']")));
	  
	  String title=multi.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", multi);
	  js.executeScript("arguments[0].click()", multi);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement selectkey=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey.click();
	  WebElement selectkey1=driver.findElement(By.xpath("//input[@value=\"  7  \"]"));
	  selectkey1.click();
	  WebElement selectkeyx=driver.findElement(By.xpath("//input[@value=\"  x  \"]"));
	  selectkeyx.click();
	  WebElement selectkey2=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey2.click();
	  WebElement equal=driver.findElement(By.xpath("//input[@value=\"  =  \"]"));
	  equal.click();
	  Thread.sleep(1000);
	  String values=driver.findElement(By.xpath("//input[@name='Numbers']")).getAttribute("value");
	  Thread.sleep(1000);

	  System.out.println("value is :"+values);
	  WebElement ac=driver.findElement(By.xpath("//input[@value=\"  AC  \"]"));
	  ac.click();
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();  
  }
  @Test(priority=12)
  public void form12() throws InterruptedException {
	  WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sub']")));
	  
	  String title=sub.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", sub);
	  js.executeScript("arguments[0].click()", sub);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement selectkey=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey.click();
	  WebElement selectkey1=driver.findElement(By.xpath("//input[@value=\"  7  \"]"));
	  selectkey1.click();
	  WebElement selectkeyx=driver.findElement(By.xpath("//input[@value=\"  -  \"]"));
	  selectkeyx.click();
	  WebElement selectkey2=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey2.click();
	  WebElement equal=driver.findElement(By.xpath("//input[@value=\"  =  \"]"));
	  equal.click();
	  Thread.sleep(1000);
	  String values=driver.findElement(By.xpath("//input[@name='Numbers']")).getAttribute("value");
	  Thread.sleep(1000);

	  System.out.println("value is :"+values);
	  WebElement ac=driver.findElement(By.xpath("//input[@value=\"  AC  \"]"));
	  ac.click();
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();  
  }
  @Test(priority=13)
  public void form13() throws InterruptedException {
	  WebElement add=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Add']")));
	  
	  String title=add.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", add);
	  js.executeScript("arguments[0].click()", add);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement selectkey=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey.click();
	  WebElement selectkey1=driver.findElement(By.xpath("//input[@value=\"  7  \"]"));
	  selectkey1.click();
	  WebElement selectkeyx=driver.findElement(By.xpath("//input[@value=\"  +  \"]"));
	  selectkeyx.click();
	  WebElement selectkey2=driver.findElement(By.xpath("//input[@value=\"  6  \"]"));
	  selectkey2.click();
	  WebElement equal=driver.findElement(By.xpath("//input[@value=\"  =  \"]"));
	  equal.click();
	  Thread.sleep(1000);
	  String values=driver.findElement(By.xpath("//input[@name='Numbers']")).getAttribute("value");
	  Thread.sleep(1000);

	  System.out.println("value is :"+values);
	  WebElement ac=driver.findElement(By.xpath("//input[@value=\"  AC  \"]"));
	  ac.click();
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();  
  }
  @Test(priority=14)
  public void form14() throws InterruptedException {
	  WebElement add=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Calc']")));
	  
	  String title=add.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", add);
	  js.executeScript("arguments[0].click()", add);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement selectkey=driver.findElement(By.xpath("//input[@value=\"  2  \"]"));
	  selectkey.click();
	  WebElement selectkey1=driver.findElement(By.xpath("//input[@value=\"  9  \"]"));
	  selectkey1.click();
	  WebElement selectkeyx=driver.findElement(By.xpath("//input[@value=\"  4  \"]"));
	  selectkeyx.click();
	  WebElement selectkey2=driver.findElement(By.xpath("//input[@value=\"  x  \"]"));
	  selectkey2.click();
	  WebElement selectkey3=driver.findElement(By.xpath("//input[@value=\"  4  \"]"));
	  selectkey3.click();
	  WebElement equal=driver.findElement(By.xpath("//input[@value=\"  =  \"]"));
	  equal.click();
	  Thread.sleep(1000);
	  String values=driver.findElement(By.xpath("//input[@name='Numbers']")).getAttribute("value");
	  Thread.sleep(1000);

	  System.out.println("value is :"+values);
	  WebElement ac=driver.findElement(By.xpath("//input[@value=\"  AC  \"]"));
	  ac.click();
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();  
  }
  @Test(priority=15)
  public void form15() throws InterruptedException {
	  WebElement attributes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Attributes']")));
	  
	  String title=attributes.getText();
	  System.out.println("Titleof the form : "+title);
	  
	  js.executeScript("arguments[0].scrollIntoView(true)", attributes);
	  js.executeScript("arguments[0].click()", attributes);
	  
	  System.out.println("Title of the page now : "+driver.getTitle());
	  
	  WebElement fname=driver.findElement(By.xpath("//input[@id='text1']"));
	  fname.sendKeys("Fname");
	  
//	  WebElement lname=driver.findElement(By.xpath("//input[@id='text2']"));
//	  lname.sendKeys("Lname");
	  
	  WebElement hidden=driver.findElement(By.xpath("//input[@id='text2']"));
	  System.out.println("Hidden :"+hidden.isDisplayed());
	  
	  
	  Thread.sleep(500);
	  
	  WebElement homebtn=driver.findElement(By.xpath("//a[.='Home']"));
	  homebtn.click();
  }
}

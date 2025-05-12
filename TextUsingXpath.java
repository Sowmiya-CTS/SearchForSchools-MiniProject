package MiniProject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class TextUsingXpath {
	public static void main(String... args) {
		WebDriver driver=new ChromeDriver();
		
		WebElement element=driver.findElement(By.xpath("//*[contains(@text(),'edu')]")).getAttribute("Sowmiya");
		System.out.println();
		 //val=element.getAttribute();
		if(element.isDisplayed()) {
			System.out.println("No its working!");
		}else {
			
		}
		
		System.out.println(element.getText());
		
	}

}

package selenium.latest.version;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_New {
	
	public static void main(String[] args) {
		
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
//		WebDriver wd = new ChromeDriver(ops);
//		wd.get("https://www.facebook.com/");		
		
		ChromeOptions opti = new ChromeOptions();
		opti.addArguments("--remote-allow-origins=*");
		opti.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(opti);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("//a[text()=' BUSES ']"));
		findElement.click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lis = new LinkedList<String>(windowHandles);
		System.out.println(lis.size());
		driver.switchTo().window(lis.get(1));

		String currentUrl = driver.getCurrentUrl();
		System.out.println("the current url" + currentUrl);

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.the-maharajas.com/");
		
	}

}

package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	
	public TestBase() {		
		property = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\gurup\\eclipse-workspace\\BDDFramework\\main\\com\\config\\config.properties");
			property.load(fis);
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public WebDriver init() {	
		
		String browserName = property.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "G:\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(property.getProperty("implicitlyWaitTimeSec")), TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
		return driver;
	}

}

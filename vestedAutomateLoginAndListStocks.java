package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.chrome.ChromeDriver;

public class vestedAutomateLoginAndListStocks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeWebdriver\\chromedriver_win32 (2)\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
    	ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://app.vested.co.in/login");
				
		WebElement login = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[1]"));
		login.click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/form/div[1]/div/div[1]/input")).sendKeys("dipali.d.raut@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/form/div[2]/div/div[1]/span/input")).sendKeys("Vaidya@123");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/form/div[4]/button")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[2]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"react-joyride-step-1\"]/div/div/div[1]/div[2]/div/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[5]/div/div[2]/div/div[1]/div/div[1]/p[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[2]")).click();
		
		
		int rows =driver.findElements(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr")).size();
		System.out.println("Number of stocks:" +rows);
		
		List<String> listOfStocks=new ArrayList<String>();
		List<String> listOfSymbols=new ArrayList<String>();
		List<Double> listOfPrice=new ArrayList<Double>();
		List<Double> listOfDailyChange=new ArrayList<Double>();
		List<Double> listOfMarketCap=new ArrayList<Double>();
		List<Double> listOfPERatio=new ArrayList<Double>();

		for (int r=1;r<=rows; r++)
		{
		    listOfStocks.add(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[2]")).getText());
		}
		isListSorted(listOfStocks);


		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[3]")).click();
		for (int r=1;r<=rows; r++)
		{
		    listOfSymbols.add(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[3]")).getText());
		}
		isListSorted(listOfSymbols);
		
    	driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[4]")).click();
		for (int r=1;r<=rows; r++)
		{
		    listOfPrice.add(Double.valueOf(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[4]")).getText().replace("$", "")));
		}
		isListSortedDouble(listOfPrice);		
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[5]")).click();
		for (int r=1;r<=rows; r++)
		{
		    listOfDailyChange.add(Double.valueOf(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[5]")).getText().replace("+", "").replace("%", "")));
		}
		isListSortedDouble(listOfDailyChange);	
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[6]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[6]")).click();
		for (int r=1;r<=rows; r++)
		{
			String marketCap = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[6]")).getText();
			if(marketCap.length() > 1) { 
				double multiply = 1;
				if(marketCap.contains("B")) {
					multiply = 1000;
				}
				marketCap = marketCap.replace(marketCap.substring(marketCap.length()-1), "");
				double realValue = multiply * Double.valueOf(marketCap);
				listOfMarketCap.add(realValue);
			}
		}
		isListSortedDouble(listOfMarketCap);		
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[7]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/thead/tr/th[7]")).click();
		for (int r=1;r<=rows; r++)
		{
			String peratio = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr["+r+"]/td[7]")).getText();
			if(peratio.length() > 1)	
		    	listOfPERatio.add(Double.valueOf(peratio));
		}
		isListSortedDouble(listOfPERatio);			
	
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[3]/div[2]/div/div[1]/table/tbody/tr[8]/td[8]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div[1]/div/ul/li[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[4]/p")).click();
		
		
	}
	
	public static void isListSorted(List<String> inputList)
	{

		boolean sortFunctionality = true;
		for(int i=0;i < inputList.size()-1;i++)
		{
			int result = inputList.get(i).compareTo(inputList.get(i+1));
			if(result > 0)
			{
					sortFunctionality=false;
					break;
			}
		}
		if(sortFunctionality)
		{
			System.out.println("SORT Functionality is working");
		}
		else
		{
			System.out.println("SORT Functionality is not working");
		}
	}
	public static void isListSortedDouble(List<Double> inputList)
	{

		boolean sortFunctionality = true;
		for(int i=0;i < inputList.size()-1;i++)
		{
			int result = inputList.get(i).compareTo(inputList.get(i+1));
			if(result > 0)
			{
					sortFunctionality=false;
					break;
			}
		}
		if(sortFunctionality)
		{
			System.out.println("SORT Functionality is working");
		}
		else
		{
			System.out.println("SORT Functionality is not working");
		}
	}

}

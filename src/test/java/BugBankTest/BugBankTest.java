package BugBankTest;

import com.bugbank.base.BaseTest;
import com.bugbank.pages.HomePage;
import com.bugbank.utils.VisualAssert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BugBankTest extends BaseTest {

    @DisplayName("It should click on extract button and validate the scren.")
	@Test
	public void validateExtractVisual() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnExtractButton();
        
	    File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File actualFile = new File("src/test/resources/extract-screenshots/actualExtract.png");
	    FileUtils.copyFile(srcFile, actualFile);

	    BufferedImage screenshot = ImageIO.read(actualFile);

	    VisualAssert.assertScreenshotEquals(screenshot, "src/test/resources/extract-screenshots/expectedExtract.png");
	}

    @DisplayName("It should click on transference button and validate the screen.")
    @Test
    public void validateTransferenceVisual() throws IOException{
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnTransferenceButton();
    	
    	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File actualFile = new File("src/test/resources/transference-screenshots/actualExtract.png");
    	FileUtils.copyFile(srcFile, actualFile);
    	
    	BufferedImage screenshot = ImageIO.read(actualFile);
    	
    	VisualAssert.assertScreenshotEquals(screenshot, "src/test/resources/transference-screenshots/expectedExtract.png");
    }
    
    @DisplayName("It should click on exit button and take a screenshot.")
    @Test
    public void clickOnExitButton() throws IOException{
    	HomePage homePage = new HomePage(driver);
    	homePage.clickOnExitButton();
    	
    	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File actualFile = new File("src/test/resources/exit-screenshots/actualExtract.png");
    	FileUtils.copyFile(srcFile, actualFile);
    	
    	BufferedImage screenshot = ImageIO.read(actualFile);
    	
    	VisualAssert.assertScreenshotEquals(screenshot, "src/test/resources/exit-screenshots/expectedExtract.png");
    	}
}
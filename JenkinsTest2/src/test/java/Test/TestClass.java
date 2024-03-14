package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.Base;

public class TestClass extends Base {

    @Test
    public void validateLogo() {
        WebElement confirmLogo = driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(confirmLogo.isDisplayed(), "Google logo is not displayed");
    }

    @Test
    public void navigateToGoogle() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }
}

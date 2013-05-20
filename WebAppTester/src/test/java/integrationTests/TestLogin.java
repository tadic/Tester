/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author ivantadic
 */
public class TestLogin {
    
    public TestLogin() {
    }
    
   WebDriver driver;
    
    @Before
    public void setUp() {
        // Open homepage
        driver = new HtmlUnitDriver();
        driver.get("https://www.dliv.in");
    }
    private void login(String username, String password){
        // Login with given username and password
        WebElement element= driver.findElement(By.name("email"));
        element.sendKeys(username);
        element = driver.findElement(By.name("pass"));
        element.sendKeys(password);
        element.submit();
    }
    @Test
    public void userCanLoginWithCorrectUsernameAndPassword(){
        String expectedTitle = "Janne Laukkanen | Digital Living";
        login("janne.laukkanen@digitalliving.fi","Mcnab2013");
        assertEquals(expectedTitle, driver.getTitle());
    }
    @Test
    public void userCanNotLoginWithCorrectUsernameAndIncorrectPassword(){
        String expectedTitle = "Digital Living";
        login("ivan.tadic014@gmail.com","somepassword");
        assertEquals(expectedTitle, driver.getTitle());
    }
    @Test
    public void userCanNotLoginWithIncorrectUsernameAndSomePassword(){
        String expectedTitle = "Digital Living";
        login("janne.laukkanen@digitallivin.com","asdasdasd");
        assertEquals(expectedTitle, driver.getTitle());
    }
    @Test
    public void userCanNotLoginWithUsernameAndEmptyPassword(){
        String expectedTitle = "Digital Living";
        login("janne.laukkanen@digitalliving.fi","");
        assertEquals(expectedTitle, driver.getTitle());
    }
    @Test
    public void userCanNotLoginWithEmptyUsernameAndPassword(){
        String expectedTitle = "Digital Living";
        login("","");
        assertEquals(expectedTitle, driver.getTitle());
    }
    

}

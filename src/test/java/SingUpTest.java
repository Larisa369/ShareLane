import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SingUpTest {

    @Test
    public void zipCodeShouldAccept5Digits() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // убедиться что мы на странице sing up
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isOpened, "Страница регистрации не открылась");
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldNnotAccept6Digits() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 6 цифр (например 123456)
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void ipCodeShouldAccept4Digits() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 4 цифрs (например 1234)
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // убедиться что мы на странице sing up
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке (zipcode) некорректное");
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulSingUP1() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // ввести имя
        driver.findElement(By.name("first_name")).sendKeys("Helen");
        driver.findElement(By.name("last_name")).sendKeys("Kim");
        //ввести email
        driver.findElement(By.name("email")).sendKeys("Helen@tut.by");
        //вести пароль (например 9632)
        driver.findElement(By.name("password1")).sendKeys("9632");
        //подтвердить пароль
        driver.findElement(By.name("password2")).sendKeys("9632");
        // нажать кнопку register
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String message = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(message, "Account is created!",
                "Аккаунт не был создан");
        //закрыть браузер
        driver.quit();
    }


    @Test
    public void successfulSingUP2() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // ввести имя
        driver.findElement(By.name("first_name")).sendKeys("Helen");
        driver.findElement(By.name("last_name")).sendKeys("Kim");
        //ввести email
        driver.findElement(By.name("email")).sendKeys("Helen_tut.by");
        //вести пароль (например 4358)
        driver.findElement(By.name("password1")).sendKeys("4358");
        //подтвердить пароль
        driver.findElement(By.name("password2")).sendKeys("4358");
        // нажать кнопку register
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Сообщение об ошибке (email) некорректное");
        //закрыть браузер
        driver.quit();
    }
    @Test
    public void successfulSingUP3() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // ввести имя
        driver.findElement(By.name("first_name")).sendKeys("Tom");
        driver.findElement(By.name("last_name")).sendKeys("Big");
        //ввести email
        driver.findElement(By.name("email")).sendKeys("Tom4568@i.com");
        //вести пароль (например 987)
        driver.findElement(By.name("password1")).sendKeys("987");
        //подтвердить пароль
        driver.findElement(By.name("password2")).sendKeys("987");
        // нажать кнопку register
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Сообщение об ошибке (некорректный ввод)");
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulSingUP4() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // ввести имя
        driver.findElement(By.name("first_name")).sendKeys("Mad");
        driver.findElement(By.name("last_name")).sendKeys("Dan");
        //ввести email
        driver.findElement(By.name("email")).sendKeys("Mad68@25.com");
        //вести пароль (например 4567)
        driver.findElement(By.name("password1")).sendKeys("4567");
        //подтвердить пароль
        driver.findElement(By.name("password2")).sendKeys("456");
        // нажать кнопку register
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=grey_bg]")).getText();
        Assert.assertEquals(error,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Сообщение об ошибке (некорректный ввод)");
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulSingUP5() {
        // установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //откыть страницу https://sharelane.com/cgi-bin/register.py
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // нажать кнопку continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // ввести имя
        driver.findElement(By.name("first_name")).sendKeys("El-Rouse");
        driver.findElement(By.name("last_name")).sendKeys("Bin");
        //ввести email
        driver.findElement(By.name("email")).sendKeys("Rouse_bin@.com");
        //вести пароль (например 4567)
        driver.findElement(By.name("password1")).sendKeys("9362");
        //подтвердить пароль
        driver.findElement(By.name("password2")).sendKeys("9632");
        // нажать кнопку register
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=grey_bg]")).getText();
        Assert.assertEquals(error,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Сообщение об ошибке (некорректный ввод)");
        //закрыть браузер
        driver.quit();
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NatalyaYanochkovaTest {

    //  @Test // SAMPLE! copy all time driver and 2 rows
    //    public void testName(){
    //        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
    //        WebDriver driver = new ChromeDriver();
    //
    //
    //        driver.quit();
    //
    //    }

    // TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //a
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";
        //act
        driver.get(url);
        Thread.sleep(2000);//to see that browser was open
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder='Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);
        Thread.sleep(2000);//to see that in the browser was printed Paris

        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type='submit']")
        );
        searchButton.click();
        Thread.sleep(1000);
        WebElement choiceCityCountryInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        choiceCityCountryInDropDownMenu.click();
        Thread.sleep(1000);
        WebElement h2CityNameHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
                String actualResult = h2CityNameHeader.getText();

        //assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

//Для всех тест кейсов -
//System.setProperty("webdriver.chrome.driver", "YouPathToFile/chromedriver");
//WebDriver driver = new ChromeDriver();
//
//String url = "https://openweathermap.org/";
//
//TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Поддтвердить, что вы перешли на страницу со ссылкой
// https://openweathermap.org/guide и что title этой страницы
// OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testGuideMenuOpeningGuidePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //a
        String url = "https://openweathermap.org/";
        String guideMenuTest = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";
        //act
        driver.get(url);
        Thread.sleep(2000);//to see that browser was open
        WebElement guideMenu = driver.findElement(
                By.linkText(guideMenuTest)
        );
        guideMenu.click();

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        //assert
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        driver.quit();
    }
//TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах
    //!!!!! надо доделать чтоб не было цифры

    @Test
    public void testTemperatureByFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //a
        String url = "https://openweathermap.org/";

        String expectedResult = "50°F";
        //act
        driver.get(url);
        Thread.sleep(5000);//to see that browser was open
        WebElement TemperatureByFahrenheit = driver.findElement(
                By.xpath("//*[@id=\"weather-widget\"]/div[1]/div/div/div[1]/div[2]/div[3]")
        );
        TemperatureByFahrenheit.click();
        Thread.sleep(2000);//to see that in the browser was printed Paris


        WebElement spanFahrenheit = driver.findElement(
              By.xpath("//span[text() = '50°F']")
        );
        Thread.sleep(2000);
        String actualResult = spanFahrenheit.getText();

        //assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }


//TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services.
// Any data collected is anonymised. You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    //блин///я согласилась с куки и теперь не знаю что делвть

    @Test
    public void testCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //a
        String url = "https://openweathermap.org/";

        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";
        //act
        driver.get(url);
        Thread.sleep(5000);//to see that browser was open
        WebElement textAboutCookies = driver.findElement(
                By.xpath("//*[@id=\"stick-footer-panel\"]/div/div/div/div/p[1]")
        );
        Thread.sleep(2000);//to see that in the browser was printed Paris


        WebElement textAllowAll = driver.findElement(
                By.xpath("//*[@id=\"stick-footer-panel\"]/div/div/div/div/div/button")
        );
        Thread.sleep(2000);

        WebElement textManageCookies = driver.findElement(
                By.xpath("//*[@id=\"stick-footer-panel\"]/div/div/div/div/div/a")
        );
        Thread.sleep(2000);

        String actualResult = textAboutCookies.getText();
        String actualResult1 = textAllowAll.getText();
        String actualResult2 = textManageCookies.getText();

        //assert
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        driver.quit();

    }

//TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”,
// “How to start” и “Ask a question”
@Test
public void testSupportMenuHasThreePages() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
    WebDriver driver = new ChromeDriver();
    //a
    String url = "https://openweathermap.org/";
    String SupportMenuText = "Support";
    String expectedResult = "FAQ";
    String expectedResult1 = "How to start";
    String expectedResult2 = "Ask a question";
    //act
    driver.get(url);
    Thread.sleep(2000);//to see that browser was open
    WebElement guideMenu = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown\"]")
    );
    guideMenu.click();

    WebElement textFAQ = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown-menu\"]/li[1]/a")
    );
    Thread.sleep(2000);

    WebElement textHowToStart = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown-menu\"]/li[2]/a")
    );
    Thread.sleep(2000);

    WebElement textAskQuestion = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown-menu\"]/li[3]/a")
    );
    Thread.sleep(2000);

    String actualResult = textFAQ.getText();
    String actualResult1 = textHowToStart.getText();
    String actualResult2 = textAskQuestion.getText();

    //assert
    Assert.assertEquals(actualResult, expectedResult);
    Assert.assertEquals(actualResult1, expectedResult1);
    Assert.assertEquals(actualResult2, expectedResult2);
    driver.quit();
}

//TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка
// “reCAPTCHA verification failed, please try again.”
@Test
public void testAskQuestionWithoutCaptcha() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
    WebDriver driver = new ChromeDriver();
    //a
    String url = "https://openweathermap.org/";
    String SupportMenuText = "Support";
    String nameEmail = "tus@gmail.com";
    String textMassage = "I cannot made my autotest! Help me!";
    String expectedResult = "reCAPTCHA verification failed, please try again.";

    //act
    driver.get(url);
    Thread.sleep(2000);//to see that browser was open
    WebElement guideMenu = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown\"]")
    );
    guideMenu.click();

    WebElement textAskQuestion = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown-menu\"]/li[3]/a")
    );
    textAskQuestion.click();
    Thread.sleep(3000);

    url = "https://home.openweathermap.org/questions";
    driver.get(url);
    System.out.println(driver.getCurrentUrl());
    WebElement searchEmailField = driver.findElement(
            By.xpath("//*[@id=\"question_form_email\"]")
    );
    searchEmailField.click();
    searchEmailField.sendKeys(nameEmail);
    Thread.sleep(2000);

    WebElement searchSubjectField = driver.findElement(
            By.xpath("//*[@id=\"question_form_subject\"]")
    );
    searchSubjectField.click();
    Thread.sleep(2000);

    WebElement choiceOtherInDropDownMenu = driver.findElement(
            By.xpath("//*[@id=\"question_form_subject\"]/option[7]")
    );
    choiceOtherInDropDownMenu.click();
    Thread.sleep(1000);

    WebElement searchMassageField = driver.findElement(
            By.xpath("//*[@id=\"question_form_message\"]")
    );
    searchMassageField.click();
    searchMassageField.sendKeys(textMassage);
    Thread.sleep(2000);


    WebElement buttonSubmit = driver.findElement(
            By.xpath("//*[@id=\"new_question_form\"]/div[9]/input")
    );
    buttonSubmit.click();
    Thread.sleep(1000);

    WebElement textAboutCaptcha = driver.findElement(
            By.xpath(" //*[@id=\"new_question_form\"]/div[9]/div[1]/div")
    );
    Thread.sleep(2000);

    String actualResult = textAboutCaptcha.getText();

    //assert
    Assert.assertEquals(actualResult, expectedResult);

    driver.quit();
}

//TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
@Test
public void testAskQuestionWithoutInputEmail() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
    WebDriver driver = new ChromeDriver();
    //a
    String url = "https://openweathermap.org/";
    String SupportMenuText = "Support";
    //String nameEmail = "tus@gmail.com";
    String textMassage = "I cannot made my autotest! Help me!";
    String expectedResult = "reCAPTCHA verification failed, please try again.";

    //act
    driver.get(url);
    Thread.sleep(2000);//to see that browser was open
    WebElement guideMenu = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown\"]")
    );
    guideMenu.click();

    WebElement textAskQuestion = driver.findElement(
            By.xpath("//*[@id=\"support-dropdown-menu\"]/li[3]/a")
    );
    textAskQuestion.click();
    Thread.sleep(3000);

    url = "https://home.openweathermap.org/questions";
    driver.get(url);
   // System.out.println(driver.getCurrentUrl());
    //WebElement searchEmailField = driver.findElement(
      //      By.xpath("//*[@id=\"question_form_email\"]")
    //);
    //searchEmailField.click();
    //searchEmailField.sendKeys(nameEmail);
    Thread.sleep(2000);

    WebElement searchSubjectField = driver.findElement(
            By.xpath("//*[@id=\"question_form_subject\"]")
    );
    searchSubjectField.click();
    Thread.sleep(2000);

    WebElement choiceOtherInDropDownMenu = driver.findElement(
            By.xpath("//*[@id=\"question_form_subject\"]/option[7]")
    );
    choiceOtherInDropDownMenu.click();
    Thread.sleep(1000);

    WebElement searchMassageField = driver.findElement(
            By.xpath("//*[@id=\"question_form_message\"]")
    );
    searchMassageField.click();
    searchMassageField.sendKeys(textMassage);
    Thread.sleep(2000);


    WebElement buttonSubmit = driver.findElement(
            By.xpath("//*[@id=\"new_question_form\"]/div[9]/input")
    );
    buttonSubmit.click();
    Thread.sleep(1000);

    WebElement textAboutCaptcha = driver.findElement(
            By.xpath(" //*[@id=\"new_question_form\"]/div[9]/div[1]/div")
    );
    Thread.sleep(2000);

    String actualResult = textAboutCaptcha.getText();

    //assert
    Assert.assertEquals(actualResult, expectedResult);

    driver.quit();
}

//TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

//TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась


//TC_11_09
//1.  Открыть базовую ссылку
//2.  В строке поиска в навигационной панели набрать “Rome”
//
//3.  Нажать клавишу Enter
//4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”

//TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок
}

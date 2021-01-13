package cybertek.Test.Sprint2.UserStory10;

import cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class UserStory10 {
    WebDriver driver;
    public cybertek.Utilities.WebDriverFactory WebDriverFactory;
    public Object String;

    public UserStory10() {

    }

    @BeforeMethod
    public void setupMethod() {
        this.driver = cybertek.Utilities.WebDriverFactory.getDriver("chrome");
        String URL = "https://login.nextbasecrm.com/";
        String Login = "hr33@cybertekschool.com";
        String password = "UserUser";
        this.driver.get(URL);
        System.out.println("The title of the page is: " + this.driver.getTitle());
        String actualTitle = this.driver.getTitle();
        System.out.println("ACTUAL TITLE STRING: " + actualTitle);
        String actualUrl = this.driver.getCurrentUrl();
        System.out.println("actualUrl =" + actualUrl);
        this.driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")).sendKeys(new CharSequence[]{Login});
        this.driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[2]/input")).sendKeys(new CharSequence[]{password});
        this.driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input")).click();
        String expected = "(26) Portal";
        String actual = this.driver.getTitle();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        System.out.println(expected.equals(actual) ? "Pass:" : "Fail");
    }

    @Test
    public void TaskTab() {
        this.driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();
        this.driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        this.driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[1]/div[1]/div[1]/label")).click();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var12) {
            var12.printStackTrace();
        }

        this.driver.findElement(By.cssSelector("#post-buttons-bottom > span.tasks-task-mpf-link")).click();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException var11) {
            var11.printStackTrace();
        }

        this.driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[1]/span[1]/span/input[1]")).click();
        this.driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException var10) {
            var10.printStackTrace();
        }

        List<WebElement> elements = this.driver.findElements(By.xpath("//*[@id=\"popup-window-content-calendar_popup_0.866357455244481\"]/div"));
        Iterator var2 = elements.iterator();

        while(var2.hasNext()) {
            WebElement element = (WebElement)var2.next();
            System.out.println(element.getText());

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var9) {
                var9.printStackTrace();
            }

            if (element.getText().equals("July")) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException var8) {
                    var8.printStackTrace();
                }

                List days = this.driver.findElements(By.xpath("//div[@class='bx-calendar-cell bx-calendar-weekend bx-calendar-active "));

                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException var7) {
                    var7.printStackTrace();
                }

                Iterator var5 = days.iterator();

                while(var5.hasNext()) {
                    WebElement d = (WebElement)var5.next();
                    System.out.println(d.getText());
                    if (d.getText().equals(31)) {
                        d.click();
                        this.driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
                        return;
                    }
                }
            }
        }

        this.driver.findElement(By.xpath("//a[.='Select']")).click();
        this.driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        this.driver.close();
    }
}

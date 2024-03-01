import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DropDownList {
    private WebDriver driver;
    private final int questionIndex;
    public DropDownList(int questionIndex) {
        this.questionIndex = questionIndex;
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            data.add(new Object[]{i});
        }
        return data;
    }
    @Test
    public void checkQuestionText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.visibilityOfDropDownList();
        mainPage.clickOnQuestion(questionIndex);
        mainPage.getQuestionLocator(questionIndex);
    }
}

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
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
        return Arrays.asList(new Object[][] {
                {0}, // index of the first question
                {1}, // index of the second question
                {2}, // index of the third question
                {3}, // index of the fourth question
                {4}, // index of the fifth question
                {5}, // index of the sixth question
                {6}, // index of the seventh question
                {7}  // index of the eighth question
        });
    }
    @Test
    public void checkQuestionText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.visibilityOfDropDownList();
        mainPage.clickOnQuestion(questionIndex);
        mainPage.checkQuestionText(questionIndex);
    }
}

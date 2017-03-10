import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestNgProviderExample implements ITest{

    @Test(dataProvider = "summationProvider")
    public void testProvider(String description, int number1, int number2, int sum) {
        Assert.assertEquals(sum, number1 + number2);
    }

    @DataProvider(name = "summationProvider")
    public Object[][] summationData() {
        Object[][] testData = {{"TestName1",1,2,3},{"TestName2",2,2,4}};
        return testData;
    }

    private String reportedTestName = "";

    @BeforeMethod(alwaysRun = true)
    public void testData(Method method, Object[] testData) {
        reportedTestName = testData[0].toString();
    }

    @Override
    public String getTestName() {
        return reportedTestName;
    }
}

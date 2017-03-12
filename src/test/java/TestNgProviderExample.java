import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNgProviderExample implements ITest{

    protected String description;
    protected int firstNumber;
    protected int secondNumber;
    protected int sum;

    // Use Factory to allow fo distinct Test names , not polluted with provider data
    @Factory(dataProvider = "summationProvider")
    public TestNgProviderExample(String description, int firstNumber, int secondNumber, int sum) {
        this.description = description;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sum = sum;
    }

    @Test
    public void testProvider() {
        assertEquals(this.sum, this.firstNumber + this.secondNumber);
    }

    @DataProvider(name = "summationProvider")
    public static Object[][] summationData() {
        Object[][] testData = {{"TestName1",1,2,3},{"TestName2",2,2,4}};
        return testData;
    }

    @Override
    public String getTestName() {
        return description;
    }
}

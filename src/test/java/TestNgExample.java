import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgExample {

    @Test()
    public void testSummation() {

        int sum = 2 + 2;

        Assert.assertEquals(sum, 4);

    }

}
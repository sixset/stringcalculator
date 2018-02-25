import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

    @Test
    public void shouldReturnZeroOnEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(0, stringCalculator.add(""));
    }
}

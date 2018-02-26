import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {

   private StringCalculator stringCalculator;

    @Before public void onCreateCalc() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void inOneNumberShouldReturnSameNumber() {
        Assert.assertEquals(3, stringCalculator.add("3"));
    }

    @Test
    public void inTwoNumbersShouldReturnSum() {
        Assert.assertEquals(8, stringCalculator.add("3,5"));
    }

    @Test
    public void multipleNumbersShouldReturnSum() {
        Assert.assertEquals(9, stringCalculator.add("3,5,1"));
    }
    @Test
    public void sumNumberbelowLine() {
        Assert.assertEquals(6, stringCalculator.add("3\n3"));
    }
    @Test
    public void sumNumberWithCustomSeparator() {
        Assert.assertEquals(8, stringCalculator.add("//;\n1;4;3"));
    }
    @Test
    public void inNegativeNumberShuldThrowException() {
        RuntimeException exception = null;
        try {
            stringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: -6,-18", exception.getMessage());
    }
    @Test
    public void numberBiggerThan1000ShuldBeIgnored() {
        Assert.assertEquals(8, stringCalculator.add("//;\n1;4;1001;3"));
    }
    
}







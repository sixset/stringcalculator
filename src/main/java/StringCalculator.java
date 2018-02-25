import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class StringCalculator {

    private String CHARACTER = ",|\n";

    public int add(String numbers) {
        if (numbers.startsWith("//")){
            numbers = getNumbers(numbers);
        }
        return getSum(splitString(numbers));
    }

    private String getNumbers(String numbers) {
        int delimiterIndex = numbers.indexOf("//") + 2;
        this.CHARACTER = numbers.substring(delimiterIndex, delimiterIndex + 1);
        numbers = numbers.substring(numbers.indexOf("n") + 1);
        return numbers;
    }

    private String[] splitString(String numbers) {
        if (numbers.isEmpty()) {
            return new String[0];
        } else {
            String[] tabOfNumbers = numbers.split(CHARACTER);
            return tabOfNumbers;
        }
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += valueOf(number);
        }
        return sum;
    }
}

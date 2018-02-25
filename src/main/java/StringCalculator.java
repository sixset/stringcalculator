import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class StringCalculator {

    public static final String CHARACTER = ",|\n";


    public int add(String numbers) {
        return getSum(splitString(numbers));
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

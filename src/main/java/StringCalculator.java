import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.contains(",")) {
            return getSum(numbers);
        } else {
            return valueOf(numbers);
        }
    }

    private int getSum(String numbers) {
        String[] tabOfNumbers = numbers.split(",");
        int sum = 0;
        for (String number : tabOfNumbers) {
            sum += valueOf(number);
        }
        return sum;
    }
}


import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class StringCalculator {

    private String CHARACTER = ",|\n";

    public int add(String numbers) {
        numbers = checkDelimeter(numbers);
        String[] tabOfNumber = removeBiggerThousand(splitString(numbers));
        return getSum(tabOfNumber);
    }

    private String checkDelimeter(String numbers) {
        if (numbers.startsWith("//")) {
            numbers = getNumberWithSingleCustomDelimiter(numbers);
        }
        return numbers;
    }

    private String[] removeBiggerThousand(String[] numbers) {
        List<String> numbersWithOutThousand = new ArrayList();
        for (String number : numbers) {
            if (valueOf(number) <= 1000) {
                numbersWithOutThousand.add(number);
            }
        }
        return numbersWithOutThousand.toArray(new String[numbersWithOutThousand.size()]);
    }

    private String getNumberWithSingleCustomDelimiter(String numbers) {
        int delimiterIndex = numbers.indexOf("//") + 2;
        this.CHARACTER = numbers.substring(delimiterIndex, delimiterIndex + 1);
        numbers = numbers.substring(numbers.indexOf("n") + 1);
        System.out.println(numbers);
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
        List negativeNumbers = new ArrayList();
        for (String number : numbers) {
            sum += valueOf(number);
            if (valueOf(number) < 0) {
                negativeNumbers.add(number);
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed:" + negativeNumbers.toString());
        }
        return sum;
    }
}


import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.joining;

public class StringCalculator {

    private String DELIMETER = ",|\n";
    private static final int MAXNUMBERS = 1000;


    public int add(String numbers) {
        numbers = checkDelimeter(numbers);
        String[] tabOfNumber = splitString(numbers);
        checkForNegativeNumbers(tabOfNumber);
        return sumArray(tabOfNumber);
    }

    private void checkForNegativeNumbers(String [] numbersTab) {
        List <String> numbersList = Arrays.asList(numbersTab);
        String negatives = numbersList.stream()
                .filter(s -> s.contains("-"))
                .collect(joining(","));
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }

    private String checkDelimeter(String numbers) {
        if (numbers.startsWith("//")) {
            numbers = getNumberWithSingleCustomDelimiter(numbers);
        }
        return numbers;
    }

    private String getNumberWithSingleCustomDelimiter(String numbers) {
        int delimiterIndex = numbers.indexOf("//") + 2;
        this.DELIMETER = numbers.substring(delimiterIndex, delimiterIndex + 1);
        numbers = numbers.substring(numbers.indexOf("\n") + 1);
        return numbers;
    }

    private String[] splitString(String numbers) {
        if (numbers.isEmpty()) {
            return new String[0];
        } else {
            return numbers.split(DELIMETER);
        }
    }

    private int sumArray(String[] arrayNumbers) {
        List <String> numbersList = Arrays.asList(arrayNumbers);
        return numbersList.stream()
                .filter(s -> Integer.parseInt(s) <= MAXNUMBERS)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}

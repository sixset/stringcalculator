public class StringCalculator {


    public int add(String numbers){
        if (numbers.isEmpty()){
            return 0;
        }else if (numbers.contains(",")){
            String [] numbersTab = numbers.split(",");
            return Integer.valueOf(numbersTab[0])+Integer.valueOf(numbersTab[1]);
        }else {
            return Integer.valueOf(numbers);
        }

    }
}

package JavaTasks.JavaFundamentals;

import java.util.Arrays;

public class OptionalTask1 {

//        Задание. Ввести n чисел с консоли.
//        1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//
//        2.     Вывести числа в порядке возрастания (убывания) значений их длины.
//
//        3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
//
//        4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
//
//        5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
//
//        6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
//
//        7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

    //        1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public void run1 (String[] args){
        double maxNumber = 0;
        double minNumber = Double.POSITIVE_INFINITY;
        int maxNumberLength = 0;
        int minNumberLength = 0;
        for (String number : args) {
            try {
                double valueOfNumber = Double.parseDouble(number.replace("," , "."));
                if (Math.abs(maxNumber) <= Math.abs(valueOfNumber)){
                    maxNumber = valueOfNumber;
                    maxNumberLength = number.length();
                }
                if (Math.abs(minNumber) >= Math.abs(valueOfNumber)){
                    minNumber = valueOfNumber;
                    minNumberLength = number.length();
                }
            } catch (Exception e){
                System.out.println(number + " is not currently a number and will not be compared with other numbers");
            }
        }
        System.out.println("\nminimal number is " + minNumber + " and its length is " + minNumberLength + "\nmaximal number is " + maxNumber + " and its length is " + maxNumberLength);

    }
    //        2.     Вывести числа в порядке возрастания (убывания) значений их длины.
    public void run2 (String[] args){
        double valueOfNumber = Double.POSITIVE_INFINITY;
        double [] array = new double[args.length];
        for (int left = 0; left < args.length; left++) {
            int numberLength = args[left].length();
            int i = left - 1;
            try {
                valueOfNumber = Double.parseDouble(args[left].replace("," , "."));
                array[left] = valueOfNumber;
            }  catch (Exception e){
                System.out.println(args[left] + " is not currently a number and will be counted as 0");
                continue;
            }
            for (; i >= 0; i--) {
                if (numberLength < args[i].length()) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = valueOfNumber;
        }
        Arrays.sort(array);
        System.out.println("From lower to upper\n" + Arrays.toString(array));
        System.out.println("From upper to lower");
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
}
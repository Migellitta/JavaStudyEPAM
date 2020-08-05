package JavaTasks.JavaFundamentals;

import java.util.Arrays;
import java.util.HashSet;

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
    public void run1(String[] args) {
        double maxNumber = 0;
        double minNumber = Double.POSITIVE_INFINITY;
        int maxNumberLength = 0;
        int minNumberLength = 0;
        for (String number : args) {
            try {
                double valueOfNumber = Double.parseDouble(number.replace(",", "."));
                if (Math.abs(maxNumber) <= Math.abs(valueOfNumber)) {
                    maxNumber = valueOfNumber;
                    maxNumberLength = number.length();
                }
                if (Math.abs(minNumber) >= Math.abs(valueOfNumber)) {
                    minNumber = valueOfNumber;
                    minNumberLength = number.length();
                }
            } catch (Exception e) {
                System.out.println(number + " is not currently a number and will not be compared with other numbers");
            }
        }
        System.out.println("\nminimal number is " + minNumber + " and its length is " + minNumberLength + "\nmaximal number is " + maxNumber + " and its length is " + maxNumberLength);

    }

    //        2.     Вывести числа в порядке возрастания (убывания) значений их длины.
    public void run2(String[] args) {
        double valueOfNumber = Double.POSITIVE_INFINITY;
        double[] array = new double[args.length];
        for (int left = 0; left < args.length; left++) {
            int numberLength = args[left].length();
            int i = left - 1;
            try {
                valueOfNumber = Double.parseDouble(args[left].replace(",", "."));
                array[left] = valueOfNumber;
            } catch (Exception e) {
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
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    //        3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
    public void run3(String[] args) {
        if (args.length != 0) {
            String incomingArgs = Arrays.toString(args);
            System.out.println("Incoming " + incomingArgs);
            int argsLengthForOnlyNumbers = args.length;
            double averageAmountOfSymbols = 0;
            for (String element : args) {
                try {
                    double temp = Double.parseDouble(element.replace(",", "."));
                } catch (Exception e) {
                    argsLengthForOnlyNumbers--;
                }
            }
            String[] argsOnlyNumbers = new String[argsLengthForOnlyNumbers];
            int amendment = 0;
            for (int i = 0; i < args.length; i++) {
                try {
                    int amountOfOriginalSymbols = args[i].length();
                    double temp = Double.parseDouble(args[i].replace(",", "."));
                    String temp1 = args[i];
                    averageAmountOfSymbols += amountOfOriginalSymbols;
                    argsOnlyNumbers[i - amendment] = temp1;
                } catch (Exception e) {
                    amendment++;
                }
            }
            averageAmountOfSymbols /= argsLengthForOnlyNumbers;
            System.out.println("Average length of numbers are " + averageAmountOfSymbols);
            System.out.println("lower then average numbers are: ");
            for (String temp2 : argsOnlyNumbers) {
                if (temp2.length() < averageAmountOfSymbols) {
                    System.out.println(temp2);
                }
            }
            System.out.println("higher then average numbers are: ");
            for (String temp2 : argsOnlyNumbers) {
                if (temp2.length() > averageAmountOfSymbols) {
                    System.out.println(temp2);
                }
            }
        } else {
            System.out.println("No incoming values");
        }
    }

    //        4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
    public void run4(String[] args) {
        if (args.length != 0) {
            String incomingArgs = Arrays.toString(args);
            System.out.println("Incoming " + incomingArgs);
            int argsLengthForOnlyNumbers = args.length;
            for (String element : args) {
                try {
                    double temp = Double.parseDouble(element.replace(",", "."));
                } catch (Exception e) {
                    argsLengthForOnlyNumbers--;
                }
            }
            int[] argsOnlyNumbers = new int[argsLengthForOnlyNumbers];
            int amendment = 0;
            for (int i = 0; i < args.length; i++) {
                try {
                    int temp = Integer.parseInt(args[i].replace(",", "."));
                    argsOnlyNumbers[i - amendment] = temp;
                } catch (Exception e) {
                    amendment++;
                }
            }
            int min = diffNum(argsOnlyNumbers[0]);
            int minElem = argsOnlyNumbers[0];

            for (int i = 1; i < argsOnlyNumbers.length; i++) {
                if (diffNum(argsOnlyNumbers[i]) < min) {
                    min = diffNum(argsOnlyNumbers[i]);
                    minElem = argsOnlyNumbers[i];
                }
            }
            System.out.printf("Elem: %d", minElem);

        } else {
            System.out.println("No incoming values");
        }
    }

    private static int diffNum(int x){
        HashSet<Integer> nums = new HashSet<>();
        while (x>0){
            nums.add(x%10);
            x/=10;
        }
        return nums.size();
    }
}


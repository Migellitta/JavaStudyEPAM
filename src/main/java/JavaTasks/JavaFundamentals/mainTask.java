package JavaTasks.JavaFundamentals;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

//        Реализовать следующие программы:
//        1.     Приветствовать любого пользователя при вводе его имени через командную строку.
//
//        2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
//
//        3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
//
//        4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
//
//        5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

//        1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class mainTask {
    public void run1 () {
        Scanner in = new Scanner(System.in);
        out.print("Whats your name, bro? \n");
        String name = in.nextLine();
        in.close();
        out.println("Hi " + name + ". Nice to meet u :)");
    }

//        2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
    public void run2(String[] args) {
        for( int i = args.length - 1 ; i >= 0 ; i--)
            System.out.println("Reverse : " + args[i]);

    }
//        3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
    public void run3 (String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            int amountOfRandomNumbers = (int) Math.round(a);
            int[] array = new int[amountOfRandomNumbers];
            Random r = new Random();
            for (int i = 0; i < amountOfRandomNumbers; i++) {
            array[i] = r.nextInt();
            System.out.print(array[i] + " ");
            }
            System.out.println("\n");
            for (int i = 0; i < amountOfRandomNumbers; i++) {
                System.out.println(array[i]);
            }
        }
        catch (Exception e){
            System.out.println("Unavailable amount of numbers");
        }
}
//        4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
    public void run4 (String[] args) {
        int sumResult = 0;
        int multResult = 1;
        for (int i = 0; i <= args.length; i++) {
            try {
                double a = Double.parseDouble(args[i].replace(",", "."));
                int x = (int)Math.round(a);
                sumResult += x;
                multResult *= x;
            }
            catch (Exception ignored){
            }
        }
        if (sumResult != 0 && multResult != 1){
            System.out.println("summ = " + sumResult + "\nmult = " + multResult);
        } else {
            System.out.println("No arranged arguments received for getting summ or mult");
        }
    }
//        5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
    public void run5 (String[] args) {
        try {
            int monthNumber = Integer.parseInt(args[0]);
            if (0 < monthNumber && monthNumber < 13){
                switch (monthNumber) {
                    case 1 -> System.out.println("January");
                    case 2 -> System.out.println("February");
                    case 3 -> System.out.println("March");
                    case 4 -> System.out.println("April");
                    case 5 -> System.out.println("May");
                    case 6 -> System.out.println("June");
                    case 7 -> System.out.println("July");
                    case 8 -> System.out.println("August");
                    case 9 -> System.out.println("September");
                    case 10 -> System.out.println("October");
                    case 11 -> System.out.println("November");
                    case 12 -> System.out.println("December");
                }
            } else  {
                System.out.println("Incorrect number, should be between 1 and 12");
            }
        }
        catch (Exception e){
            System.out.println("Unavailable number");
        }
    }
}

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("   1. Задать целочисленный массив, состоящий из элементов 0 и 1. \n" +
                "С помощью цикла и условия заменить 0 на 1, 1 на 0:\n" +
                " \nНаш исходный массив:");
        int[] arrayForTask1 = new int[10]; //задаём массив для 1го задания
        for (int i = 0; i < arrayForTask1.length; i++) {
            arrayForTask1[i] = (int) Math.round(Math.random()); //генерируем массив случайным образом состоящий из 0 и 1 округлением рандомного числа
            System.out.print(arrayForTask1[i] + "\t");
        }
        System.out.println("\n\nЗаменяя 0 и 1, мы получим:");
        for (int i = 0; i < arrayForTask1.length; i++) { //перебираем каждый элемент массива и меняем 1 на 0, а всё остальное на 1
            if (arrayForTask1[i] == 1) {
                arrayForTask1[i] = 0;
            } else {
                arrayForTask1[i] = 1;
            }
            System.out.print(arrayForTask1[i] + "\t");
        }

        System.out.println("\n\n   2. Задать пустой целочисленный массив размером 8. \n" +
                "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21:\n");
        int[] arrayForTask2 = new int[8]; //задаём массив для 2го задания
        for (int i = 0; i < arrayForTask2.length; i++) {
            arrayForTask2[i] = i * 3;
            System.out.print(arrayForTask2[i] + "\t");
        }

        System.out.println("\n\n   3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2" +
                "\n\nНаш исходный массив:");
        int[] arrayForTask3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //задаём массив для 3го задания
        for (int i = 0; i < arrayForTask3.length; i++) {
            System.out.print(arrayForTask3[i] + "\t");
        }
        System.out.println("\n\nУмножая все числа, меньше 6 на 2, мы получаем массив:");
        for (int i = 0; i < arrayForTask3.length; i++) {
            if (arrayForTask3[i] < 6) {
                arrayForTask3[i] = arrayForTask3[i] * 2;
            }
            System.out.print(arrayForTask3[i] + "\t");
        }

        System.out.println("\n\n   4. Создать квадратный двумерный целочисленный массив, и с помощью цикла(-ов) заполнить его диагональные элементы единицами:");
        int[][] arrayForTask4 = new int[6][6]; //задаём массив для 4го задания

////        * на случай, если выводить нет необходимости *
//        for(int i=0; i<arrayForTask4.length; i++){ //заполняем диагональные элементы массива еденицами
//            arrayForTask4[i][i] = 1;
//            arrayForTask4[i][arrayForTask4.length-i-1] = 1;
//        }
//
//        for (int i =0; i<arrayForTask4.length; i++){ //выводим массив на экран
//            for (int j=0; j<arrayForTask4[i].length; j++){
//                System.out.print(arrayForTask4[i][j]+"\t");
//            }
//            System.out.print("\n");
//        }

        for (int i = 0; i < arrayForTask4.length; i++) { //заполняем диагональные элементы массива 1 и выводим массив на экран
            for (int j = 0; j < arrayForTask4[i].length; j++) {
                if (i == j || (arrayForTask4.length - i - 1) == j) {
                    arrayForTask4[i][j] = 1;
                }
                System.out.print(arrayForTask4[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("\n   5. Задать одномерный массив и найти в нем минимальный и максимальный элементы:");
        int[] arrayForTask5 = new int[10]; //задаём массив для 5го задания
        System.out.println("\nНаш исходный массив:");
        for (int i = 0; i < arrayForTask5.length; i++) {
            arrayForTask5[i] = (int) (Math.random() * (22) - 11); //генерируем массив из случайных чисел от -10 до 10
            System.out.print(arrayForTask5[i] + "\t");
        }
        int minValue = arrayForTask5[0]; //объявляем переменные и задаём им велечину первого элемента массива на случай, если все элементы будут меньше, или больше любого другого заданного значения
        int maxValue = arrayForTask5[0];
        for (int i = 1; i < arrayForTask5.length; i++) {
            if (arrayForTask5[i] < minValue) {
                minValue = arrayForTask5[i];
            } else if (arrayForTask5[i] > maxValue) {
                maxValue = arrayForTask5[i];
            }
        }
        System.out.println("\nминимальное число в массиве равно: " + minValue + "\nмаксимальное число в массиве равно: " + maxValue);

        System.out.println("\n\n   6. Написать метод, в который передается не пустой одномерный целочисленный массив." +
                "\n метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны." +
                "\n\n Передаваемый методу массив:");
        int[] arrayForTask6 = new int[9]; //задаём массив для 6го задания
        for (int i = 0; i < arrayForTask6.length; i++) {
            arrayForTask6[i] = (int) (Math.random() * 11); //генерируем массив из случайных чисел от 0 до 10
            System.out.print(arrayForTask6[i] + "\t");
        }
        System.out.print("\nможно ли его разделить на 2 равных по сумме части? ");

        if (doTask6(arrayForTask6)) {
            System.out.println("Да.");
        } else {
            System.out.println("Нет.");
        }

        System.out.println("\n   7. Написать метод, которому на вход подается одномерный массив и число n." +
                "\n метод должен сместить все элементымассива на n позиций." +
                "\n\n Передаваемый методу массив:");
        int[] arrayForTask7 = new int[6]; //задаём массив для 7го задания
        for (int i = 0; i < arrayForTask7.length; i++) {
            arrayForTask7[i] = (int) (Math.random() * 11); //генерируем массив из случайных чисел от 0 до 10
            System.out.print(arrayForTask7[i] + "\t");
        }
        System.out.println("\n\nВведите число на которое нужно сместить элементы массива:");
        int shiftArray = scanner.nextInt(); // для удобства изменения

        doTask7(arrayForTask7, shiftArray);
    }

    private static boolean doTask6(int[] array) {
        int sum = 0;
        int leftPartSum = 0;
        for (int i = 0; i < array.length; i++) { //вычисляем сумму всех элементов массива
            sum += array[i];
        }
        if (sum % 2 == 0) { //нечётная сумма не удовлетворяет условию
            for (int i = 0; i < array.length; i++) {
                leftPartSum += array[i];
                if (leftPartSum * 2 == sum) {
                    return true;
                } else if (leftPartSum * 2 > sum) {
                    break;
                }
            }

        }
        return false;
    }

    private static void doTask7(int[] array, int n) {
        n = n % array.length; //определёяем на сколько реально нужно сместить элементы массива
        int storageValue = 0; //для запоминания перезаписываемого элемента массива
        while (n != 0) {
            if (n > 0) { //переносим по 1му элементу вправо
                storageValue = array[(array.length - 1)];
                for (int i = (array.length - 1); i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = storageValue;
                n--;
            } else {//переносим по 1му элементу влево
                storageValue = array[0];
                for (int i = 0; i < (array.length - 1); i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = storageValue;
                n++;
            }
        }
        System.out.println("новый массив:\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

}
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //должен быть в методе main
        boolean quite = false; //для выхода из программы
        int choice;
        while (quite == false){
            System.out.println("Выберите номер задания. Любое несоответствие приведёт к жестокому завешению.");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("с этим заданием я пока не справился. когда нибудь...\n");
                    break;
                case 2:
                    System.out.println("byte byte_ = 8; //-128 ~ 127\n" +
                            "short short_ = 16; //-32768 ~ 32767\n" +
                            "int int_ = 32; //-2147483648 ~ 2147483647\n" +
                            "long long_ = 64; //-9223372036854775808L ~ 9223372036854775807L Без L только 32б\n" +
                            "float float_1 = 2147483647;\n" +
                            "float float_2 = 2.5f; //при написании с точкой без f ругается, что должно быть double. нипанятно чем подобное обусловленно\n" +
                            "double double_1 = 2.5;\n" +
                            "double double_2 = 9223372036854775807d; //без d или L только 32б\n" +
                            "char char_1 = '┤';\n" +
                            "char char_2 = 9508; //от 0 до 65535\n" +
                            "char char_3 = '\\u2524'; //от '\\u0000' до '\\uffff'\n" +
                            "//    int a = char_; // переводит юникод из 16ричной системы в 10ную\n" +
                            "boolean boolean_ = false; //false, true\n" +
                            "String = \"строка\"\n");
                    break;
                case 3:
                    System.out.println("Введите 4 числа (a,b,c,d), а мы найдём, чему равно равенство a * (b + (c / d))");
                    System.out.println(expression_3(
                            scan.nextFloat(), //почему то сканируемое число с плавающей точкой должно быть вида *,*
                            scan.nextFloat(),
                            scan.nextFloat(),
                            scan.nextFloat()
                    )+"\n");
                    break;
                case 4:
                    System.out.println("Введите 2 числа, а мы узнаем, лежит ли их сумма в пределах, между 10 и 20, включительно");
                    System.out.println(expression_4(
                            scan.nextFloat(),
                            scan.nextFloat()
                    )+"\n");
                    break;
                case 5:
                    System.out.println("Введите целое число, одного хватит, а мы разберёмся, положительное ли оно, или нет");
                    System.out.println(expression_5(
                            scan.nextInt()
                    )+"\n");
                    break;
                case 6:
                    System.out.println("Введите целое число, и мы вернём вам информацию о том, отрицательное ли оно");
                    System.out.println(expression_6(
                            scan.nextInt()
                    )+"\n");
                    break;
                case 7:
                    System.out.println("Введите имя");
//                    String they_name = scan.next();   //пока имя запоминать не требуется
                    System.out.println("Привет, " + scan.next()+"\n");
                    break;
                case 8:
                    System.out.println("Введите год, а мы подскажем, високосный ли он");
                    years(scan.nextInt());
                    break;
                default: quite = true;
            }
        }
    }

    //          3
    private static float expression_3(float a, float b, float c, float d) {
        return (a * (b + (c / d))); // если бы требовалось найти a + (b*(c/d), было бы наглядней
    }

    //    4
    private static boolean expression_4(float a, float b){
        return (a + b) >= 10 && (a + b) <= 20;
//        return (a+b)>=10 && (a+b)<=20 ? true : false;
    }

    //    5
    private static String expression_5(int a){
        return a >= 0 ? "позитивное" : "антипозитивное";
//        if (a<0){
//            return "негативное";
//        } return "не негативное";
    }

    //    6
    private static boolean expression_6(int a){
        if (a<0) {
            return true;
        } return false; //а вот можно ли ничего не возвращять не знаю. можно, конечно, все действия прописывать в методе main, но лень
    }

    //    8
    private static void years (int a) {
        if (a % 4 == 0) {
            if (a % 100 == 0 && a % 400 != 0) {
                System.out.println("Год не високосный \n");
            } else{
                System.out.println("Год високосный \n");
            }
        } else {
            System.out.println("Год не високосный \n");
        }
    }



}
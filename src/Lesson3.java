import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        int numberOfAttempts = 3;
        int maxRandomValue = 9;
        guessTheNumber(numberOfAttempts, maxRandomValue);

        String[] words = new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        printWordsVariation(words);
        guessTheWord(words);
    }

    static void guessTheNumber(int num, int maxRandom) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int valueForRestart;
        do {
            int randValue =random.nextInt(maxRandom+1);
            for(int n = num; n> 0; n--) {
                System.out.println("Угадайте задуманную цифру. Количество оставшихся попыток: " + n);
                int scanValue = scan.nextInt();
                if (scanValue == randValue) {
                    System.out.print("Поздравляю, вы выиграли! ");
                    break;
                } else if (scanValue < randValue) {
                    System.out.println("Вы не угадали. Загаданная цыфра больше, чем " + scanValue);
                } else {
                    System.out.println("Вы не угадали. Загаданная цыфра меньше, чем " + scanValue);
                }
            }
            System.out.println("Загаданная цыфра: " + randValue + "\nХотите сыграть ещё раз?\n1 - да\n2 - нет");
            valueForRestart = scan.nextInt();
        } while (valueForRestart == 1);
//        scan.close();  //начал выдавать ошибку
    }

    static void guessTheWord(String[] words){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        char[] hiddenWord = new char[] {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        String puzzledWord = words[random.nextInt(words.length)];

        System.out.println("попробуйте отгадать слово. ");
        while (true){
            String scanWord = scan.next();
            if (scanWord.equals(puzzledWord) ){
                System.out.println("Поздравляю, вы угадали слово!");
                break;
            } else {
                for(int i = 0; i<scanWord.length() && i<puzzledWord.length();i++){
                   if (puzzledWord.charAt(i) == scanWord.charAt(i)){
                       hiddenWord[i] = scanWord.charAt(i);
                   }
               }
                System.out.println("Это не то слово. Правильно названные буквы:");
               for (char i: hiddenWord)     {
                   System.out.print(i);
               }
                System.out.println("\nПопробуйте ещё раз:");
            }
        }
        scan.close();
    }


//     Выводит список доступных слов
    static void printWordsVariation(String[] words){
        int column = 0;
        for(String i: words) {
            System.out.print(i);
            if (column < 5) {
                System.out.print("\t\t");
                column++;
            } else {
                System.out.println("\n");
                column = 0;
            }
        }
        System.out.println(" ");
    }
}



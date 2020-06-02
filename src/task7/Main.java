package task7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        doTask();
    }

    private static void doTask(){

        Scanner scanner = new Scanner(System.in);
        boolean doRecursion = true;
        Cat[] cats = createCats();
        Plate plate = new Plate(130);
        do {
            System.out.println("\nSelect an action:\n 1: Cats info\n 2: Plate info\n 3: Fill up plate\n 4: Call cats to eat\n 5: Skip time(make cats hungry)\n 6: Quite");
            switch (scanner.next()) {
                case "1": {
                    if(cats.length!=0) {
                        for (int i = 0; i < cats.length; i++) {
                            System.out.println(cats[i].getName() + (cats[i].hungry ? " hungry" : " fed up"));
                        }
                    }else {
                        System.out.println("All cat escape");
                        doRecursion = false;
                    }
                    break;
                }
                case "2": {
                    plate.info();
                    break;
                }
                case "3": {
                    System.out.println("how much do you want to put?");
                    plate.addFood(scanner.nextInt());
                    break;
                }
                case "4": {
                    if(cats.length==0) {
                        System.out.println("nobody did not come");
                    }else{
                        feedCats(cats, plate);
                    }
                    break;
                }
                case "5": {
                    cats = deleteCats(cats);
                    break;
                }
                case "6": {
                    doRecursion = false;
                    break;
                }
                default: {
                    System.out.println("Wrong number");
                }
            }
        }while (doRecursion);
    }

    private static void feedCats(Cat[] cats, Plate plate) {
        Cat[] hungryCats;
        do{
            hungryCats = getHungryCats(cats, plate.getFood());
            if(hungryCats.length!=0){hungryCats[(int) (Math.random() * hungryCats.length)].eat(plate);}
        }while (hungryCats.length>0);
    }

    static Cat[] getHungryCats(Cat[] cats, int food) {
        boolean foodCheck = true;
        Cat[] hungryCats = new Cat[0];
        for (int i = 0; i < cats.length; i++) {
            if(cats[i].hungry){
                hungryCats = doRemainCats(hungryCats, cats[i]);
                if(cats[i].getAppetite()<food){ foodCheck=false;}
            }
        }
        if(foodCheck){hungryCats = new Cat[0];}
        return hungryCats;
    }

    static Cat[] createCats(){
        Cat[] cats = new Cat[]{
                new Cat("Barsik", 5),
                new Cat("Murthik", 6),
                new Cat("Morsik", 4),
                new Cat("boring", 7),
                new Cat("Obgoring", 12),
                new Cat("larthik", 7),
                new Cat("gmurik", 5),
        };
        return cats;
    }

    static Cat[] deleteCats(Cat[] cats){
        Cat[] newCats = new Cat[0];
        for (int i = 0; i<cats.length ; i++) {
            if(!cats[i].hungry){
                newCats = doRemainCats(newCats, cats[i]);
                newCats[newCats.length-1].hungry = true;
            }
        }
        return newCats;
    }

    static Cat[] doRemainCats(Cat[] cats, Cat oldCat){
        Cat[] newCats = new Cat[cats.length+1];
        for (int i = 0; i < cats.length; i++) {newCats[i] = cats[i];}
        newCats[cats.length] = oldCat;
        return newCats;
    }


}



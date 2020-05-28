package task6;

public class Main {

    public static void main(String[] args) {
        doTest();
    }

    static void doTest() {
        Animals animals[] = createAnimals();
        getAnimalsCount();
        animals[3].jump(0.6);
        animals[1].swim(20);
        animals[5].run(200);
    }

    static Animals[] createAnimals(){
              Animals[] animals = new Animals[]{
                      new Cat("Vasya"),
                      new Cat("Murzya"),
                      new Cat("Tigidicknya"),
                      new Dog("Bobick"),
                      new Dog("Teya"),
                      new Cat("Ubiyca"),
                      new Cat("Murchalo"),
                      new Dog("Volk")
              };
              return animals;
    }

    static void getAnimalsCount(){
        System.out.println("Animals: " + Animals.getObjectCount() +
                "\nDogs: "+ Dog.getDogObjectCount() +
                "\nCats: "+ Cat.getCatObjectCount());
    }

}


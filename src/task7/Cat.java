package task7;

public class Cat {
    private String name;
    private int appetite;
    boolean hungry = true;

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if(plate.getFood()>=appetite){
            plate.decreaseFood(appetite);
            hungry = false;
            System.out.println(name + " a happy purring");
        }else{
            System.out.println(name + " displeased looking at you");
        }

    }
}

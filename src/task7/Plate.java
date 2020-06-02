package task7;

public class Plate {
    private  int size;
    private int food;
    public Plate(int size) {
        this.size = size;
        this.food = size;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int volume) {
        if(volume>=0) {
            food += volume;
            if (food > size) {
                System.out.println("some food fell to the floor");
                food = size;
            }
        }else{
            System.out.println("steal from cats is bad");
        }
    }

    public void decreaseFood(int n) {
        food -= n;
    }
    public void info() {
        System.out.println("plate: " + food + ("/") + size);
    }
}

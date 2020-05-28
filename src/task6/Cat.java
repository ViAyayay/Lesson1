package task6;

class Cat extends Animals{
    private static int catObjectCount = 0;
    Cat(String name) {
        this.name = name;
        this.catObjectCount++;
        this.runBound = 200+(int)(Math.random()*51);
        this.jumpHeight = 2+(Math.random()/2);
    }

    protected static int getCatObjectCount() {
        return catObjectCount;
    }
}
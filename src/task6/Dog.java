package task6;

class Dog extends Animals{
    private static int dogObjectCount = 0;
    Dog(String name) {
        this.name = name;
        this.dogObjectCount++;
        this.runBound = 400+(int)(Math.random()*101);
        this.swimBound = 10+(int)(Math.random()*5);
        this.jumpHeight = 0.2+(Math.random()/2);
    }

    protected static int getDogObjectCount() {
        return dogObjectCount;
    }
}
package task6;

abstract class Animals {
    private static int objectCount;
    protected String name;
    protected int runBound;
    protected int swimBound;
    protected double jumpHeight;

    protected Animals() { objectCount++; }

    protected static int getObjectCount() { return objectCount; }

    protected String ya(){ return name; }

    protected void run(int distance){
        if(runBound>0){
            if(Math.abs(distance)<=runBound && distance != 0) {
                String direct = distance < 0 ? " backward.\n" : ".\n";
                System.out.printf("%1$s ran %2$d meters%3$s", name, Math.abs(distance), direct);
            } else if (distance ==0 ){
                System.out.printf("%1$s still standing.\n", name);
            } else {
                System.out.printf("%1$s can't run so far.\n", name);
            }
        } else{
            System.out.printf("%1$s can't run\n", name);
        }
    }

    protected void swim(int distance){
        if(swimBound>0){
            if(Math.abs(distance)<=swimBound && distance != 0) {
                String direct = distance < 0 ? " backward.\n" : ".\n";
                System.out.printf("%1$s swim %2$d meters%3$s", name, Math.abs(distance), direct);
            } else if (distance ==0 ){
                System.out.printf("%1$s still swimming in place.\n", name);
            } else {
                System.out.printf("%1$s can't swim so far.\n", name);
            }
        } else{
            System.out.printf("%1$s can't swim\n", name);
        }
    }

    protected void jump(double height){
        if(jumpHeight>0){
            if(height>0) {
                if(height<= jumpHeight) {
                    System.out.printf("%1$s jumped an obstacle\n", name);
                } else {
                    System.out.printf("%1$s can't jump so high.\n", name);
                }
            } else if (height ==0 ){
                System.out.printf("%1$s still sitting in place.\n", name);
            } else {
                System.out.printf("%1$s confused.\n", name);
            }
        } else{
            System.out.printf("%1$s can't jump\n", name);
        }
    }
}



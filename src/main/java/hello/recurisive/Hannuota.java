package hello.recurisive;

/**
 * Created by scnyig on 9/22/2017.
 *
 */
public class Hannuota {
    private static int count  = 0;
    /**
     * move n pice from x to z
     * @param n
     * @param x
     * @param y
     * @param z
     */
    public static void move(int n, String x, String y, String z) {
        if (n == 1) {
            System.out.println(x + "-->" + z + " " + count);
            count ++;
        } else {
            move(n-1, x,z,y);
            System.out.println(x + "-->" + z + " " + count);
            count++;
            move(n-1,y,x,z);
        }
    }

    public static void main(String[] args) {
        move(5,"X","Y","Z");
        System.out.println(count);
    }
}

    //pesuo code
    /*void Hanoi (int n, char A, char B, char C){
        if (n==1){ //end condition
            move(A,B);//‘move’ can be defined to be a print function
        }
        else{
            Hanoi(n-1,A,C,B);//move sub [n-1] pans from A to B
            move(A,C);//move the bottom(max) pan to C
            Hanoi(n-1,B,A,C);//move sub [n-1] pans from B to C
        }
    }*/
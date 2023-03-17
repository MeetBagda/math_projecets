import java.util.Scanner;

public class EulersMethodModified {

    public static double f(double x , double y){
        // Enter the Differential equation
        return x * Math.sqrt(y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x0;
        double xMax;
        double y0;
        double h;

        System.out.print("Enter the initial value of X : ");
        x0 = sc.nextDouble();
        System.out.print("Enter the max value of X : ");
        xMax = sc.nextDouble();
        System.out.print("Enter the initial value of Y : ");
        y0 = sc.nextDouble();
        System.out.println("Enter the step size : ");
        h = sc.nextDouble();

        // Number of steps
        int noOfSteps = (int) Math.ceil((xMax - x0) / h);

        double x[] = new double[noOfSteps + 1];
        double y[] = new double[noOfSteps + 1];

        // set the first initial value
        x[0] = x0;
        y[0] = y0;

        for(int i=0; i<noOfSteps; i++){
            x[i+1] = x[i] + h; // FORMULA (Xn+1 = Xn + h)
            y[i+1] = y[i] + h * f(x[i],y[i]); // FORMULA (Yn+1 = Yn + h * f(x,y))
        }

        System.out.printf("X(0) = %.4f \t\t Y(0) = %.4f \n" , x[0] , y[0]);
            
        for(int i=0; i<noOfSteps; i++){
            System.out.printf("X(%d) = %.4f \t\t Y(%.4f) = %.4f \n" , i+1 , x[i+1] , x[i+1] ,  y[i+1]);
        }
    }
}

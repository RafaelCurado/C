import java.util.Scanner;

public class ex01 {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        double input1 = 0, input2 = 0, result = 0; 
        String operator = null;

        System.out.printf("Operation:(number op number)");

        if (!input.hasNextDouble()) {
            System.out.println("ERROR: read number failure!");
            System.exit(1);
        } else {
            input1 = input.nextDouble();
        }

        if(!input.hasNext()){
            System.out.println("ERROR: read operator failure!");
            System.exit(1);
        } else {
            operator = input.next();
        }

        if (!input.hasNextDouble()) {
            System.out.println("ERROR: read number failure!");
            System.exit(1);
        } else {
            input2 = input.nextDouble();
        }

        switch(operator) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            default:
                System.out.println("ERROR: invalid operator");
                System.exit(1);
        }
        System.out.printf("%f %s %f = %f\n", input1, operator, input2, result);
    }
}



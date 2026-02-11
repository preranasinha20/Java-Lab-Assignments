import java.util.Scanner;
public class Calculator
{
    double num1, num2;
    int choice;
    public double addNums(double n1, double n2)
    {
        return n1+n2;
    }
    public double subtractNums(double n1, double n2)
    {
        return n1-n2;
    }
    public double multiplyNums(double n1, double n2)
    {
        return n1 * n2;
    }
    public double divideNums(double n1, double n2)
    {
        return n1 / n2;
    }
    public double modNums(double n1, double n2)
    {
        return n1 % n2;
    }

    public static void main(String[] args) 
    {
        Calculator c = new Calculator();
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("MENU:\n0) Exit\n1) ADD\n2) Subtract\n3) Multiply\n4) Divide\n5) Remainder\nEnter choice:");
            c.choice=sc.nextInt();
            if(c.choice==0)
            {
                System.out.println("Exiting...");
                System.exit(0);
            }
            
            System.out.println("Enter first number:");
            c.num1 = sc.nextDouble();
            System.out.println("Enter second number:");
            c.num2 = sc.nextDouble();

            switch(c.choice)
            {
                
                case 1:
                    System.out.println("Sum: "+ c.addNums(c.num1,c.num2));
                    break;
                case 2:
                    System.out.println("Difference: "+ c.subtractNums(c.num1,c.num2));
                    break;
                case 3:
                    System.out.println("Multiply: "+ c.multiplyNums(c.num1,c.num2));
                    break;            
                    case 4:
                    System.out.println("Quotient: "+ c.divideNums(c.num1,c.num2));
                    break;
                case 5:
                    System.out.println("Remainder: "+ c.modNums(c.num1,c.num2));
                    break;
                default:
                    System.out.println("Wrong Choice");

            }
        
    }  while(true);
}
}
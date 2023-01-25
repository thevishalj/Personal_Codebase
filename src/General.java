import java.util.Scanner;

public class General {
    public static void main(String[] args)
    {
        int a, b;
        a= 5; b = 10;
        System.out.println(a<b?("This is true"):"(This is false my nigga)");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter you name MF ");

        String name = input.next();
        System.out.println("Seriously! " + name + " is you name MF?");

        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        System.out.print("In English, vowels are ");
        for(char i: vowels)
        {
            System.out.print(i + " ");
        }

    }
}

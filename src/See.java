import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class See {
    public static void seeList() throws IOException {
        int num = 1;
        for (String str : Main.Data()) {
            System.out.println(num+": "+str);
            num+=1;
        }
        System.out.println("Press 0 to exit!!!");
        Scanner input = new Scanner(System.in);
        try {
            int exit = input.nextInt();
            if (exit != 0 ) {
                System.out.println("u should input 0 to exit");
            } else {
                Main.mainMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("u should input 0 to exit");
        }
    }
}

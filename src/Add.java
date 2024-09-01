import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Add {
    public static void addTask() throws IOException {

        int isContinue = 1;
        while (isContinue == 1) {
            Scanner input = new Scanner(System.in);
            System.out.print("Add something u want to do: ");
            String task = input.nextLine();

            try {
                BufferedWriter write_file = new BufferedWriter(new FileWriter("D:/Workspace/Java/Todo_List/db/DB.txt", true));
                write_file.write(task);
                write_file.newLine();
                write_file.close();
            } catch (IOException e) {
                System.out.println("got error");
            }
            System.out.print("Do u want add more? (1: Yes  0: No) ");
            boolean isCorrect = false;
            while (!isCorrect) {
                try {
                    int choose = input.nextInt();
                    if (choose != 0 && choose != 1) {
                        System.out.println("u should input 0 or 1");
                    } else {
                        isCorrect = true;
                        if (choose == 0) {
                            isContinue = 0;
                            Main.mainMenu();
                            break;
                        } else {
                            break;
                        }

                    }
                } catch (InputMismatchException e) {
                    System.out.println("u should input 0 or 1");
                }
            }
        }
    }
}

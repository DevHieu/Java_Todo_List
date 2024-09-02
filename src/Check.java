import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {

    public static void CheckTask() throws IOException {
        boolean isStop = false;
        while (!isStop) {
            System.out.print("Input task id u want check done: ");
            Scanner id = new Scanner(System.in);
            int input = id.nextInt();

            try {
                FileWriter check = new FileWriter("done.txt", true);
                BufferedWriter writeFile = new BufferedWriter(check);
                writeFile.write(input+ "|"); //the "|" is for regex when I handle print all the task done
                writeFile.close();
                check.close();
            } catch (IOException e) {
                System.out.println("got IOException error");
            }

            System.out.println("Do u want check more? (1: Yes  0: No) ");
            boolean isCorrect = false;

            try {
                Scanner bl = new Scanner(System.in);
                int choose = bl.nextInt();
                if (choose != 0 && choose != 1) {
                    System.out.println("u should input 0 or 1");
                } else {
                    isCorrect = true;
                    if (choose == 0) {
                        isStop = true;
                        Main.mainMenu();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("u should input 0 or 1");
            }
        }

    }
    public static String ListDoneTask() throws FileNotFoundException {
        //Return to an array which have all id the task done
        File check = new File("done.txt");
        String data = "";
        Scanner myReader = new Scanner(check);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();
        return Arrays.toString(data.split(" "));
    }
}

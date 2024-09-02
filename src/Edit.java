import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit {
    public static void EditTask() throws IOException {
        boolean isStop = false;
        while (!isStop) {
            try {
                boolean isAccept = false;
                int id = 1;
                while (!isAccept) {
                    System.out.print("Input task id u want edit: ");
                    Scanner scanId = new Scanner(System.in);
                    int i = scanId.nextInt();
                    if (i>0 && i <=Main.Data().length) {
                        id = i;
                        isAccept = true;
                    } else {
                        System.out.println("id ur input is greater than or less than item in array");
                        System.out.println("Try again!!!");
                    }
                }
                System.out.print("Change to: ");
                Scanner scanChange = new Scanner(System.in);
                String change = scanChange.nextLine();

                FileWriter temp = new FileWriter("temp.txt", true);
                BufferedWriter buffereTemp = new BufferedWriter(temp);

                int current = 1;
                for (String str : Main.Data()) {
                    if (current != id) {
                        buffereTemp.write(str);
                    } else {
                        buffereTemp.write(change);
                    }
                    buffereTemp.newLine();
                    current++;
                }

                buffereTemp.close();
                temp.close();

                File db = new File("DB.txt");
                if (db.delete()) { //Delete data current file
                    File newFile = new File("DB.txt"); //Create a blank file have name like data file's name
                    File tempFile = new File("temp.txt"); //Temp file
                    if (tempFile.renameTo(newFile)) {  //Change the temp file's name to blank file's name
                        System.out.println("Change successfully");
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

            } catch (IOException e) {
                System.out.println("got IOException error");
            }
        }
    }
}

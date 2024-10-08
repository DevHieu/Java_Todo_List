import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Delete {
    public static void DeleteTask() {
        boolean isStop = false;
        while (!isStop) {
            try {
                boolean isAccept = false;
                int id = 1;

                //Check id if the id user input isn't in range of data's length
                while (!isAccept) {
                    System.out.print("Input task id u want delete: ");
                    Scanner scanId = new Scanner(System.in);
                    int i = scanId.nextInt();
                    System.out.println(Main.Data().length);
                    if (i>0 && i <=Main.Data().length) {
                        id = i;
                        isAccept = true;
                    } else {
                        System.out.println("id ur input is greater than or less than item in array");
                        System.out.println("Try again!!!");
                    }
                }
                int current = 1;
                BufferedWriter BufferTemp = new BufferedWriter(new FileWriter("temp.txt", true));

                for (String str : Main.Data()) {
                    if (current == id) {
                        current+=1;
                        continue;
                    } else {
                        BufferTemp.write(str);
                        BufferTemp.newLine();
                    }
                    current+=1;
                }
                BufferTemp.close();

                File curFile = new File("DB.txt");
                if (curFile.delete()) {  //Delete data current file
                    File cur = new File("DB.txt"); //Create a blank file
                    File tempFile = new File("temp.txt"); //temp file
                    if (tempFile.renameTo(cur)) { //Change the temp file's name to blank file's name
                        System.out.println("Delete successfully");

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
                    } else {
                        System.out.println("cant delete");
                    }
                }


            } catch (InputMismatchException e) {
                System.out.print("got error");
            } catch (IOException e) {
                System.out.print("got IOException error");
            }
        }
    }
}

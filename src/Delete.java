import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Delete {
    public static void DeleteTask() {
        System.out.print("Input task id u want delete: ");
        try {
            Scanner inputId = new Scanner(System.in);
            int id = inputId.nextInt();
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
            if (curFile.delete()) {
                File cur = new File("DB.txt");
                File tempFile = new File("temp.txt");
                if (tempFile.renameTo(cur)) {
                    System.out.println("Delete successfully");
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

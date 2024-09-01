import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String[] Data() throws IOException {
        List<String> ListArray = new ArrayList<String>();
        BufferedReader read_file = new BufferedReader(new FileReader("DB.txt"));
        String line = read_file.readLine();

        while (line != null) {
            ListArray.add(line);
            line = read_file.readLine();
        }
        read_file.close();

        return ListArray.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, welcome to ToDo List app");
        System.out.println(" ");
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        Data();

        Scanner userImport = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1: See list ");
        System.out.println("2: Add");
        System.out.println("3: Check done");
        System.out.println("4: Remove");
        System.out.println("0: Out");
        int choose = userImport.nextInt();

        switch (choose) {
            case 1:
                See.seeList();
                break;
            case 2:
                Add.addTask();
                break;
            case 4:
                Delete.DeleteTask();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}


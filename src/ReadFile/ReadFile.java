package ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadFile {

    public LinkedList<String> ReturnData() {
        String data;
        LinkedList<String> buffer = new LinkedList<>();
        try {
            File Myobj = new File("students-multiple-scores-txt");
            try (Scanner Myreader = new Scanner(Myobj);) {
                while (Myreader.hasNextLine()) {
                    data = Myreader.nextLine();
                    buffer.add(data);
                }
                Myreader.close();
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("An error occurred");
        }
        return buffer;
    }

    public void DisplayList() {
        ReadFile Myobj = new ReadFile();
        LinkedList<String> buffer = Myobj.ReturnData();
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println(buffer.get(i));
        }
    }
}

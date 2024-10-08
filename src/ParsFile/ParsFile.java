package ParsFile;

import ReadFile.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;

public class ParsFile extends ReadFile {

    LinkedList<String> Getnames = new LinkedList<>();
    LinkedList<Float> Getgrade = new LinkedList<>();

    public LinkedList<String> ReturnNames() {
        LinkedList<String> buffer = ReturnData();

        for (int i = 0; i < buffer.size(); i++) {
            SimpleEntry<String, Float> result = return_names(buffer.get(i));
            Getnames.add(result.getKey());
        }
        return (Getnames);
    }

    public LinkedList<Float> Returngrade() {
        LinkedList<String> buffer = ReturnData();

        for (int i = 0; i < buffer.size(); i++) {
            SimpleEntry<String, Float> result = return_names(buffer.get(i));
            Getgrade.add(result.getValue());
        }
        return (Getgrade);
    }

    // mohammed 79 22 90
    public SimpleEntry<String, Float> return_names(String node) {
        String[] bufferList = node.split(" ");
        String save_name = null;
        float sum = 0;
        for (String name : bufferList) {
            boolean check = false;
            for (int j = 0; j < name.length(); j++) {
                if (!Character.isDigit(name.charAt(j))) {
                    check = true;
                }
            }
            if (check) {
                save_name = name;
            } else {
                String number = name;
                sum += Integer.parseInt(number) / 3.00;
            }
        }
        return new SimpleEntry<>(save_name, sum);
    }
}

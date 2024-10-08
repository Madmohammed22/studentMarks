package main;

import ParsFile.ParsFile;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {

    @SuppressWarnings("default")
    public static void main(String[] args) {
        System.out.println();
        ParsFile result = new ParsFile();
        LinkedList<String> sortedName = result.ReturnNames()
        .stream().sorted().collect(Collectors
        .toCollection(LinkedList::new));
        LinkedList<Float> grades = result.Returngrade();
        int i = 0;
        while (i < grades.size() | i < sortedName.size()) {
            System.out.println(sortedName.get(i) + " - " + "Average mark: " + grades.get(i));
            i++;
        }

    }
}

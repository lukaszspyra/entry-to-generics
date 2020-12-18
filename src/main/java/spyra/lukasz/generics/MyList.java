package spyra.lukasz.generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyList {


    public static void main(String[] args) {

        List list = new ArrayList<>();
        list.add("Lukasz B.");
        list.add("Lukasz P.");
        list.add("Lukasz S.");

        System.out.println(list);

//        String name = list.get(1); //younotcompile
        String name2 = (String) list.get(1);
        String name3 = "" + list.get(1);
        System.out.println(name2 + " " + name3);

        list.add(LocalDate.now());
        System.out.println(list);

    }

}

package spyra.lukasz.generics;

import java.util.ArrayList;
import java.util.List;

public class TigerMyList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Lukasz B.");
        list.add("Lukasz P.");
        list.add("Lukasz S.");

        System.out.println(list);

        String name = list.get(1); //younotcompile
        //String name2 = (String) list.get(1);
        String name3 = "" + list.get(1);
        System.out.println(name + " " + name3);

//            list.add(LocalDate.now()); finally we can not put it in
        System.out.println(list);

        List<Integer> shoeSizes = new ArrayList<Integer>();
//        shoeSizes.add("one");
        shoeSizes.add(40);
        shoeSizes.add(44);
        shoeSizes.add(42);

        for (Integer a : shoeSizes){
            if (a == 42){
                System.out.println("It contains the meaning of life");
                break;
            }
            System.out.println("It does not contain it");
        }




    }

}



package spyra.lukasz.comparison;

import java.util.ArrayList;
import java.util.List;

public class NonGeneric {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("some string");
        CharSequence s = list.get(0);

    }



}




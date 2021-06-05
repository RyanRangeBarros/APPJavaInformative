package com.example.mycurriculoappy.menulateral;


import com.example.mycurriculoappy.R;

import java.util.ArrayList;
import java.util.List;

public class MenuNec {

    public static final int HOME = 0;
    public static final int LAPTOP = 1;
    public static final int LOC = 2;

    public static List<ItensDoMenu> getMenuList() {

        List<ItensDoMenu> list = new ArrayList<>();
        list.add(new ItensDoMenu(R.drawable.ic_baseline_home_24, HOME, true));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_laptop_24, LAPTOP, false));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_location_on_24, LOC, false));


        return list;
    }
}

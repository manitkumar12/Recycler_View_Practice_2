package com.grademojo.recycler_view_practice;

/**
 * Created by sapling_a0 on 28/7/17.
 */

public class Recycler_view_getter_setter {


    public static final int LEAVE_CLICKED = 0;

    public static final int ABSENT_CLICKED = 1;

    public static final int PRESENT_CLICKED = 2;

    private int click_option;



    private String roll_no;

    private String name;








    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }






    public void setName(String name) {
        this.name = name;
    }


    public void setClick_option(int click_option) {
        this.click_option = click_option;
    }

    public int getClick_option() {
        return click_option;
    }




    public String getRoll_no() {
        return roll_no;
    }




    public String getName() {
        return name;
    }













}

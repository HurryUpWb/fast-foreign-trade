package com.fast.trade.entity.enums;

public enum MenuTypeEnum {

    /**
     *
     */
    PRIVATE_MENU(1,"私有目录","私有目录"),
    /**
     *
     */
    PUBLIC_MENU(2,"公共目录","公共目录"),
    ;


    int value;

    String name;

    String desc;



    MenuTypeEnum(int value, String name, String desc) {

        this.value = value;
        this.name = name;
        this.desc = desc;
    }



    public int getValue() {

        return value;
    }



    public void setValue(int value) {

        this.value = value;
    }



    public String getName() {

        return name;
    }



    public void setName(String name) {

        this.name = name;
    }



    public String getDesc() {

        return desc;
    }



    public void setDesc(String desc) {

        this.desc = desc;
    }
}

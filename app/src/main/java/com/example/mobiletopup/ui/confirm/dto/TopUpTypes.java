package com.example.mobiletopup.ui.confirm.dto;

import java.util.HashMap;

public enum TopUpTypes {
    PICK_UP_BY_AGENT(1),
    GO_TO_AGENT(2);

    public static HashMap< Integer, TopUpTypes > enum_typeHashMap = new HashMap<>();

    static {
        enum_typeHashMap.put(1 , PICK_UP_BY_AGENT);
        enum_typeHashMap.put(2 , GO_TO_AGENT);
    }

    public static TopUpTypes getEnumType(int index){
        return  enum_typeHashMap.get(index);
    }


    private int code;

    TopUpTypes(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

}

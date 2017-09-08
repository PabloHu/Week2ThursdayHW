package com.example.admin.week2thursdayhw;

import java.security.Timestamp;

/**
 * Created by Admin on 9/7/2017.
 */

public class KiwiObject {
    int KIWI_ID;
    String KIWI_FIRSTNAME;
    String KIWI_LASTNAME;
    int KIWI_CELL;
    String KIWI_NOTE;
    String KIWI_TIMESTAMP;


    public int getKIWI_ID() {
        return KIWI_ID;
    }

    public void setKIWI_ID(int KIWI_ID) {
        this.KIWI_ID = KIWI_ID;
    }

    public String getKIWI_FIRSTNAME() {
        return KIWI_FIRSTNAME;
    }

    public void setKIWI_FIRSTNAME(String KIWI_FIRSTNAME) {
        this.KIWI_FIRSTNAME = KIWI_FIRSTNAME;
    }

    public String getKIWI_LASTNAME() {
        return KIWI_LASTNAME;
    }

    public void setKIWI_LASTNAME(String KIWI_LASTNAME) {
        this.KIWI_LASTNAME = KIWI_LASTNAME;
    }

    public int getKIWI_CELL() {
        return KIWI_CELL;
    }

    public void setKIWI_CELL(int KIWI_CELL) {
        this.KIWI_CELL = KIWI_CELL;
    }

    public String getKIWI_NOTE() {
        return KIWI_NOTE;
    }

    public void setKIWI_NOTE(String KIWI_NOTE) {
        this.KIWI_NOTE = KIWI_NOTE;
    }

    public String getKIWI_TIMESTAMP() {
        return KIWI_TIMESTAMP;
    }

    public void setKIWI_TIMESTAMP(String KIWI_TIMESTAMP) {
        this.KIWI_TIMESTAMP = KIWI_TIMESTAMP;
    }

    @Override
    public String toString() {
        return  KIWI_ID +
                ", " + KIWI_FIRSTNAME +
                ", " + KIWI_LASTNAME +
                ", " + KIWI_CELL +
                ", " + KIWI_NOTE +
                ", " + KIWI_TIMESTAMP;
    }
}


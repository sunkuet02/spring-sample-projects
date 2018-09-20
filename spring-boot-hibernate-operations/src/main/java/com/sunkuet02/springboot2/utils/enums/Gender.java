package com.sunkuet02.springboot2.utils.enums;

public enum Gender {
    MALE (1),
    FEMALE (2);

    private final int code;

    private static final Gender[] ENUMS = Gender.values();

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static Gender get(int code) {
        return ENUMS[code - 1];
    }

}

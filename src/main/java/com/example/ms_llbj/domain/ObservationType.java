package com.example.ms_llbj.domain;

public enum ObservationType {
    TYPE_1(1),
    TYPE_2(2),
    TYPE_3(3);

    private final short code;

    ObservationType(int code) { this.code = (short) code; }
    public short getCode() { return code; }

    public static ObservationType fromCode(short code) {
        for (var t : values()) if (t.code == code) return t;
        throw new IllegalArgumentException("Invalid ObservationType code: " + code);
    }
}
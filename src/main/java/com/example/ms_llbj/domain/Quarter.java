package com.example.ms_llbj.domain;

public enum Quarter {
    Q1(1), Q2(2), Q3(3), Q4(4);

    private final short code;
    Quarter(int code) { this.code = (short) code; }
    public short getCode() { return code; }

    public static Quarter fromCode(short code) {
        for (var q : values()) if (q.code == code) return q;
        throw new IllegalArgumentException("Invalid Quarter code: " + code);
    }
}

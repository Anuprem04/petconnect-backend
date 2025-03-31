package com.presidency.petconnect.entity;

public enum APPROVAL_STATUS {

    PENDING(0, "PENDING"),
    APPROVED(1, "APPROVED"),
    REJECTED(2, "REJECTED");

    private final int code;
    private final String label;

    APPROVAL_STATUS(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static APPROVAL_STATUS fromCode(int code) {
        for (APPROVAL_STATUS status : values()) {
            if (status.code == code) return status;
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static APPROVAL_STATUS fromLabel(String label) {
        for (APPROVAL_STATUS status : values()) {
            if (status.label.equalsIgnoreCase(label)) return status;
        }
        throw new IllegalArgumentException("Invalid status label: " + label);
    }
}


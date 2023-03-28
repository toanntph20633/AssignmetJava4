package com.example.assignmetjava4.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BrandStatus {
    ACTIVE(0), INACTIVE(1), DELETED(2);
    private int value;

    public static BrandStatus valueOf(int x) {
        for (BrandStatus e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}

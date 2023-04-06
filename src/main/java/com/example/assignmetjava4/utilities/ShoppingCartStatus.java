package com.example.assignmetjava4.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ShoppingCartStatus {
    CHOTHANHTOAN(0), DATHANHTOAN(1), DAHUY(2);
    private int value;

    public static ShoppingCartStatus valueOf(int x) {
        for (ShoppingCartStatus e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}

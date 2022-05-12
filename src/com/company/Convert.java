package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

 enum Convert {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    public int value;

    Convert(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Convert e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 101)) {
            throw new IllegalArgumentException(number + " is not in range (0,101]");
        }

        List romanNumerals = Convert.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Convert currentSymbol = (Convert) romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}


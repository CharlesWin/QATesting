package com.galaykovskiy.tools;

import java.util.List;
import java.util.Map;

public class Caster {
    @SuppressWarnings("uncheked")
    public static <T extends List<?>> T castObjectToList(Object obj) {
        return (T) obj;
    }

    @SuppressWarnings("uncheked")
    public static <T extends Map<?, ?>> T castObjectToMap(Object obj) {
        return (T) obj;
    }
}

package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    public static String joining(String delimiter, Object... contents) {
        return Stream.of(contents).map(Object::toString).collect(Collectors.joining(delimiter));
    }
}

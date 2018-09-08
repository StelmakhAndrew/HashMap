package HashMap;

import java.util.Objects;

public class Pair {
    private final Integer key;
    private final Long value;

    Pair(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Pair point = (Pair) obj;
        return key.equals(point.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key) * 31;
    }

    public String toString() {
        return key + " = " + value;
    }
}


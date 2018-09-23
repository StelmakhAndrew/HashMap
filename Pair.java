import java.util.Objects;

public class Pair {
    private final int key;
    private final long value;

    Pair(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Pair point = (Pair) obj;
        return key == (point.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key) * 31;
    }

    public String toString() {
        return key + " = " + value;
    }
}


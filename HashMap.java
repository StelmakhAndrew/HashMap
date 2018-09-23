import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class HashMap {
    private static final int STARTED_LENGTH_MAP = 16;
    private int sizeMap;
    private Pair[] hashMap;
    private int currentSize;


    public HashMap(int size) {
        if (size < 0) throw new NegativeArraySizeException("Negative size");
        hashMap = new Pair[size];
        sizeMap = size;
    }

    public HashMap() {
        sizeMap = STARTED_LENGTH_MAP;
        hashMap = new Pair[STARTED_LENGTH_MAP];
    }

    @Override
    public String toString() {
        return "hashMap=" + Arrays.toString(hashMap);
    }

    public int size() {
        return currentSize;
    }

    public Pair get(int key) {
        int basket = Math.abs(Objects.hash(key) * 31 % sizeMap);
        int startBasket = basket;
        do {
            if (hashMap[basket] == null) {
                throw new NoSuchElementException("Key not found");
            }

            if ((hashMap[basket]).getKey() == (key)) {
                return hashMap[basket];
            }
            basket++;

            if (basket == sizeMap - 1) {
                basket = 0;
            }

        } while (startBasket != basket);
        throw new NoSuchElementException("Key not found");
    }


    public boolean put(int key, long elem) {
        Pair pair = new Pair(key, elem);
        int basket = Math.abs(pair.hashCode() % sizeMap);
        int startBasket = basket;
        do {
            if (hashMap[basket] == null) {
                hashMap[basket] = pair;
                currentSize++;
                return true;
            }
            if (hashMap[basket].equals(pair)) {
                return false;
            }
            basket++;
            if (basket == sizeMap - 1) {
                basket = 0;
            }
        } while (startBasket != basket);
        resize();
        return put(key, elem);
    }

    private void resize() {
        Pair[] temp = hashMap;
        sizeMap = (int) (currentSize * 1.5);
        hashMap = new Pair[(sizeMap)];
        currentSize = 0;
        for (Pair pair : temp) {
            put(pair.getKey(), pair.getValue());
        }
    }
}
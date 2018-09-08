package HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap myHash = new HashMap();
        System.out.println(myHash.put(Integer.MAX_VALUE, 100)
        );
        myHash.put(34,234);
        System.out.println( myHash.get(34));
        System.out.println(myHash);

        System.out.println(myHash.get(Integer.MAX_VALUE));

    }
}

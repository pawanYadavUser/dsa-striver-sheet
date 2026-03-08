public class test {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true (cached values -128 to 127)

        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y); // false (different objects)

        System.out.println(x.equals(y));
    }

}

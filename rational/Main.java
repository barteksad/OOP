package rational;

public class Main {

    public static boolean test1()
    {
        System.out.println("Test 1");
        Rational a = new Rational(11, 12);
        Rational b = new Rational(17, 48);
        Rational c = new Rational(-10, 10);
        Rational d = new Rational(0, 19);
        Rational e = new Rational(3333, 2222);

        Rational result = a.add(b).add(c).add(d).add(e);

        Rational proper_result = new Rational(85, 48);
        return (proper_result.toString() == result.toString());
    }

    public static boolean test2()
    {
        System.out.println("Test 2");
        Rational a = new Rational(11, 12);
        Rational b = new Rational(17, 48);
        Rational c = new Rational(-10, 10);
        Rational d = new Rational(1, 19);
        Rational e = new Rational(3333, 2222);

        Rational result = a.divide(b).divide(c).divide(d).divide(e);
        System.out.println(result.toString());
        Rational proper_result = new Rational(85, 48);
        return (proper_result.toString() == result.toString());
    }

    public static void main(String[] args)
    {
        if(test1())
            System.out.println("OK");

        test2();
    }
}

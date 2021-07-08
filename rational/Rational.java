package rational;

public class Rational
{
    private int stored_nominator;
    private int stored_denominator;

//  konstruktor dla liczby całkowitej
    public Rational(int n)
    {
        stored_nominator = n;
        stored_denominator = 1;
    };

    public static Rational zero()
    {
        return new Rational(0);
    }

    public static Rational one()
    {
        return new Rational(1);
    }

//  algorytm euklidesa   znajdujący NWD, potrzebne do skracania ułamka
    private static int gcd(int p, int q)
    {
        int pom;
        while(q != 0)
        {
            pom = p % q;
            p = q;
            q = pom;
        }
        return p;
    }

//  konstruktor dla ułamka
    public Rational(int p, int q)
    {
        try {
            if (q == 0)
                throw new DivisionByZero();
        } catch (Exception e)
            {
                System.out.println("Division by zero!");
            }
        int GCD = Rational.gcd(p, q);
        stored_nominator = p / GCD;
        stored_denominator = q / GCD;
    }

    public Rational add(Rational x)
    {
        if (x.stored_denominator == this.stored_denominator)
            return new Rational(x.stored_nominator + this.stored_nominator, this.stored_denominator);
        else
        {
            int new_nominator = this.stored_nominator * x.stored_denominator + x.stored_nominator * this.stored_denominator;
            int new_denominator = x.stored_denominator * this.stored_denominator;
            return new Rational(new_nominator, new_denominator);
        }
    }

    public Rational subtract(Rational x)
    {
        return this.add(new Rational(-x.stored_nominator, x.stored_denominator));
    }

    public Rational inverse()
    {
        if (this.stored_nominator == 0)
            return Rational.zero();
        else
            return new Rational(this.stored_denominator, this.stored_nominator);
    }

    public Rational multiply(Rational x)
    {
        int new_nominator = x.stored_nominator * this.stored_nominator;
        int new_denominator = x.stored_denominator * this.stored_denominator;
        return new Rational(new_nominator, new_denominator);
    }


    public Rational divide(Rational x)
    {
        try {
            if (x.stored_nominator == 0)
                throw new DivisionByZero();
        } catch (Exception e)
        {
            System.out.println("Division by zero!");
        }
        return this.multiply(x.inverse());
    }

    public Rational opposite()
    {
        return new Rational(- this.stored_nominator, this.stored_nominator);
    }

    public int sign()
    {
        if (this.stored_nominator == 0)
            return 0;
        else if (this.stored_nominator > 0)
            return 1;
        else
            return -1;
    }

    public int numerator()
    {
        return this.stored_nominator;
    }

    public int denominator()
    {
        return this.stored_denominator;
    }

    public int compare(Rational x)
    {
        int sign = this.subtract(x).sign();
        return sign;
    }

    public String toString()
    {
        int sign = this.sign();
        char sign_char;
        if (sign > 0)
            sign_char = '+';
        else if (sign < 0)
            sign_char = '-';
        else
            sign_char = ' ';
        String s = String.format("%c%d/%d", sign, this.stored_nominator, this.stored_denominator);
        return s;
    }
};

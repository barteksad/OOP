import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Hello, World!");
    }

    @Test
    public void test1()
    {
        BitStack stos = new BitStack();

        stos.push(1);
        stos.push(2);
        stos.push(3);
        stos.push(4);
        stos.push(5);
        stos.push(6);
        stos.push(7);
        stos.push(8);

        stos.complement();
        assertEquals(~8, stos.head());
    }

    @Test
    public void test2()
    {
        BitStack stos = new BitStack();

        stos.push(1);
        stos.push(2);
        stos.push(3);
        stos.push(4);
        stos.push(5);
        stos.push(6);
        stos.push(7);
        stos.push(8);

        stos.complement();
        stos.and();
        stos.or();
        stos.xor();
        assertEquals((((~8) & 7) | 6) ^ 5, stos.head());
    }
}

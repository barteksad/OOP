public class App {
    public static void main(String[] args) throws Exception 
    {
        int[] f_x = {1,2,3};
        int[] f_y = {1,2,2};
        Funkcja f = new Funkcja(f_x, f_y);

        int[] g_x = {1,2,3};
        int[] g_y = {3,1,1};
        Funkcja g = new Funkcja(g_x, g_y);

        System.out.println(Funkcja.EarthMover(f, g));
        System.out.println(Funkcja.HammingDistance(f, g));
    }
}

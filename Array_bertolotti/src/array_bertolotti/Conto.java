package array_bertolotti;

public class Conto extends Thread {

    private int n;
    private int k;
    private int i;
    private int[] v;
    private int[] v2;
    private int[] v3;

    public Conto(int n, int k, int i, int[] v) {
        this.v = v;
        this.n = n;
        this.k = k;
        this.i = i;
        this.v2 = new int[(n / k)];
        this.v3 = new int[(n / k)];

    }

    public String getV3() {
        String s = "Array " + i + " :";
        for (int j = 0; j < v3.length; j++) {
            s += v3[j] + " ";
        }

        return s;
    }

    public String getV2() {
        String s = "";
        for (int j = 0; j < v2.length; j++) {
            s += v2[j] + " ";
        }

        return s;
    }

    @Override
    public void run() {
        int x = 0;
        for (int j = (int) ((n / k) * i); j < (int) ((n / k)); j++) {
            v3[x] = v[j];
            v2[x] = (int) Math.sqrt(v[j]) + n / k;
            x++;
        }
    }
}

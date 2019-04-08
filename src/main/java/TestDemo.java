import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/3/20 10:28
 * description:
 */
public class TestDemo {
    public BigInteger sum(int i, int y) {
        if (i == y) {
            return BigInteger.valueOf(y);
        }
        return BigInteger.valueOf(i).add(sum(i - 1, y));
    }

    public int sum2(int i, int y) {
        if (i == y) {
            return y;
        }
        return i + sum2(i - 1, y);
    }

    public static void main(String[] args) {
        TestDemo test = new TestDemo();
        try {
            System.out.println(test.sum(100, 2));
            System.out.println(test.sum2(100, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

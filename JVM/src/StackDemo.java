import java.util.concurrent.TimeUnit;

public class StackDemo {

    public static void test01(){
        System.out.println("222222");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("333333");
    }

    public static void main(String[] args) {
        System.out.println("111111");
        test01();
        System.out.println("44444");
    }
}

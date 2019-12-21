
public class HelloJVM {
    public static void main(String[] args) {
       /* Object object=new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println("-------------------------");

        HelloJVM helloJVM=new HelloJVM();
        System.out.println(helloJVM.getClass().getClassLoader().getParent().getParent());
        System.out.println(helloJVM.getClass().getClassLoader().getParent());
        System.out.println(helloJVM.getClass().getClassLoader());
*/

       Thread t1=new Thread();
       t1.start();
       //t1.start();   java.lang.IllegalThreadStateException

    }
}

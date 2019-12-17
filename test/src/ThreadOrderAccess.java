/*三个线程启动(顺序调用)，要求如下：
 AA打印5次，BB打印10次，CC打印15次
 接着
 AA打印5次，BB打印10次，CC打印15次
......来10轮
*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int flag=1;
    private Lock lock=new ReentrantLock();

    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();


    public  void print5() throws InterruptedException {
        lock.lock();  //上锁
        try {
            //判断
        while (flag!=1){
            c1.await();
        }
        //干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=2;
             c2.signal();
        } finally {
            lock.unlock();  //释放锁
        }
    }

    public  void print10() throws InterruptedException {
        lock.lock();  //上锁
        try {
            //判断
            while (flag!=2){
                c2.await();
            }
            //干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=3;
            c3.signal();
        } finally {
            lock.unlock();  //释放锁
        }
    }

    public  void print15() throws InterruptedException {
        lock.lock();  //上锁
        try {
            //判断
            while (flag!=3){
                c3.await();
            }
            //干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=1;
            c1.signal();
        } finally {
            lock.unlock();  //释放锁
        }
    }
}


public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
         new Thread(()->{
             for (int i = 1; i <=10 ; i++) {
                 try {
                     shareResource.print5();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         },"A").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareResource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareResource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}

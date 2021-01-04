import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPrint {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            CountDownLatch count = new CountDownLatch(4);
            AlternPrint print = new AlternPrint();
            new Thread(() -> {
                try{
                    for(int i = 0; i<n; i++){
                        print.printA();
                    }
                } finally{
                    count.countDown();
                }
            }).start();

            new Thread(new Runnable(){
                public void run(){
                    try{
                        for(int i = 0; i<n; i++){
                            print.printB();
                        }
                    } finally{
                        count.countDown();
                    }
                }
            }).start();

            new Thread(new Runnable(){
                public void run(){
                    try{
                        for(int i = 0; i<n; i++){
                            print.printC();
                        }
                    } finally{
                        count.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable(){
                public void run(){
                    try{
                        for(int i = 0; i<n; i++){
                            print.printD();
                        }
                    } finally{
                        count.countDown();
                    }
                }
            }).start();
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}

class AlternPrint{
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    private int number = 1;

    void printA(){
        lock.lock();
        try{
            if(number != 1){
                conditionA.await();
            }
            System.out.print("A");
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    void printB(){
        lock.lock();
        try{
            if(number != 2){
                conditionB.await();
            }
            System.out.print("B");
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    void printC(){
        lock.lock();
        try{
            if(number != 3){
                conditionC.await();
            }
            System.out.print("C");
            number = 4;
            conditionD.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    void printD(){
        lock.lock();
        try{
            if(number != 4){
                conditionD.await();
            }
            System.out.print("D");
            number = 1;
            conditionA.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
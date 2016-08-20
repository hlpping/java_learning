package cn.test.bigfile;
import java.util.HashMap;  
import java.util.Map;  
import java.util.concurrent.CountDownLatch;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.locks.Condition;  
import java.util.concurrent.locks.Lock;  
import java.util.concurrent.locks.ReentrantLock;  

/*
 题目：

要求用三个线程，按顺序打印1,2,3,4,5.... 71,72,73,74, 75.

线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推, 直到线程3打印到75。

分析：感觉出题人是要考察一下你是否能够很好的控制多线程，让他们有序的进行。

1、线程池：3个线程，需要使用并发库的线程池

2、锁（lcok）：在打印的时候，只允许一个线程进入，其他的线程等待
 */
public class NumberPrinter {  
 
    private Lock lock = new ReentrantLock();  
 
    private Condition c1 = lock.newCondition();  
    private Condition c2 = lock.newCondition();  
    private Condition c3 = lock.newCondition();  
 
    private Map<Integer, Condition> condtionContext =   
        new HashMap<Integer, Condition>();  
 
    public NumberPrinter() {  
        condtionContext.put(Integer.valueOf(0), c1);  
        condtionContext.put(Integer.valueOf(1), c2);  
        condtionContext.put(Integer.valueOf(2), c3);  
    }  
      
    private int count = 0;     
      
    public void print(int id) {  
        lock.lock();  
        try {  
            while(count*5 < 75) {  
                int curID = calcID();  
                if (id == curID) {  
                    for (int i = 1; i<=5; i++) {  
                        System.out.print(count*5 +i+ ",");  
                    }  
                    System.out.println();  
                    count++;  
                    int nextID = calcID();  
                    Condition nextCondition = condtionContext.get(  
                            Integer.valueOf(nextID));  
                    //通知下一线程  
                    nextCondition.signal();  
                } else {  
                    Condition condition = condtionContext.get(  
                            Integer.valueOf(id));  
                    condition.await();  
                }  
            }  
            //通知线程结束  
            for(Condition c : condtionContext.values()) {  
                c.signal();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            lock.unlock();  
        }  
    }  
      
    private int calcID() {  
        // TODO Auto-generated method stub  
        return count % 3;  
    }  
 
 
    /**  
     * @param args  
     */ 
    public static void main(String[] args) {  
        ExecutorService executor = Executors.newFixedThreadPool(3);  
        final CountDownLatch latch = new CountDownLatch(1);     
        final NumberPrinter printer = new NumberPrinter();   
        for (int i = 0; i < 3; i++) {     
            final int id = i;  
            executor.submit(new Runnable() {  
                @Override 
                public void run() {  
                    // TODO Auto-generated method stub  
                    try {  
                        latch.await();  
                    } catch (InterruptedException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }  
                    printer.print(id);  
                }  
            });  
        }  
        System.out.println("三个任务开始顺序打印数字。。。。。。");   
        latch.countDown();  
        executor.shutdown();  
    }  
} 
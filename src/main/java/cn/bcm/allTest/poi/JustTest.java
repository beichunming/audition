package cn.bcm.allTest.poi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName JustTest
 * @Author beichunming
 * @Date 2018/11/20 下午12:37
 */
public class JustTest {
    private static ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {

        final Map<String, Integer> map = new HashMap<String, Integer>(4);

        CyclicBarrier cb = new CyclicBarrier(4, new Runnable(){
            public void run() {
                Integer count1 = map.get("1");
                Integer count2 = map.get("2");
                Integer count3 = map.get("3");
                Integer count4 = map.get("4");
                System.out.println("count= " + (count1 + count2 + count3 + count4));
            }
        });
//        new Thread(new TestThread(map, "1", cb,1000)).start();
//        new Thread(new TestThread(map, "2", cb,1000)).start();
//        new Thread(new TestThread(map, "3", cb,1000)).start();
//        new Thread(new TestThread(map, "4", cb,1000)).start();

        //线程池实现方式
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            Future<Integer> data = service.submit(new Callable<Integer>(){

                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i = 0; i < 1000; i++) {
                        sum += i;
                    }
                    return sum;
                }

            });
            try {
                sum += data.get().intValue();
            } catch (InterruptedException e) {

                e.printStackTrace();
            } catch (ExecutionException e) {

                e.printStackTrace();
            } finally {
                
            }
        }
        System.out.println("count===" + sum);
    }

}

class TestThread implements Runnable {

    private Map<String, Integer> map;
    private String type;
    private CyclicBarrier cb;
    private int n;
    public TestThread(Map<String, Integer> map, String type, CyclicBarrier cb, int n) {
        this.map = map;
        this.type =type;
        this.cb = cb;
        this.n = n;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += i;
        }
        map.put(type, sum);
        try {
            cb.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (BrokenBarrierException e) {

            e.printStackTrace();
        }

    }
}

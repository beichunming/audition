package cn.bcm.allTest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName IteratorTest2
 * @Author beichunming
 * @Date 2018/11/13 上午8:01
 */
public class IteratorTest2 {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        list.add("1");
        list.add("2");
        list.add("3");

        final Iterator<String> iter = list.iterator();

        // 存放10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行10个任务(我当前正在迭代集合（这里模拟并发中读取某一list的场景）)
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
//                    while (iter.hasNext()) {
//                        System.err.println(iter.next());
//                    }
                    for (String s : list) {
                        System.out.println(s);
                    }
                }
            });
        }

        // 执行10个任务
        for (int i = 0; i < 10; i++) {

            service.execute(new Runnable() {
                int count = -1;
                @Override
                public void run() {
//                    list.add("121");// 添加数据
                    //while (true) {
                        list.add(count++ + "");
                    //}
                }
            });
        }
        service.shutdown();
        System.err.println(Arrays.toString(list.toArray()));

    }
}

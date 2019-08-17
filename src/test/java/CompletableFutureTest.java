import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 强大的函数式异步编程辅助类
 */
public class CompletableFutureTest {

    /*Future是java5的添加类，用来描述一个异步的结果
    ，可以使用isDone检查结果是否完成
    ，或者使用get阻塞住调用线程，直到计算完成返回结果
    ，future只能通过阻塞和轮询的方式得到任务的结果，很不方便
    */
    @Test
    public void futureTest() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Integer> f = es.submit(() ->{
            // 长时间的异步计算
            // ……
            // 然后返回结果
            return 100;
        });

        f.get();
    }
}

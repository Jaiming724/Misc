package algs;

import java.util.List;
import java.util.concurrent.*;

public class SleepSort {
    private ExecutorService executorService;
    private List<Integer> list = new CopyOnWriteArrayList<>();


    public CompletableFuture<List<Integer>> sort(int[] arr) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return helper(arr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    private List<Integer> helper(int[] arr) throws InterruptedException {
        executorService = Executors.newFixedThreadPool(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(arr[finalI]);
                    list.add(arr[finalI]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        executorService.shutdown();
        while (executorService.awaitTermination(10, TimeUnit.MINUTES)) {
            break;
        }
        return list;
    }
}

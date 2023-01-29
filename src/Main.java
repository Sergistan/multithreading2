import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Создаю потоки...");

        Callable<Integer> myCallable1 = new MyCallable("Поток 1");
        Callable<Integer> myCallable2 = new MyCallable("Поток 2");
        Callable<Integer> myCallable3 = new MyCallable("Поток 3");
        Callable<Integer> myCallable4 = new MyCallable("Поток 4");

        Collection<Callable<Integer>> callableCollection = new ArrayList<>();
        callableCollection.add(myCallable1);
        callableCollection.add(myCallable2);
        callableCollection.add(myCallable3);
        callableCollection.add(myCallable4);

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Integer integerAny = threadPool.invokeAny(callableCollection);
        System.out.println();
        System.out.println("Количество приветствий самого быстрого потока: " + integerAny);
        System.out.println();

        Future<Integer> task = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);

        Integer integer = task.get();
        Integer integer2 = task2.get();
        Integer integer3 = task3.get();
        Integer integer4 = task4.get();

        int i = integer + integer2 + integer3 + integer4;

        System.out.println();
        System.out.println("Общее количестов приветствий: " + i);
        System.out.println("Завершаю все потоки.");
        threadPool.shutdown();

    }
}

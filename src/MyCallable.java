import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable <Integer> {
    protected String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
            for (int i = 0; i < 3; i++) {
                Thread.sleep(2500);
                System.out.println("Я " + name + ". Всем привет!");
                count++;
            }
        return count;
    }
}

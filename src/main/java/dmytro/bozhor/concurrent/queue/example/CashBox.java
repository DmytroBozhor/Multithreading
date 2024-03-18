package dmytro.bozhor.concurrent.queue.example;

public class CashBox {
    private static int idGenerator;
    private int id;

    public CashBox() {
        this.id = ++idGenerator;
    }
}

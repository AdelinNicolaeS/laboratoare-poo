package first;

public class OutTask implements Task {
    private String message;

    public void execute() {
        System.out.println(message);
    }

    public OutTask(String message) {
        this.message = message;
    }
}

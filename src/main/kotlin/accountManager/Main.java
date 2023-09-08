package accountManager;

public class Main {
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement(100); // 100개의 계좌를 관리한다.
        accountManagement.run();
    }
}
package accountManager;

import java.util.Scanner;

// 배열은 데이터를 숫자로 접근하기 위해서 사용
public class AccountManagement {
    private Account[] accountList;  // 계좌 목록 배열
    private int numAccounts;        // 계좌의 개수
    private Scanner scanner;        // 사용자 키보드 입력 객체

    // 최대 입력 가능한 계좌개수를 매개변수를 입력받는 생성자
    public AccountManagement(int maxSize) {
        accountList = new Account[maxSize]; // 계좌 목록 배열을 생성한다. (배열을 나중에 설정했음)
        numAccounts = 0;                    // 현재 생성된 계좌의 개수
        scanner = new Scanner(System.in);   // 사용자 입력 객체 생성
    }

    public void addAccount(String accountNumber, double balance) {
        // **코드 작성
        // 계좌번호와 초기 입금액을 입력 받고 계좌객체를 생성한 후 배열의 앞에서부터 가장 처음 빈 공간에 추가한다.
        // 단, 배열에 추가한 후 numAccounts를 증가시킨다.
        Account account = new Account(accountNumber, balance);
        accountList[numAccounts] = account;                     // accountList[인덱스로 numAccounts]
        System.out.println("계좌가 추가되었습니다.");
        System.out.println("추가된 계좌는: " + "\"" + accountList[numAccounts].getAccountNumber() + "\" 입니다" );           // 추가된 계좌 확인
        numAccounts++;
    }

    public void showAccountList() {
        // **코드 작성
        // 계좌 목록을 출력
        // 예시 출력 형태
        // ------------------------------------
        // 계좌번호: [계좌번호1], 잔액: [잔액1]
        // 계좌번호: [계좌번호2], 잔액: [잔액2]
        // ...
        // ------------------------------------
        for (Account account : this.accountList) {
            if (account != null) {
                System.out.println("-----------------------");
                System.out.println("계좌번호: [" + account.getAccountNumber() + "], 잔액: [" + account.getBalance() + "]");
                System.out.println("-----------------------");
            } else {
                System.out.println("더 이상 계좌가 없습니다.");
                break;
            }
        }
    }

        // for (int i = 0; i < numAccounts; i++) {
        //  System.out.println();
        // }

        // 예외처리 하는법도 해보기

    public void deposit(String accountNumber, double amount) {
        // **코드 작성
        // 계좌번호로 계좌객체를 찾고 입금 금액 만큼 잔액을 증가한다.
        // 단, findAccount 메서드를 이용하여 찾는다
        // 단, Account 클래스의 deposit 메서드를 사용하여야 한다.
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }
//    {
//        Account account = findAccount(accountNumber);
//        if (account != null) {
//            account.deposit(amount);
//    }

    public void withdraw(String accountNumber, double amount) {
        // **코드 작성
        // 계좌번호로 계좌객체를 찾고 출금 금액 만큼 잔액을 차감한다.
        // 단, findAccount 메서드를 이용하여 찾는다
        // 단, Account 클래스의 withdraw 메서드를 사용하여야 한다.
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    private Account findAccount(String accountNumber) {
        // **코드 작성
        // 계좌번호로 계좌객체를 찾아서 리턴하는 메서드 작성
        for (Account account : this.accountList) {
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

//        for (int i = 0; i < numAccounts; i++) {
//            if (accountList[1].getAccountNumber().equals(accountList)) {
//                return accountList[i];
//            }
//            return null;
//    }

    public void run() {
        while (true) {
            // UX 기능 구현
            System.out.println("\n=== 계좌 관리 프로그램 ===");
            System.out.println("1. 계좌 추가");
            System.out.println("2. 계좌 목록 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("0. 종료");
            System.out.print("원하는 기능을 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("계좌번호: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("잔액: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // 개행 문자 제거
                    addAccount(accountNumber, balance);
                    break;
                case 2:
                    showAccountList();
                    break;
                case 3:
                    System.out.print("계좌번호: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("입금액: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // 개행 문자 제거
                    deposit(accountNumber, depositAmount);
                    break;
                case 4:
                    System.out.print("계좌번호: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("출금액: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // 개행 문자 제거
                    withdraw(accountNumber, withdrawAmount);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}

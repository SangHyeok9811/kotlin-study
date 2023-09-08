package accountManager.kotlin
import java.util.*

class Account(
    var accountNumber: String,
    var accountOwner: String,
    var balance: Double
){
    fun deposit(amount: Double) {
        balance += amount
        if(balance > 0){
            println("계좌에 잔액이 \"$amount 원\" 추가되었습니다")
            println("잔액은 \"$balance 원\" 입니다.")
        } else {
            println("현재 잔액은 \"0원\" 입니다")
        }
    }

    fun withdraw(amount: Double){
        if(balance >= amount){
            balance -= amount
            println("계좌에 잔액이 \"$amount 원\" 차감되었습니다")
            println("잔액은 \"$balance 원\" 입니다.")
        } else {
            println("잔액이 부족합니다.")
        }
    }

//    fun accountTransfer(depositAccount: String, withdrawAccount: String, amount: Double){
//
//    }
}

class AccountManagement {
    var accountList = emptyMap<String, Account>()
    var numAccount: Int = 0
    val scanner = Scanner(System.`in`)

    fun addAccount(account: Account) {
        accountList += (account.accountNumber to account)
        numAccount++
        println("계좌가 추가되었습니다.")
        println("추가된 계좌는: " + "\"" + accountList[account.accountNumber] + "\" 입니다")
    }

    fun showAccountList() {
        accountList.values.forEach { account ->
            println("계좌번호: ${account.accountNumber}")
            println("예금주: ${account.accountOwner}")
            println("잔액: ${account.balance} 원")
        }
    }

    fun deposit(accountNumber: String, balance: Double) {
//        accountList[balance]
    }

    fun run() {
//        try {
//            while (true) {
//                println("\n=== 계좌 관리 프로그램 ===")
//                println("1. 계좌 추가")
//                println("2. 계좌 목록 조회")
//                println("3. 입금")
//                println("4. 출금")
//                println("5. 계좌이체")
//                println("0. 종료")
//                println("원하는 기능을 선택하세요: ")
//
//
//                var choice: Int? = scanner.nextInt()
//
//                if (choice == 0) {
//                    println("프로그램을 종료합니다.")
//                    scanner.close()
//                }
//                when (choice) {
//                    1->
//                }
//            }
//        }
    }
}
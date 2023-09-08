package test

fun main() {
        try {
            val result = 10 / 0
            println(result)
        } catch (e: ArithmeticException) {
            println("Cannot divide by zero")
        } finally {
            println("Finally block executed")
        }
    }
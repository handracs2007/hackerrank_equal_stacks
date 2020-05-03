import kotlin.math.min

// https://www.hackerrank.com/challenges/equal-stacks/problem

fun equalStacks(h1: Array<Int>, h2: Array<Int>, h3: Array<Int>): Int {
    val stack1 = h1.reversedArray().toMutableList()
    val stack2 = h2.reversedArray().toMutableList()
    val stack3 = h3.reversedArray().toMutableList()

    var sum1 = stack1.sum()
    var sum2 = stack2.sum()
    var sum3 = stack3.sum()

    while (sum1 != sum2 || sum2 != sum3) {
        val minSum = min(sum1, min(sum2, sum3))

        while (sum1 > minSum) {
            val value = stack1[stack1.size - 1]
            stack1.removeAt(stack1.size - 1)
            sum1 -= value
        }

        while (sum2 > minSum) {
            val value = stack2[stack2.size - 1]
            stack2.removeAt(stack2.size - 1)
            sum2 -= value
        }

        while (sum3 > minSum) {
            val value = stack3[stack3.size - 1]
            stack3.removeAt(stack3.size - 1)
            sum3 -= value
        }
    }

    return sum1
}

fun main() {
    println(
        equalStacks(
            intArrayOf(3, 2, 1, 1, 1).toTypedArray(),
            intArrayOf(4, 3, 2).toTypedArray(),
            intArrayOf(1, 1, 4, 1).toTypedArray()
        )
    )
}
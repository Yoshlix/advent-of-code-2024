import kotlin.math.abs

fun main() {
    val input = readInput("Day01")
    val leftList: MutableList<Int> = mutableListOf()
    val rightList: MutableList<Int> = mutableListOf()

    for (line in input) {
        leftList.add(line.split("   ")[0].toInt())
        rightList.add(line.split("   ")[1].toInt())
    }

    leftList.sort()
    rightList.sort()

    fun part1(): Int {
        var result = 0

        for (i in 0..<leftList.count()) {
            result += abs(leftList[i] - rightList[i])
        }

        return result
    }

    fun part2(): Int {
        var result = 0

        for (i in 0..<leftList.count()) {
            result += leftList[i] * rightList.count { it == leftList[i] }
        }

        return result
    }
    
    part1().println()
    part2().println()
}

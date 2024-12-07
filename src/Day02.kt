import kotlin.math.abs

fun main() {
    val input = readInput("Day02")

    fun part1(): Int {

        var result = 0

        for (line in input) {
            val split = line.split(" ")
            val numberSplit = split.map { it.toInt() }
            if (isSafe(numberSplit)) {
                result += 1
            }
        }

        return result
    }


    fun part2(): Int {
        var result = 0

        for (line in input) {
            val split = line.split(" ")
            val numberSplit = split.map { it.toInt() }
            if (partTwo(numberSplit)) {
                result += 1
            }
        }

        return result
    }

    part1().println()
    part2().println()
}


private fun isSafe(report: List<Int>): Boolean {
    if (report.size <= 1) {
        return false
    }

    val isIncreasing = report[0] < report[1]
    val reportZip = report.zipWithNext()

    for (zip in reportZip) {
        if (isIncreasing && zip.first < zip.second && abs(zip.first - zip.second) <= 3) {
            continue
        }
        if (!isIncreasing && zip.first > zip.second && abs(zip.first - zip.second) <= 3) {
            continue
        } else {
            return false
        }
    }
    return true
}


// I don't know why this doesn't work always. There are 2 edge cases it misses :(
private fun partTwo(report: List<Int>): Boolean {
    if (isSafe(report)) {
        return true
    }

    for (number in report) {
        if (isSafe(report - number)) {
            return true
        }
    }

    return false
}
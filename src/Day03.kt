fun main() {
    val input = readInput("Day03")

    fun part1(): Long {

        var result: Long = 0
        val regex = Regex("mul\\(\\d+,\\d+\\)")


        val matches = regex.findAll(input[0]).toList()
        for (match in matches) {
            val first = match.value.split("mul(")[1].split(",")[0].toInt()
            val second = match.value.split(",")[1].split(")")[0].toInt()
            result += (first * second)
        }
        
        return result
    }


    fun part2(): Long {
        var enabled = true  
        var result: Long = 0

        val regex = Regex("(mul\\(\\d+,\\d+\\))|do\\(\\)|don't\\(\\)")
        
        regex.findAll(input[0]).forEach { match ->
            when {
                match.value.startsWith("mul") -> {
                    if (enabled) {
                        val numbers = match.value
                            .removePrefix("mul(")
                            .removeSuffix(")")
                            .split(",")
                            .map { it.toInt() }
                        result += numbers[0] * numbers[1]
                    }
                }
                match.value == "do()" -> {
                    enabled = true
                }
                match.value == "don't()" -> {
                    enabled = false
                }
            }
        }
        return result
    }

    part1().println()
    part2().println()
}
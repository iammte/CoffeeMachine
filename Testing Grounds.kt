import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val firstClass = scanner.nextInt()
    val secClass = scanner.nextInt()
    val thirdClass = scanner.nextInt()

    var firstClassEven = firstClass / 2
    var secClassEven = secClass / 2
    var thirdClassEven = thirdClass / 2

    val firsClassOdd = firstClass % 2
    val secClassOdd = secClass % 2
    val thirdClassOdd = thirdClass % 2

    if (firsClassOdd > 0){
        firstClassEven += 1
    }
    if (secClassOdd > 0){
        secClassEven += 1
    }
    if (thirdClassOdd > 0){
        thirdClassEven += 1
    }

    val totalDesks = (firstClassEven + secClassEven + thirdClassEven)
    println(totalDesks)
}

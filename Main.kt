package machine

import java.util.*

val input = Scanner(System.`in`)

var cash =  550
var waterAmount = 400
var milkAmount = 540
var coffeeAmount = 120
var cupAmount = 9

var optionChosen = " "

fun buy() {
    val choice = input.nextLine()
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > $choice")
    when {
        choice == "back" -> {

        }
        choice.toInt() == 1 && waterAmount - 250 >= 0 && coffeeAmount - 16 >= 0 && cupAmount - 1 >= 0  -> {
            println("I have enough resources, making you a coffee!")
            waterAmount -= 250
            coffeeAmount -= 16
            cupAmount -= 1
            cash += 4
        }
        choice.toInt() == 2 && waterAmount - 350 >= 0 && milkAmount - 75 >= 0 && coffeeAmount - 20 >= 0 && cupAmount - 1 >= 0 -> {
            println("I have enough resources, making you a coffee!")
            waterAmount -= 350
            milkAmount -= 75
            coffeeAmount -= 20
            cupAmount -=1
            cash += 7
        }
        choice.toInt() == 3 && waterAmount - 200 >= 0 && milkAmount - 100 >= 0 && coffeeAmount - 12 >= 0 && cupAmount - 1 >= 0 -> {
            println("I have enough resources, making you a coffee!")
            waterAmount -= 200
            milkAmount -= 100
            coffeeAmount -= 12
            cupAmount -=1
            cash += 6
        }
        else -> {
            val limitWater = waterAmount / 200
            val limitMilk = milkAmount / 50
            val limitCoffee = coffeeAmount / 15
            val limit = if (limitWater <= limitMilk && limitWater <= limitCoffee){
                limitWater
            } else if (limitMilk <= limitWater && limitMilk <= limitCoffee) {
                limitMilk
            } else {
                limitCoffee
            }

            val limitObj: String

            limitObj = when (limit) {
                limitWater -> {
                    "water"
                }
                limitMilk -> {
                    "milk"
                }
                limitCoffee -> {
                    "coffee"
                }
                else -> {
                    "cups"
                }
            }
            println("Sorry, not enough $limitObj!")
        }
    }
}

fun fill() {
    var addition = input.nextInt()

    println("Write how many ml of water do you want to add: > $addition")
    waterAmount += addition
    addition = input.nextInt()

    println("Write how many ml of milk do you want to add: > $addition")
    milkAmount += addition
    addition = input.nextInt()

    println("Write how many grams of coffee beans do you want ot add: > $addition")
    coffeeAmount += addition
    addition = input.nextInt()

    println("Write how many disposable cups of coffee do you want to add: > $addition")
    cupAmount += addition
}

fun take() {
    println("I gave you $$cash")
    cash -= cash
}

fun remaining() {
    println("The coffee machine has: \n$waterAmount of water\n$milkAmount of milk" +
            "\n$coffeeAmount of coffee beans\n$cupAmount of cups\n$$cash of money")
}

fun main() {
    optionChosen = input.nextLine()
    println("Write action (buy, fill, take, remaining, exit): > $optionChosen")

    do {

        when (optionChosen) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
        }

        optionChosen = input.nextLine()
        println("Write action (buy, fill, take, remaining, exit): > $optionChosen")
    }  while (optionChosen != "exit")


}

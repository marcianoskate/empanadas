// Ingredients
val flour = "flour"
val salt = "salt"
val butter = "butter"
val eggs = "eggs"
val milk = "milk"
val water = "water"
val cheese = "cheese"

// Tools
val hasGrater = true
val hasMilk = true

fun makeEmpanadas() {

    //=====================
    //=== PREPARE DOUGH ===
    //=====================
    val bowl = mutableListOf<String>()
    bowl.add(salt)
    // TIP: Debugging is very costly
    // println(bowl)
    // println("adding $ingredient to mix")
    bowl.add(flour)
    mix(bowl)
    // println(bowl)

    bowl.add(butter)
    bowl.add(eggs)

    if (hasMilk) {
        bowl.add(milk)
    } else {
        bowl.add(water)
    }
    mix(bowl)

    //=====================
    // DOUGH is mixed
    //=====================
    val dough = bowl[0]
    val doughDisks = mutableListOf<String>()
    for (i in 1..10) {
        // We make small dough balls out of the whole dough
        doughDisks.add("doughBall-$i")
    }
    for ((index, doughBall) in doughDisks.withIndex()) {
        // Flatten doughballs into doughdisks, I don't know how to do that with strings 😬
        doughDisks.set(index, "dough-disk-$index")
    }

    //=======================
    //=== PREPARE FILLING ===
    //=======================
    val preparedCheese = if (hasGrater) {
        "Greated $cheese"
    } else {
        "Diced $cheese"
    }
    val empanadasCrudas = mutableListOf<String>()
    for ((index, value) in doughDisks.withIndex()) {
        var empanadaCruda = doughDisks.get(index)
        empanadaCruda = "$value-with-$preparedCheese"
        empanadaCruda = "$value-folded"
        empanadaCruda = "$value-with-eggwhite"
        empanadaCruda = "$value-empanada-with-repulgue"
        empanadaCruda = "$value-empanada-with-eggyolks"
        empanadasCrudas.add(empanadaCruda)
    }

    //=====================
    // Preheat the oven
    // to cook empanadas
    //=====================
    //val isOvenReady = preheatOven(375) // Long task!! maybe we could have started before preparing everything?
    println("Starting oven to reach temperature: 375")
    var temp = 0
    while (temp < 375) {
        // if (temp % 10 == 0) println("Current Temp: $temp")
        temp += 1
//        Thread.sleep(1000) // to make it even slower
    }
    val isOvenReady = true

    //======================
    //=== COOK EMPANADAS ===
    //======================
    val oven = mutableListOf<String>()
    val cookingTime = 25 // minutes
    var timer = 0
    val empanadasCooked = mutableListOf<String>()
    if (isOvenReady) {
        oven.addAll(empanadasCrudas)
        while (timer < cookingTime) {
//            Thread.sleep(60000 ) //sleep for a minute, then add one minute to timer
            timer += 1
        }
        for (empanada in oven) empanadasCooked.add(empanada)
        println("Empanadas ready!")
        println("enjoy your empanadas")
    } else {
        throw RuntimeException("I don't know what I'm doing!")
    }

    for (empanada in empanadasCooked) {
        println("Chomping on $empanada")
        println("chomp chomp chomp")
        println("yum")
    }
}

fun mix(bowl: MutableList<String>) {
    var mixture = ""
    for (ingredients in bowl) {
        mixture = mixture + ":" + ingredients
    }
    bowl.clear()
    bowl.add(mixture)
}

fun main() {
    makeEmpanadas()
}
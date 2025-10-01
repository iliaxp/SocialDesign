package com.mahdizaredev.socialdesign.data

import kotlin.random.Random


class MockNameRepository {
    private val names = listOf(
        "Alex",
        "Ryan",
        "Zara",
        "Liam",
        "Mia",
        "Noah",
        "Ava",
        "Ethan",
        "Olivia",
        "Leo",
        "Emma",
        "Jack",
        "Sophia",
        "Lucas",
        "Chloe",
        "Max",
        "Isla",
        "Finn",
        "Lily",
        "Jade",
        "Adam",
        "Alice",
        "Henry",
        "Ruby",
        "Oscar",
        "Ella",
        "George",
        "Zoe",
        "Charlie",
        "Amelia",
        "Sam",
        "Grace",
        "Tom",
        "Eva",
        "Leo",
        "Anna",
        "Nina",
        "Jake",
        "Rose",
        "Harry",
        "Lucy",
        "Ben",
        "Lara",
        "James",
        "Maya",
        "Ryan",
        "Leah",
        "David",
        "Clara",
        "Oliver",
        "Isabel",
    )

    fun getRandomName(): String {
        return names.get(Random.nextInt(0, 49))
    }
}
package dev.spikeysanju.POM.POM

import kotlin.random.Random

class Base {
    // Screen Elements

    // Helper functions

    /**
     * Generate a random alphanumeric string with given length
     */

    fun generateRandomAlphanumeric(length: Int): String {
        val alphanumericChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { alphanumericChars[Random.nextInt(0, alphanumericChars.size)] }
            .joinToString("")
    }
}

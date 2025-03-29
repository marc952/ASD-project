package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

// Data class to store a card with a unique ID and a list of words
data class Card(
    val id: Identifier,     // Unique identifier for the card
    val words: List<Word>   // List of words associated with the card
)
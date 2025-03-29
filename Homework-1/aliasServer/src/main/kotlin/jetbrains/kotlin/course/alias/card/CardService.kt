package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words // Import words from the external file
import org.springframework.stereotype.Service

@Service
class CardService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory() // Generates unique IDs for cards
) {
    companion object {
        private const val WORDS_IN_CARD = 4 // Each card contains 4 words
        val cardsAmount = words.size / WORDS_IN_CARD // Total number of cards possible
    }

    private val cards: List<Card> = generateCards() // List of generated cards

    private fun List<String>.toWords(): List<Word> =
        this.map { Word(it) } // Converts List<String> into List<Word>

    private fun generateCards(): List<Card> {
        return words.shuffled() // Shuffle words to randomize card generation
            .chunked(WORDS_IN_CARD) // Split words into groups of 4
            .take(cardsAmount) // Take only the valid number of groups
            .map { chunk -> Card(identifierFactory.uniqueIdentifier(), chunk.toWords()) } // Convert each chunk into a Card
    }

    fun getCardByIndex(index: Int): Card {
        return cards.getOrNull(index) ?: throw IndexOutOfBoundsException("Card with index $index does not exist")
    }
}
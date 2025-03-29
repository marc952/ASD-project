package jetbrains.kotlin.course.alias.util

// Type alias for Identifier
typealias Identifier = Int

// Class for generating unique identifiers
class IdentifierFactory {
    // Counter to store the last unique number, initialized to 0
    private var counter: Int = 0

    // Function to generate a new unique identifier
    fun uniqueIdentifier(): Identifier {
        counter++  // Increment the counter
        return counter  // Return the new unique identifier
    }
}
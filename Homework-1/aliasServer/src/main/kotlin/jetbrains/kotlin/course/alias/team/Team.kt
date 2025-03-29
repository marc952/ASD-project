package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier

// Data class to store team information
data class Team(
    val id: Identifier,  // Unique identifier for the team
    var points: Int = 0  // Points, default is 0, changed to var for reassignment
) {
    // Automatically generated team name
    val name: String = "Team#${id + 1}"
}
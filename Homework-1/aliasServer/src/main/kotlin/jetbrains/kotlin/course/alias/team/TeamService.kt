package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory()  // Generates unique IDs for teams
) {
    companion object {
        // Storage for all created teams, mapping each team ID to a Team object
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val newTeams = List(teamsNumber) {
            val id = identifierFactory.uniqueIdentifier()  // Generate a new unique ID
            val team = Team(id)  // Create a new Team
            teamsStorage[id] = team  // Store it in the teamsStorage map
            team  // Return the created team
        }
        return newTeams
    }
}
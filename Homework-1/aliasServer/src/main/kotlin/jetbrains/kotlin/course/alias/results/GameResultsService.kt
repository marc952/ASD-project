package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

// Type alias for game results
typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        // Stores the history of game results
        private val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        // Check if the result list is not empty
        if (result.isEmpty()) {
            throw IllegalArgumentException("Game result cannot be empty")
        }

        // Check if all team IDs in the result exist in TeamService.teamsStorage
        if (result.any { it.id !in TeamService.teamsStorage.keys }) {
            throw IllegalArgumentException("Some teams in the result do not exist in the teamsStorage")
        }

        // Save the result
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> {
        // Return the game history in reversed order
        return gameHistory.reversed()
    }
}
package flashcards

/**
 * Class representing a card
 *
 * @property term the term of the card
 * @property definition the definition of the card
 * @property mistakes number of mistakes made on this card
 */
data class Card(val term: String, val definition: String, var mistakes: Int = 0) {

    /** Resets the number of mistakes to 0 */
    fun resetMistakes() {
        mistakes = 0
    }

    /** Increases by one the number of mistakes */
    fun increaseMistakes() {
        mistakes++
    }
}

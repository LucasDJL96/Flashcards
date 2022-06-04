package flashcards

import java.io.File
import java.io.FileNotFoundException

import kotlin.random.Random

/**
 * Class representing a deck of cards
 * Allows iteration through its cards
 */
class Deck : Iterable<Card> {

    private val cards: MutableList<Card> = mutableListOf()

    private val size
        get() = cards.size

    private val definitions = mutableSetOf<String>()

    private val terms = mutableListOf<String>()

    private val termFromDef = mutableMapOf<String, String>()

    private val cardFromTerm = mutableMapOf<String, Card>()

    /**
     * Adds a card to this deck
     *
     * @param card the card to add
     */
    fun add(card: Card) {
        cards.add(card)
        definitions.add(card.definition)
        terms.add(card.term)
        termFromDef[card.definition] = card.term
        cardFromTerm[card.term] = card
    }

    /**
     * Removes a card from this deck
     *
     * @param term the term of the card to remove
     *
     * @throws NullPointerException if the card is not found in this deck
     */
    fun remove(term: String) {
        val card = cardFromTerm[term]!!
        cards.remove(card)
        definitions.remove(card.definition)
        terms.remove(term)
        termFromDef.remove(card.definition)
        cardFromTerm.remove(term)
    }

    /**
     * Imports cards from file, overriding existing ones if a term or definition collision occurs.
     * Each card should be on a new line with the format term:definition:mistakes
     *
     * @param file the file from which to import cards
     *
     * @return Int the number of cards imported
     *
     * @throws FileNotFoundException if the file passed can't be found
     */
    fun importFrom(file: File): Int {
        if (!file.exists()) throw FileNotFoundException("Import file not found.")
        var cardsImported = 0
        val lines = file.readLines()
        for (i in 0..lines.lastIndex) {
            val (term, definition, mistakes) = lines[i].split(":")
            val card = Card(term, definition, mistakes.toInt())
            if (term in terms) remove(term)
            else if (definition in definitions) remove(termFromDef[definition]!!)
            add(card)
            cardsImported++
        }
        return cardsImported
    }

    /**
     * Exports the cards of this deck to a file with the format:
     * term:definition:mistakes
     * writing each card on a new line
     *
     * @param file the file to export cards to
     *
     * @return Int the number of cards exported
     */
    fun exportTo(file: File): Int {
        file.createNewFile()
        file.writeText("")
        for (card in cards) {
            file.appendText("${card.term}:${card.definition}:${card.mistakes}\n")
        }
        return size
    }

    /**
     * Selects a random card from this deck
     *
     * @return Card the random card
     */
    fun randomGet(): Card {
        return cards[Random.nextInt(size)]
    }

    /** Resets the stats of all cards in this deck */
    fun resetStats() {
        for (card in cards) {
            card.resetMistakes()
        }
    }

    /**
     * Selects the cards with the most mistakes from this deck
     *
     * @return List<Card> a list with the hardest cards
     */
    fun getHardestCards(): List<Card> {
        val max = cards.maxOf { it.mistakes }
        return cards.filter { it.mistakes == max }
    }

    /**
     * Finds the term of a card in this deck from a definition
     *
     * @param definition the definition to look for
     *
     * @return String the term corresponding to the definition
     *
     * @throws NullPointerException if no card with the definition is in this deck
     */
    fun getTermFromDef(definition: String): String = termFromDef[definition]!!

    /**
     * Checks if this deck has a card with a given definition
     *
     * @param definition the definition
     *
     * @return Boolean whether a card with the definition is in this deck
     */
    fun containsDefinition(definition: String): Boolean = definitions.contains(definition)

    /**
     * Checks if this deck has a card with a given term
     *
     * @param term the term
     *
     * @return Boolean whether a card with the term is in this deck
     */
    fun containsTerm(term: String): Boolean = terms.contains(term)

    /**
     * Checks if this deck is empty
     *
     * @return Boolean whether the deck is empty
     */
    fun isEmpty(): Boolean = size == 0

    /** Returns an iterator over the cards of this deck */
    override fun iterator(): Iterator<Card> {
        return cards.iterator()
    }

}

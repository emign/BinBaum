package me.sschaeffner.abi.binBaum

/**
 * @author sschaeffner
 */
internal abstract class Baumelement {
    abstract fun suchen(schluessel: String?): Datenelement?
    abstract fun einfuegen(daten: Datenelement?): Baumelement?
    abstract fun preorderAusgabe(depth: Int): String?
    abstract fun inorderAusgabe(): String?
    abstract fun postorderAusgabe(): String?
    abstract override fun toString(): String
}
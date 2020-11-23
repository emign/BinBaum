package me.sschaeffner.abi.binBaum

/**
 * @author sschaeffner
 */
interface Datenelement {
    fun informationAusgeben()
    fun istKleinerAls(daten: Datenelement?): Boolean
    fun istGroesserAls(daten: Datenelement?): Boolean
    fun schluesselIstGleich(schluessel: String?): Boolean
    fun schluesselIstGroesserAls(schluessel: String?): Boolean
    fun istGleich(daten: Datenelement?): Boolean
    fun schluesselGeben(): String?
}
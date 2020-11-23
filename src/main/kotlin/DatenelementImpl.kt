package me.sschaeffner.abi.binBaum

/**
 * @author sschaeffner
 */
class DatenelementImpl(private val schluessel: String) : Datenelement {
    override fun informationAusgeben() {
        println(this)
    }

    override fun istKleinerAls(daten: Datenelement?): Boolean {
        return schluessel.compareTo(daten!!.schluesselGeben()!!) < 0
    }

    override fun istGroesserAls(daten: Datenelement?): Boolean {
        return schluessel.compareTo(daten!!.schluesselGeben()!!) > 0
    }

    override fun schluesselIstGleich(schluessel: String?): Boolean {
        return this.schluessel == schluessel
    }

    override fun schluesselIstGroesserAls(schluessel: String?): Boolean {
        return this.schluessel.compareTo(schluessel!!) > 0
    }

    override fun istGleich(daten: Datenelement?): Boolean {
        return schluesselIstGleich(daten!!.schluesselGeben())
    }

    override fun schluesselGeben(): String? {
        return schluessel
    }

    override fun toString(): String {
        return "DatenelementImpl(\"" + schluessel + "\")"
    }
}
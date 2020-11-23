package me.sschaeffner.abi.binBaum

/**
 * @author sschaeffner
 */
internal class Abschluss : Baumelement() {
    override fun suchen(schluessel: String?): Datenelement? {
        return null
    }

    override fun einfuegen(daten: Datenelement?): Baumelement? {
        return Knoten(daten!!, this, this)
    }

    override fun preorderAusgabe(depth: Int): String? {
        var tabs = ""
        for (i in 0 until depth) {
            tabs += "\t"
        }
        return tabs + "Abschluss"
    }

    override fun inorderAusgabe(): String? {
        return ""
    }

    override fun postorderAusgabe(): String? {
        return ""
    }

    override fun toString(): String {
        return "Abschluss() "
    }
}
package me.sschaeffner.abi.binBaum

/**
 * @author sschaeffner
 */
internal class Knoten @JvmOverloads constructor(private val daten: Datenelement, private var linkerNachfolger: Baumelement? = Abschluss(), private var rechterNachfolger: Baumelement? = Abschluss()) : Baumelement() {
    override fun suchen(schluessel: String?): Datenelement? {
        return if (daten.schluesselIstGleich(schluessel)) {
            daten
        } else if (daten.schluesselIstGroesserAls(schluessel)) {
            linkerNachfolger!!.suchen(schluessel)
        } else {
            rechterNachfolger!!.suchen(schluessel)
        }
    }

    override fun einfuegen(daten: Datenelement?): Baumelement? {
        if (this.daten.istGleich(daten)) {
            System.err.println("Datenelement schon im Baum vorhanden. Kann nicht erneut eingefügt werden!")
        } else if (this.daten.istKleinerAls(daten)) {
            rechterNachfolger = rechterNachfolger!!.einfuegen(daten)
        } else {
            linkerNachfolger = linkerNachfolger!!.einfuegen(daten)
        }
        return this
    }

    override fun preorderAusgabe(depth: Int): String? {
        var tabs = ""
        for (i in 0 until depth) {
            tabs += "\t"
        }
        return tabs + daten.schluesselGeben() + System.lineSeparator() + linkerNachfolger!!.preorderAusgabe(depth + 1) + System.lineSeparator() + rechterNachfolger!!.preorderAusgabe(depth + 1)
    }

    override fun inorderAusgabe(): String? {
        return linkerNachfolger!!.inorderAusgabe() + " " + daten + " " + rechterNachfolger!!.inorderAusgabe()
    }

    override fun postorderAusgabe(): String? {
        return linkerNachfolger!!.postorderAusgabe() + " " + rechterNachfolger!!.postorderAusgabe() + " " + daten.schluesselGeben()
    }

    override fun toString(): String {
        return "Knoten($linkerNachfolger; $daten ; $rechterNachfolger) "
    }
}
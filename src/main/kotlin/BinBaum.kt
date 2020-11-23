package me.sschaeffner.abi.binBaum

/**
 * Implementation eines Binärbaums im Kompositum.
 *
 * Methodennamen nach Brichzin, Freiberger, Reinold und Wiedemann, "Informatik - Oberstufe 1" (Oldenbourg, 2009)
 *
 * @author sschaeffner
 */
class BinBaum {
    private var wurzel: Baumelement

    /**
     * Sucht im Baum nach einem Datenelement mit einem gegebenen Schlüssel.
     *
     * @param schluessel    Schlüssel, nach dem gesucht werden soll
     * @return              Datenelement, das zum gegebenen Schlüssel passt, oder null
     * wenn kein Datenelement gefunden werden konnte
     */
    fun suchen(schluessel: String?): Datenelement? {
        return wurzel.suchen(schluessel)
    }

    /**
     * Fügt einen neuen Knoten mit einem gegebenen Datenelement in den Baum ein, so dass ein sortierter Baum entsteht.
     *
     * @param daten einzufügendes Datenelement
     */
    fun einfuegen(daten: Datenelement?) {
        wurzel = wurzel.einfuegen(daten)!!
    }

    /**
     * Gibt den Baum nach dem preorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach preorder Verfahren
     */
    fun preorderAusgabe(): String? {
        return wurzel.preorderAusgabe(0)
    }

    /**
     * Gibt den Baum nach dem inorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach inorder Verfahren
     */
    fun inorderAusgabe(): String? {
        return wurzel.inorderAusgabe()
    }

    /**
     * Gibt den Baum nach dem postorder Verfahren aus.
     *
     * @return Ausgabe des Baums nach postorder Verfahren
     */
    fun postorderAusgabe(): String? {
        return wurzel.postorderAusgabe()
    }

    override fun toString(): String {
        return "BinBaum($wurzel)"
    }

    /**
     * Konstruiert einen leeren Baum.
     */
    init {
        wurzel = Abschluss()
    }
}
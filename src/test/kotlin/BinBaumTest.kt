package me.sschaeffner.abi.binBaum.test

import me.sschaeffner.abi.binBaum.BinBaum
import me.sschaeffner.abi.binBaum.Datenelement
import me.sschaeffner.abi.binBaum.DatenelementImpl
import org.junit.Assert
import org.junit.Test

/**
 * @author sschaeffner
 */
class BinBaumTest {
    @Test
    fun constructionTest() {
        val b = BinBaum()
        Assert.assertNotNull(b)
        Assert.assertEquals("BinBaum(Abschluss() )", b.toString())
    }

    @Test
    fun einfuegenTest() {
        val b = BinBaum()
        val daten1: Datenelement = DatenelementImpl("1")
        val daten2: Datenelement = DatenelementImpl("2")
        val daten3: Datenelement = DatenelementImpl("3")
        val daten4: Datenelement = DatenelementImpl("4")
        Assert.assertEquals("BinBaum(Abschluss() )", b.toString())
        b.einfuegen(daten3)
        Assert.assertEquals("BinBaum(Knoten(Abschluss() ; DatenelementImpl(\"3\") ; Abschluss() ) )", b.toString())
        System.err.println("--- Fehler beabsichtigt ---")
        b.einfuegen(daten3)
        Assert.assertEquals("BinBaum(Knoten(Abschluss() ; DatenelementImpl(\"3\") ; Abschluss() ) )", b.toString())
        System.err.println("--- Ende Fehler beabsichtigt ---")
        b.einfuegen(daten1)
        Assert.assertEquals("BinBaum(Knoten(Knoten(Abschluss() ; DatenelementImpl(\"1\") ; Abschluss() ) ; DatenelementImpl(\"3\") ; Abschluss() ) )", b.toString())
        b.einfuegen(daten4)
        Assert.assertEquals("BinBaum(Knoten(Knoten(Abschluss() ; DatenelementImpl(\"1\") ; Abschluss() ) ; DatenelementImpl(\"3\") ; Knoten(Abschluss() ; DatenelementImpl(\"4\") ; Abschluss() ) ) )", b.toString())
    }

    @Test
    fun inorderTest() {
        val b = BinBaum()
        val daten1: Datenelement = DatenelementImpl("1")
        val daten2: Datenelement = DatenelementImpl("2")
        val daten3: Datenelement = DatenelementImpl("3")
        val daten4: Datenelement = DatenelementImpl("4")
        Assert.assertEquals("", b.inorderAusgabe())
        b.einfuegen(daten2)
        Assert.assertEquals(" DatenelementImpl(\"2\") ", b.inorderAusgabe())
        b.einfuegen(daten3)
        Assert.assertEquals(" DatenelementImpl(\"2\")  DatenelementImpl(\"3\") ", b.inorderAusgabe())
        b.einfuegen(daten1)
        Assert.assertEquals(" DatenelementImpl(\"1\")  DatenelementImpl(\"2\")  DatenelementImpl(\"3\") ", b.inorderAusgabe())
        b.einfuegen(daten4)
        Assert.assertEquals(" DatenelementImpl(\"1\")  DatenelementImpl(\"2\")  DatenelementImpl(\"3\")  DatenelementImpl(\"4\") ", b.inorderAusgabe())
    }

    @Test
    fun preorderTest() {
        val b = BinBaum()
        val daten1: Datenelement = DatenelementImpl("1")
        val daten2: Datenelement = DatenelementImpl("2")
        val daten3: Datenelement = DatenelementImpl("3")
        val daten4: Datenelement = DatenelementImpl("4")
        Assert.assertEquals("Abschluss", b.preorderAusgabe())
        b.einfuegen(daten2)
        Assert.assertEquals("""2
    Abschluss
    Abschluss""", b.preorderAusgabe())
        b.einfuegen(daten3)
        Assert.assertEquals("""2
    Abschluss
	3
		Abschluss
		Abschluss""", b.preorderAusgabe())
        b.einfuegen(daten1)
        Assert.assertEquals("""2
	1
		Abschluss
		Abschluss
	3
		Abschluss
		Abschluss""", b.preorderAusgabe())
        b.einfuegen(daten4)
        Assert.assertEquals("""2
    1
		Abschluss
		Abschluss
	3
		Abschluss
		4
			Abschluss
			Abschluss""", b.preorderAusgabe())
    }

    @Test
    fun postorderTest() {
        val b = BinBaum()
        val daten1: Datenelement = DatenelementImpl("1")
        val daten2: Datenelement = DatenelementImpl("2")
        val daten3: Datenelement = DatenelementImpl("3")
        val daten4: Datenelement = DatenelementImpl("4")
        Assert.assertEquals("", b.postorderAusgabe())
        b.einfuegen(daten2)
        Assert.assertEquals("  2", b.postorderAusgabe())
        b.einfuegen(daten3)
        Assert.assertEquals("   3 2", b.postorderAusgabe())
        b.einfuegen(daten1)
        Assert.assertEquals("  1   3 2", b.postorderAusgabe())
        b.einfuegen(daten4)
        Assert.assertEquals("  1    4 3 2", b.postorderAusgabe())
    }

    @Test
    fun suchenTest() {
        val b = BinBaum()
        val daten1: Datenelement = DatenelementImpl("1")
        val daten2: Datenelement = DatenelementImpl("2")
        val daten3: Datenelement = DatenelementImpl("3")
        val daten4: Datenelement = DatenelementImpl("4")
        Assert.assertNull(b.suchen("1"))
        Assert.assertNull(b.suchen("2"))
        Assert.assertNull(b.suchen("3"))
        Assert.assertNull(b.suchen("4"))
        b.einfuegen(daten2)
        Assert.assertNull(b.suchen("1"))
        Assert.assertEquals(daten2, b.suchen("2"))
        Assert.assertNull(b.suchen("3"))
        Assert.assertNull(b.suchen("4"))
        b.einfuegen(daten1)
        Assert.assertEquals(daten1, b.suchen("1"))
        Assert.assertEquals(daten2, b.suchen("2"))
        Assert.assertNull(b.suchen("3"))
        Assert.assertNull(b.suchen("4"))
        b.einfuegen(daten4)
        Assert.assertEquals(daten1, b.suchen("1"))
        Assert.assertEquals(daten2, b.suchen("2"))
        Assert.assertNull(b.suchen("3"))
        Assert.assertEquals(daten4, b.suchen("4"))
        b.einfuegen(daten3)
        Assert.assertEquals(daten1, b.suchen("1"))
        Assert.assertEquals(daten2, b.suchen("2"))
        Assert.assertEquals(daten3, b.suchen("3"))
        Assert.assertEquals(daten4, b.suchen("4"))
    }
}
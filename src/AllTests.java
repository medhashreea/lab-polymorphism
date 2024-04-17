/**
 * Vertically flips the text.
 * 
 * @author Medhashree Adhikari
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AllTests {
  // +-----------------------+--------------------------------
  // | TextBlock Declaration |
  // +-----------------------+

  // constant width truncate
  private int truncWidth = 8;

  // constant width justify
  private int justifyWidth = 23;

  // general
  private TextBlock myName;
  private TextBlock myLastName;
  private TextBlock fullNameHComp;
  private TextBlock fullNameVComp;
  private TextBlock empty;
  private TextBlock emptyBox;
  private TextBlock oneItem;
  private TextBlock fullNameBox;
  private TextBlock myNameBoxBox;

  // truncate
  private TextBlock truncMyName;
  private TextBlock fakeTruncMyName;
  private TextBlock emptyMyName;
  private TextBlock truncEmpty;
  private TextBlock truncEmptyBox;
  private TextBlock truncOneItem;
  private TextBlock truncDoubleBox;

  // center
  private TextBlock evenNumSpcMyName;
  private TextBlock oddNumSpcMyName;
  private TextBlock nameWidth;
  private TextBlock evenNumSpcMyNameBoxBox;
  private TextBlock centerEmpty;

  // right justify
  private TextBlock RJFullName;
  private TextBlock RJEmpty;
  private TextBlock RJFullNameBox;
  private TextBlock RJMyNameBoxBox;

  // horizontally flip
  private TextBlock fullNameHFlippedHComp;
  private TextBlock fullNameHFlippedVComp;
  private TextBlock myNameHFlippedTwice;
  private TextBlock myNameBoxHFlippedThrice;
  private TextBlock emptyHFlip;

  // vertically flip
  private TextBlock fullNameVFlippedHComp;
  private TextBlock fullNameVFlippedVComp;
  private TextBlock myNameVFlippedTwice;
  private TextBlock myNameBoxVFlippedThrice;
  private TextBlock emptyVFlip;

  // flip both
  private TextBlock fullNameBothFlippedVComp;
  private TextBlock myNameBothFlippedTwice;
  private TextBlock myNameBoxBothFlippedThrice;
  private TextBlock emptyBothFlip;

  // left justify
  private TextBlock LJFullName;
  private TextBlock LJEmpty;
  private TextBlock LJFullNameBox;
  private TextBlock LJMyNameBoxBox;

  // Equal, Eqv, Eq
  private TextBlock copyMyName;
  private TextBlock copyMyNameHFlippedTwice;

  /**
   * +--------------------------+-----------------------------
   * | TextBlock Initialization |
   * +--------------------------+
   */
  public AllTests() throws Exception {
    // general
    myName = new TextLine("Medhashree");
    myLastName = new TextLine("Adhikari");
    fullNameHComp = new HComposition(myName, myLastName);
    fullNameVComp = new VComposition(myName, myLastName);
    empty = new TextLine("");
    emptyBox = new BoxedBlock(new TextLine(""));
    oneItem = new BoxedBlock(new TextLine("m"));
    fullNameBox = new BoxedBlock(new VComposition(fullNameHComp, oneItem));
    myNameBoxBox = new BoxedBlock(new BoxedBlock(new TextLine("Medhashree")));

    // truncate
    truncMyName = new Truncated(myName, truncWidth);
    fakeTruncMyName = new Truncated(myName, myName.width());
    emptyMyName = new Truncated(myName, 0);
    truncEmpty = new Truncated(empty, 0);
    truncOneItem = new Truncated(oneItem, 2);
    truncDoubleBox = new Truncated((new BoxedBlock(new VComposition(fullNameHComp, oneItem))), truncWidth);

    // center
    evenNumSpcMyName = new Centered(myName, myName.width() + 8);
    oddNumSpcMyName = new Centered(myName, myName.width() + 13);
    nameWidth = new Centered(myName, myName.width());
    evenNumSpcMyNameBoxBox = new BoxedBlock(new Centered(myNameBoxBox, myName.width() + 20));
    centerEmpty = new Centered(empty, 4);

    // right justify
    RJFullName = new RightJustified(fullNameHComp, justifyWidth);
    RJEmpty = new RightJustified(empty, justifyWidth);
    RJFullNameBox = new RightJustified(fullNameBox, justifyWidth);
    RJMyNameBoxBox = new BoxedBlock(new RightJustified(myNameBoxBox, justifyWidth));

    // horizontally flip
    fullNameHFlippedHComp = new HorizontallyFlipped(fullNameHComp);
    fullNameHFlippedVComp = new HorizontallyFlipped(fullNameVComp);
    myNameHFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(fullNameBox));
    myNameBoxHFlippedThrice = new HorizontallyFlipped(new HorizontallyFlipped(new HorizontallyFlipped(fullNameBox)));
    emptyHFlip = new HorizontallyFlipped(empty);

    // vertically flip
    fullNameVFlippedHComp = new VerticallyFlipped(fullNameHComp);
    fullNameVFlippedVComp = new VerticallyFlipped(fullNameVComp);
    myNameVFlippedTwice = new VerticallyFlipped(new VerticallyFlipped(fullNameBox));
    myNameBoxVFlippedThrice = new VerticallyFlipped(new VerticallyFlipped(new VerticallyFlipped(fullNameBox)));
    emptyVFlip = new VerticallyFlipped(empty);

    // flip both
    fullNameBothFlippedVComp = new FlipBoth(fullNameVComp);
    myNameBothFlippedTwice = new FlipBoth(new FlipBoth(fullNameVComp));
    myNameBoxBothFlippedThrice = new FlipBoth(new FlipBoth(new FlipBoth(fullNameVComp)));
    emptyBothFlip = new FlipBoth(empty);

    // left justify
    LJFullName = new LeftJustified(fullNameHComp, justifyWidth);
    LJEmpty = new LeftJustified(empty, justifyWidth);
    LJFullNameBox = new LeftJustified(fullNameBox, justifyWidth);
    LJMyNameBoxBox = new BoxedBlock(new LeftJustified(myNameBoxBox, justifyWidth));

    // Equal, Eqv, Eq
    copyMyName = new TextLine("Medhashree");
    copyMyNameHFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(fullNameBox));

  } // test initialization

  /**
   * +----------------+---------------------------------------
   * | Truncate Tests |
   * +----------------+
   */

  @Test
  public void basicTruncTest() throws Exception {
    assertEquals("Medhashr", truncMyName.row(0));
  }

  @Test
  public void fakeTruncTest() throws Exception {
    assertEquals("Medhashree", fakeTruncMyName.row(0));
  }

  @Test
  public void truncAll() throws Exception {
    assertEquals("", emptyMyName.row(0));
  }

  @Test
  public void emptyTruncTest() throws Exception {
    assertEquals("", truncEmpty.row(0));
  }

  // truncating one item to width 2
  @Test
  public void oneItemTest() throws Exception {
    assertEquals("+-", truncOneItem.row(0));
    assertEquals("|m", truncOneItem.row(1));
    assertEquals("+-", truncOneItem.row(2));
  }

  @Test
  public void truncDoubleBoxTest() throws Exception {
    assertEquals("+-------", truncDoubleBox.row(0));
    assertEquals("|Medhash", truncDoubleBox.row(1));
    assertEquals("|+-+    ", truncDoubleBox.row(2));
    assertEquals("||m|    ", truncDoubleBox.row(3));
    assertEquals("|+-+    ", truncDoubleBox.row(4));
    assertEquals("+-------", truncDoubleBox.row(5));
  }

  /**
   * +----------------+---------------------------------------
   * | Centered Tests |
   * +----------------+
   */

  // centering to even num
  @Test
  public void evenNumSpcTest() throws Exception {
    assertEquals("    Medhashree    ", evenNumSpcMyName.row(0));
  }

  // centering to odd num
  @Test
  public void oddNumSpcTest() throws Exception {
    assertEquals("      Medhashree       ", oddNumSpcMyName.row(0));
  }

  // centering to width. no changes occur!
  @Test
  public void nameWidthTest() throws Exception {
    assertEquals("Medhashree", nameWidth.row(0));
  }

  @Test
  public void evenNumDoubleBoxTest() throws Exception {
    assertEquals("+------------------------------+", evenNumSpcMyNameBoxBox.row(0));
    assertEquals("|        +------------+        |", evenNumSpcMyNameBoxBox.row(1));
    assertEquals("|        |+----------+|        |", evenNumSpcMyNameBoxBox.row(2));
    assertEquals("|        ||Medhashree||        |", evenNumSpcMyNameBoxBox.row(3));
    assertEquals("|        |+----------+|        |", evenNumSpcMyNameBoxBox.row(4));
    assertEquals("|        +------------+        |", evenNumSpcMyNameBoxBox.row(5));
    assertEquals("+------------------------------+", evenNumSpcMyNameBoxBox.row(6));
  }

  // centers empty spaces to width
  @Test
  public void emptyTest() throws Exception {
    assertEquals("    ", centerEmpty.row(0));
  }

  /**
   * +-----------------------+--------------------------------
   * | Right Justified Tests |
   * +-----------------------+
   */

  // right justifies so the width is 23
  @Test
  public void RJFullNameTest() throws Exception {
    assertEquals("     MedhashreeAdhikari", RJFullName.row(0));
  }

  @Test
  public void RJEmptyTest() throws Exception {
    assertEquals("                       ", RJEmpty.row(0));
  }

  @Test
  public void RJFullNameBoxTest() throws Exception {
    assertEquals("   +------------------+", RJFullNameBox.row(0));
    assertEquals("   |MedhashreeAdhikari|", RJFullNameBox.row(1));
    assertEquals("   |+-+               |", RJFullNameBox.row(2));
    assertEquals("   ||m|               |", RJFullNameBox.row(3));
    assertEquals("   |+-+               |", RJFullNameBox.row(4));
    assertEquals("   +------------------+", RJFullNameBox.row(5));
  }

  @Test
  public void RJMyName2BoxTest() throws Exception {
    assertEquals("+-----------------------+", RJMyNameBoxBox.row(0));
    assertEquals("|         +------------+|", RJMyNameBoxBox.row(1));
    assertEquals("|         |+----------+||", RJMyNameBoxBox.row(2));
    assertEquals("|         ||Medhashree|||", RJMyNameBoxBox.row(3));
    assertEquals("|         |+----------+||", RJMyNameBoxBox.row(4));
    assertEquals("|         +------------+|", RJMyNameBoxBox.row(5));
    assertEquals("+-----------------------+", RJMyNameBoxBox.row(6));
  }

  /**
   * +----------------------------+---------------------------
   * | Horizontally Flipped Tests |
   * +----------------------------+
   */

  @Test
  public void HFlipHCompTest() throws Exception {
    assertEquals("irakihdAeerhsahdeM", fullNameHFlippedHComp.row(0));
  }

  @Test
  public void HFlipVCompTest() throws Exception {
    assertEquals("eerhsahdeM", fullNameHFlippedVComp.row(0));
    assertEquals("  irakihdA", fullNameHFlippedVComp.row(1));
  }

  @Test
  public void HFlip2Test() throws Exception {
    assertEquals("+------------------+", myNameHFlippedTwice.row(0));
    assertEquals("|MedhashreeAdhikari|", myNameHFlippedTwice.row(1));
    assertEquals("|+-+               |", myNameHFlippedTwice.row(2));
    assertEquals("||m|               |", myNameHFlippedTwice.row(3));
    assertEquals("|+-+               |", myNameHFlippedTwice.row(4));
    assertEquals("+------------------+", myNameHFlippedTwice.row(5));
  }

  @Test
  public void HFlip3Test() throws Exception {
    assertEquals("+------------------+", myNameBoxHFlippedThrice.row(0));
    assertEquals("|irakihdAeerhsahdeM|", myNameBoxHFlippedThrice.row(1));
    assertEquals("|               +-+|", myNameBoxHFlippedThrice.row(2));
    assertEquals("|               |m||", myNameBoxHFlippedThrice.row(3));
    assertEquals("|               +-+|", myNameBoxHFlippedThrice.row(4));
    assertEquals("+------------------+", myNameBoxHFlippedThrice.row(5));

  }

  // nothing to flip
  @Test
  public void emptyHFlipTest() throws Exception {
    assertEquals("", emptyHFlip.row(0));
  }

  /**
   * +--------------------------+-----------------------------
   * | Vertically Flipped Tests |
   * +--------------------------+
   */

  // returns same because flips odd
  @Test
  public void VFlipHCompTest() throws Exception {
    assertEquals("MedhashreeAdhikari", fullNameVFlippedHComp.row(0));
  }

  // VComp, VFlip
  @Test
  public void VFlipVCompTest() throws Exception {
    assertEquals("Adhikari  ", fullNameVFlippedVComp.row(0));
    assertEquals("Medhashree", fullNameVFlippedVComp.row(1));
  }

  // flipped vertically two times
  @Test
  public void VFlip2Test() throws Exception {
    assertEquals("+------------------+", myNameVFlippedTwice.row(0));
    assertEquals("|MedhashreeAdhikari|", myNameVFlippedTwice.row(1));
    assertEquals("|+-+               |", myNameVFlippedTwice.row(2));
    assertEquals("||m|               |", myNameVFlippedTwice.row(3));
    assertEquals("|+-+               |", myNameVFlippedTwice.row(4));
    assertEquals("+------------------+", myNameVFlippedTwice.row(5));
  }

  // flipped vertically three times
  @Test
  public void VFlip3Test() throws Exception {
    assertEquals("+------------------+", myNameBoxVFlippedThrice.row(0));
    assertEquals("|+-+               |", myNameBoxVFlippedThrice.row(1));
    assertEquals("||m|               |", myNameBoxVFlippedThrice.row(2));
    assertEquals("|+-+               |", myNameBoxVFlippedThrice.row(3));
    assertEquals("|MedhashreeAdhikari|", myNameBoxVFlippedThrice.row(4));
    assertEquals("+------------------+", myNameBoxVFlippedThrice.row(5));
  }

  // nothing to flip
  @Test
  public void emptyVFlipTest() throws Exception {
    assertEquals("", emptyVFlip.row(0));
  }

  /**
   * +-----------------+--------------------------------------
   * | Flip Both Tests |
   * +-----------------+
   */

  @Test
  public void bothFlippedVCompTest() throws Exception {
    assertEquals("  irakihdA", fullNameBothFlippedVComp.row(0));
    assertEquals("eerhsahdeM", fullNameBothFlippedVComp.row(1));
  }

  // flipped vertically two times
  @Test
  public void bothFlip2Test() throws Exception {
    assertEquals("Medhashree", myNameBothFlippedTwice.row(0));
    assertEquals("Adhikari  ", myNameBothFlippedTwice.row(1));
  }

  // flipped vertically three times
  @Test
  public void bothFlip3Test() throws Exception {
    assertEquals("  irakihdA", myNameBoxBothFlippedThrice.row(0));
    assertEquals("eerhsahdeM", myNameBoxBothFlippedThrice.row(1));
  }

  // nothing to flip
  @Test
  public void emptyBothFlipTest() throws Exception {
    assertEquals("", emptyBothFlip.row(0));
  }

  /**
   * +----------------------+---------------------------------
   * | Left Justified Tests |
   * +----------------------+
   */

  // left justifies so the width is 23
  @Test
  public void LJFullNameTest() throws Exception {
    assertEquals("MedhashreeAdhikari     ", LJFullName.row(0));
  }

  @Test
  public void LJEmptyTest() throws Exception {
    assertEquals("                       ", LJEmpty.row(0));
  }

  @Test
  public void LJFullNameBoxTest() throws Exception {
    assertEquals("+------------------+   ", LJFullNameBox.row(0));
    assertEquals("|MedhashreeAdhikari|   ", LJFullNameBox.row(1));
    assertEquals("|+-+               |   ", LJFullNameBox.row(2));
    assertEquals("||m|               |   ", LJFullNameBox.row(3));
    assertEquals("|+-+               |   ", LJFullNameBox.row(4));
    assertEquals("+------------------+   ", LJFullNameBox.row(5));
  }

  @Test
  public void LJMyName2BoxTest() throws Exception {
    assertEquals("+-----------------------+", LJMyNameBoxBox.row(0));
    assertEquals("|+------------+         |", LJMyNameBoxBox.row(1));
    assertEquals("||+----------+|         |", LJMyNameBoxBox.row(2));
    assertEquals("|||Medhashree||         |", LJMyNameBoxBox.row(3));
    assertEquals("||+----------+|         |", LJMyNameBoxBox.row(4));
    assertEquals("|+------------+         |", LJMyNameBoxBox.row(5));
    assertEquals("+-----------------------+", LJMyNameBoxBox.row(6));
  }

  /**
   * +-------------+------------------------------------------
   * | Equal Tests |
   * +-------------+
   */

  // returns true becasue it is the same output
  @Test
  public void equalFullNameTest() throws Exception {
    assertEquals(true, TBUtils.equal(fullNameHComp, fullNameVFlippedHComp));
  }

  // returns true becasue it is the same output
  @Test
  public void equalWidthTruncTest() throws Exception {
    assertEquals(true, TBUtils.equal(nameWidth, fakeTruncMyName));
  }

  // returns true becasue it is the same output
  @Test
  public void equalDiffFlipTest() throws Exception {
    assertEquals(true, TBUtils.equal(emptyBothFlip, emptyVFlip));
  }

  /**
   * +-----------+--------------------------------------------
   * | Eqv Tests |
   * +-----------+
   */

  @Test
  public void eqvTrueFullNameTest() throws Exception {
    assertEquals(true, TBUtils.eqv(fullNameBothFlippedVComp, copyMyNameHFlippedTwice));
  }

  @Test
  public void eqvFullNameTest() throws Exception {
    assertEquals(false, TBUtils.eqv(fullNameBothFlippedVComp, myNameBoxBothFlippedThrice));
  }

  @Test
  public void eqvWidthTruncTest() throws Exception {
    assertEquals(false, TBUtils.eqv(nameWidth, fakeTruncMyName));
  }

  @Test
  public void eqvDiffFlipTest() throws Exception {
    assertEquals(false, TBUtils.eqv(emptyBothFlip, emptyVFlip));
  }

  /**
   * +----------+---------------------------------------------
   * | Eq Tests |
   * +----------+
   */

  @Test
  public void eqTrueNameTest() throws Exception {
    assertEquals(false, TBUtils.eq(copyMyName, myName));
  }

  @Test
  public void eqFlippedNameTest() throws Exception {
    assertEquals(false, TBUtils.eq(fullNameBothFlippedVComp, copyMyNameHFlippedTwice));
  }

  @Test
  public void eqTrueFlipNameTest() throws Exception {
    assertEquals(true, TBUtils.eq(fullNameVFlippedHComp, fullNameVFlippedHComp));
  }

  @Test
  public void eqFlipNameTest() throws Exception {
    assertEquals(false, TBUtils.eq(fullNameHComp, fullNameVFlippedHComp));
  }

  @Test
  public void eqWidthTruncTest() throws Exception {
    assertEquals(false, TBUtils.eq(nameWidth, fakeTruncMyName));
  }

  @Test
  public void eqDiffFlipTest() throws Exception {
    assertEquals(false, TBUtils.eq(emptyBothFlip, emptyVFlip));
  }
} // class AllTests
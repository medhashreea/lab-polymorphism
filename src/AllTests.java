import java.beans.Transient;

import org.junit.Test;

public class AllTests {
  // +-----------------------+--------------------------------
  // | TextBlock Declaration |
  // +-----------------------+

  // constant width truncate
  private int truncWidth = 8;

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
  private TextBlock myLastNameBox;

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
  // --> use general cases

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
  private TextBlock fullNameFlipped;
  private TextBlock fullNameFlippedTwice;
  private TextBlock fullNameboxFlippedThrice;

  // left justify
  // --> use general cases

  // Equal

  // Eqv

  // Eq

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
    myLastNameBox = new BoxedBlock(new TextLine("Adhikari"));

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
    evenNumSpcMyNameBoxBox = new Centered(myNameBoxBox, myName.width() + 8);
    centerEmpty = new Centered(empty, 4);

    // right justify
    // --> use general cases

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
    fullNameFlipped = new FlipBoth(fullNameHFlippedVComp);
    fullNameFlippedTwice = new FlipBoth(new FlipBoth(fullNameHFlippedVComp));
    fullNameboxFlippedThrice = new FlipBoth(new FlipBoth(new FlipBoth(fullNameHFlippedVComp)));

    // left justify
    // --> use general cases

    // Equal

    // Eqv

    // Eq

  } // test initialization

  /**
   * +----------------+---------------------------------------
   * | Truncate Tests |
   * +----------------+
   */

  @Test
  public void basicTruncTest() throws Exception {
    assertEquals(
      "Medhashr", 
      truncMyName, 
      "basic truncate");
  }
  
  @Test
  public void fakeTruncTest() throws Exception {
    assertEquals(
      "Medhashree", 
      fakeTruncMyName, 
      "width is the size of the TextBlock, so truncate nothing");
  }

  @Test
  public void truncAll() throws Exception {
    assertEquals(
      "",
      emptyMyName, 
      "truncate the width, so nothing is left"
    )
  }

  // test to truncate an empty string
  @Test
  public void emptyTruncTest() throws Exception {
    assertEquals(
      "", 
      truncEmpty,
      "truncating an empty string results to an empty string");
  }

  @Test
  public void oneItemTest() throws Exception {
    assertEquals("+-", truncOneItem.row(0), "row zero of truncating one item to width 2");
    assertEquals("|m", truncOneItem.row(1), "row one of truncating one item to width 2");
    assertEquals("+-", truncOneItem.row(2), "row two of truncating one item to width 2");
  }

  @Test
  public void truncDoubleBoxTest() throws Exception {
    assertEquals("+-------", truncOneItem.row(0), "row zero of truncating to width 8");
    assertEquals("|Medhash", truncOneItem.row(1), "row one of truncating to width 8");
    assertEquals("|+-+", truncOneItem.row(2), "row two of truncating to width 8");
    assertEquals("||m|", truncOneItem.row(3), "row three of truncating to width 8");
    assertEquals("|+-+", truncOneItem.row(4), "row four of truncating to width 8");
    assertEquals("+-------", truncOneItem.row(5), "row five of truncating to width 8");
  }

  /**
   * +----------------+---------------------------------------
   * | Centered Tests |
   * +----------------+
   */

  /**
   * +-----------------------+--------------------------------
   * | Right Justified Tests |
   * +-----------------------+
   */

  /**
   * +----------------------------+---------------------------
   * | Horizontally Flipped Tests |
   * +----------------------------+
   */

  /**
   * +--------------------------+-----------------------------
   * | Vertically Flipped Tests |
   * +--------------------------+
   */

  /**
   * +-----------------+--------------------------------------
   * | Flip Both Tests |
   * +-----------------+
   */
  /**
   * +----------------------+---------------------------------
   * | Left Justified Tests |
   * +----------------------+
   */

  /**
   * +-------------+------------------------------------------
   * | Equal Tests |
   * +-------------+
   */
  
   /**
   * +-----------+--------------------------------------------
   * | Eqv Tests |
   * +-----------+
   */
  
   /**
   * +----------+---------------------------------------------
   * | Eq Tests |
   * +----------+
   */

} // class AllTests
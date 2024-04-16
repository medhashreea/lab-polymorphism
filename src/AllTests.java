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
  private TextBlock myNameBox;
  private TextBlock myNameBoxBox;
  private TextBlock myLastNameBox;

  // truncate
  private TextBlock truncMyName;
  private TextBlock fakeTruncMyName;
  private TextBlock emptyMyName;
  private TextBlock truncEmpty;
  private TextBlock truncEmptyBox;
  private TextBlock truncOneItem;
  private TextBlock truncMyNameBox;
  private TextBlock truncMyNameBoxBox;

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
    myNameBox = new BoxedBlock(new TextLine("Medhashree"));
    myNameBoxBox = new BoxedBlock(new BoxedBlock(new TextLine("Medhashree")));
    myLastNameBox = new BoxedBlock(new TextLine("Adhikari"));

    // truncate
    truncMyName = new Truncated(myName, truncWidth);
    fakeTruncMyName = new Truncated(myName, 10);
    emptyMyName = new Truncated(myName, 0);
    truncEmpty = new Truncated(empty, 0);
    truncOneItem = new Truncated(oneItem, 2);
    truncMyNameBox = new Truncated(myNameBox, truncWidth);
    truncMyNameBoxBox = new Truncated(myNameBoxBox, truncWidth);

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
    myNameHFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(myNameBox));
    myNameBoxHFlippedThrice = new HorizontallyFlipped(new HorizontallyFlipped(new HorizontallyFlipped(myNameBox)));
    emptyHFlip = new HorizontallyFlipped(empty);

    // vertically flip
    fullNameVFlippedHComp = new VerticallyFlipped(fullNameHComp);
    fullNameVFlippedVComp = new VerticallyFlipped(fullNameVComp);
    myNameVFlippedTwice = new VerticallyFlipped(new VerticallyFlipped(myNameBox));
    myNameBoxVFlippedThrice = new VerticallyFlipped(new VerticallyFlipped(new VerticallyFlipped(myNameBox)));
    emptyVFlip = new VerticallyFlipped(empty);

    // flip both
    fullNameFlipped = new FlipBoth(fullNameHFlippedVComp);
    fullNameFlippedTwice = new FlipBoth(new FlipBoth(fullNameHFlippedVComp));
    fullNameboxFlippedThrice = new FlipBoth(new FlipBoth(new FlipBoth(fullNameHFlippedVComp)));

    // left justify
    // --> use general cases

    // Equal

    // Eqv

    //Eq

  } // test initialization

  /**
   * +----------------+---------------------------------------
   * | Truncate Tests |
   * +----------------+
   */



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
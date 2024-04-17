import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Medhashree Adhikari
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    // TextBlock block = new TextLine("Hello");

    // Print out the block
    // TBUtils.print(pen, block);

    /**
     * +-------------------------+------------------------------
     * | Exercise 3 : Boxed Text |
     * +-------------------------+------------------------------
     */
    // TextBlock emptBlk = new TextLine("");
    // TextBlock block1 = new TextLine("Hello World!");
    // BoxedBlock box1 = new BoxedBlock(block1);
    // BoxedBlock box2 = new BoxedBlock(box1);
    // BoxedBlock emptBox = new BoxedBlock(emptBlk);

    // TBUtils.print(pen,box1);
    // TBUtils.print(pen,box2);
    // TBUtils.print(pen,emptBox);
    // Clean up after ourselves.

    /**
     * +-----------------------------+--------------------------
     * | Exercise 4 : Composing Text |
     * +-----------------------------+--------------------------
     */
    TextBlock block1 = new TextLine("Hello");
    TextBlock block2 = new TextLine("Goodbye");
    // a.
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TBUtils.print(pen,boxedVBox);

    // b.
    // BoxedBlock box1 = new BoxedBlock(block1);
    // BoxedBlock box2 = new BoxedBlock(block2);
    // VComposition boxedV = new VComposition(box1, box2);
    // TBUtils.print(pen, boxedV);

    // c.
    // BoxedBlock box1 = new BoxedBlock(block1);
    // HComposition boxedH1 = new HComposition(box1, block2);
    // TBUtils.print(pen, boxedH1);

    // d.
    // BoxedBlock box1 = new BoxedBlock(block1);
    // HComposition boxedH2 = new HComposition(block2, box1);
    // TBUtils.print(pen, boxedH2);

    /**
     * +-----------+--------------------------------------------
     * | Truncated |
     * +-----------+--------------------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock truncBox;
    // truncBox = new Truncated(boxedVBox, 5);
    // TBUtils.print(pen, truncBox);

    /**
     * +----------+---------------------------------------------
     * | Centered |
     * +----------+---------------------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock centerBox;
    // centerBox = new Centered(boxedVBox, 18);
    // TBUtils.print(pen, centerBox);

    /**
     * +-----------------+--------------------------------------
     * | Right Justified |
     * +-----------------+--------------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock RJBox;
    // RJBox = new RightJustified(boxedVBox, 18);
    // TBUtils.print(pen, RJBox);

    // BoxedBlock boxed = new BoxedBlock(RJBox);
    // TBUtils.print(pen, boxed);

    /**
     * +----------------------+---------------------------------
     * | Horizontally Flipped |
     * +----------------------+---------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock HFlip;
    // HFlip = new HorizontallyFlipped(boxedVBox);
    // // HFlip = new HorizontallyFlipped(new HorizontallyFlipped(boxedVBox));
    // TBUtils.print(pen, HFlip);

    /**
     * +--------------------+-----------------------------------
     * | Vertically Flipped |
     * +--------------------+-----------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock VFlip;
    // VFlip = new VerticallyFlipped(boxedVBox);
    // // VFlip = new VerticallyFlipped(new VerticallyFlipped(boxedVBox));
    // TBUtils.print(pen, VFlip);

    /**
     * +-----------+--------------------------------------------
     * | Flip Both |
     * +-----------+--------------------------------------------
     */
    // ******************* //
    // ISSUE
    // BothFilp = new FlipBoth(new FlipBoth(boxedVBox));
    // DOES NOT WORK
    // ******************* //
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock BothFilp;
    // BothFilp = new FlipBoth(boxedVBox);
    // // BothFilp = new FlipBoth(new FlipBoth(new FlipBoth(boxedVBox)));
    // TBUtils.print(pen, BothFilp);

    /**
     * +----------------+---------------------------------------
     * | Left Justified |
     * +----------------+---------------------------------------
     */
    // VComposition VBox1 = new VComposition(block1, block2);
    // BoxedBlock boxedVBox = new BoxedBlock(VBox1);
    // TextBlock LJBox;
    // LJBox = new LeftJustified(boxedVBox, 18);
    // // TBUtils.print(pen, LJBox);

    // BoxedBlock boxed = new BoxedBlock(LJBox);
    // TBUtils.print(pen, boxed);

    // TextBlock myName = new TextLine("Medhashree");
    // TextBlock myLastName = new TextLine("Adhikari");
    // TextBlock empty = new TextLine("");
    // TextBlock oneItem = new BoxedBlock(new TextLine("m"));
    // TextBlock myNameBox = new BoxedBlock(new TextLine("Medhashree"));
    // TextBlock myNameBoxBox = new BoxedBlock(new BoxedBlock(new TextLine("Medhashree")));
    // TextBlock myLastNameBox = new BoxedBlock(new TextLine("Adhikari"));
    // TextBlock truncOneItem = new Truncated(oneItem, 2);
    // TextBlock evenNumSpcMyName = new Centered(myName, myName.width() + 8);
    // TextBlock oddNumSpcMyName = new Centered(myName, myName.width() + 13);
    // TextBlock nameWidth = new Centered(myName, myName.width());
    // TextBlock evenNumSpcMyNameBoxBox = new Centered(myNameBoxBox, myName.width() + 8);
    // TextBlock centerEmpty = new Centered(empty, 4);
    // truncOneItem = new Truncated(oneItem, 2);
    TextBlock myName = new TextLine("Medhashree");
    TextBlock myLastName = new TextLine("Adhikari");
    TextBlock fullNameHComp = new HComposition(myName, myLastName);
    TextBlock fullNameVComp = new VComposition(myName, myLastName);
    TextBlock oneItem = new BoxedBlock(new TextLine("m"));

    TextBlock truncMyNameBox = new Truncated((new BoxedBlock(new VComposition(fullNameHComp, oneItem))), 8);
    TBUtils.print(pen, truncMyNameBox);

    pen.close();
  } // main(String[])
} // class TBExpt

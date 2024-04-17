/**
 * Right Justifies the TextBlock.
 * 
 * @author Medhashree Adhikari
 */
public class RightJustified implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // text we want right justified
  private TextBlock textContents;

  // how much space on each side
  private int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * create a new text block where the input text will be
   * right justified respective to the width input
   * 
   * @param text
   * @param width
   * @throws Exception
   */
  public RightJustified(TextBlock text, int width) throws Exception {
    if (text.width() > width) {
      throw new Exception("Invalid! Enter a width greater than or equal to the length of the block!");
    }
    this.textContents = text;
    this.width = width;
  } // RightJustified(text, width)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * elements returns a TextBlock array that contains the elements of the
   * TextBlock, or empty
   */
  public TextBlock[] elements() {
    return new TextBlock[] { this.textContents };
  } // elements()

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    // if the height is invalid, throw exception
    if ((i >= this.height()) || (i < 0)) {
      throw new Exception("Invalid! Enter a height less than " + height() + "!");
    }

    // calculating space
    int leftSpcNum = this.width - this.textContents.width();

    // formating text
    String spc = " ";
    String leftSpc = spc.repeat(leftSpcNum);

    return leftSpc + this.textContents.row(i);
  } // row(i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.textContents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  } // width()
} // class RightJustified
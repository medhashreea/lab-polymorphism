/**
 * Horizontally and vertically flips the text.
 * 
 * @author Medhashree Adhikari
 */
public class FlipBoth implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // text we want horizontally and vertically flip
  private TextBlock textContents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * create a new text block where the input text will be 
   * flipped horizontally and vertically
   * 
   * @param text
   */
  public FlipBoth(TextBlock text) {
    this.textContents = text;
  }

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
    if ((i >= this.height()) || (i < 0)) {
      throw new Exception("Invalid! Enter a height less than " + height() + "!");
    }

    // flips vertically then reverses
    return new StringBuilder(textContents.row(this.height() - (i + 1))).reverse().toString();

  } // row(i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.textContents.width();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.textContents.height();
  } // width()
}

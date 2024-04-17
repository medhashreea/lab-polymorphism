/**
 * Horizontally flips the text.
 * 
 * @author Medhashree Adhikari
 */
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // text we want to horizontally flip
  private TextBlock textContents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * create a new text block where the input text will be flipped horizontally
   * 
   * @param text
   */
  public HorizontallyFlipped(TextBlock text) {
    this.textContents = text;
  } // HorizontallyFlipped(text)

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

    return new StringBuilder(textContents.row(i)).reverse().toString();
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
    return this.textContents.width();
  } // width()
} // class HorizontallyFlipped
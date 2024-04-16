/**
 * Truncates the box at the given index.
 * 
 * @author Medhashree Adhikari
 */
public class Truncated implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  // truncated portion of the block
  private TextBlock textContents;

  // how much will be truncated
  private int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * create a new text block where the input text will be 
   * truncated respective to the width input
   * 
   * @throws Exception
   */
  public Truncated(TextBlock text, int width) throws Exception {
    if ((width < 0) || (text.width() < width)) {
      throw new Exception("Invalid! Enter a valid width between 0 and length of the block!");
    }
    this.textContents = text;
    this.width = width;
  } // Truncated(text, width)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * elements returns a TextBlock array that contains the elements of the 
   * TextBlock, or empty
   */
  public TextBlock[] elements() {
    return new TextBlock[] {this.textContents};
  } // elements()

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    if ((i >= this.height()) || (i < 0)) {
      throw new Exception("Invalid! Enter a valid height between 0 and " + height() + "!");
    }
    // splits the text from 0 to the portion to truncate
    return textContents.row(i).substring(0, this.width());
  } // row(int i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return textContents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  } // width()
} // class Truncated

/**
 * Centers the text.
 * 
 * @author Medhashree Adhikari
 */
public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  // text we want in the center
  private TextBlock textContents;

  // how much space on each side
  private int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * create a new text block where the input text will be 
   * centered respective to the width input
   * 
   * @param text
   * @param width
   * @throws Exception
   */
  public Centered(TextBlock text, int width) throws Exception {
    // if given width is less than the width of the text
    if (width < text.width()) {
      throw new Exception ("Invalid! Enter a width greater than or equal to the length of the block!");
    }

    this.textContents = text;
    this.width = width;
  }

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
    // if the height is invalid, throw exception
    if ((i >= this.height()) || (i < 0)) {
      throw new Exception("Invalid! Enter a valid height between 0 and " + height() + "!");
    }

    // calculating spaces
    int numSpaces = this.width - this.textContents.width();
    int leftSpcNum = numSpaces/2; // spaces before the text
    int rightSpcNum = numSpaces - leftSpcNum; // spaces after the text
    
    // formating text
    String spc = " ";
    String leftSpc = spc.repeat(leftSpcNum);
    String rightSpc = spc.repeat(rightSpcNum);

    return leftSpc + this.textContents.row(i) + rightSpc;
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
} // class Centered
import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Medhashree Adhikari
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program
   * operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program
   * operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  // +-----------------+---------------------------------------------------
  // | Equality Checks |
  // +-----------------+
  /**
   * check to see if TextBlocks t1 and t2 have the same lines
   * 
   * @param t1
   * @param t2
   * @return bool
   * @throws Exception
   */
  static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    if (t1.height() != t2.height()) {
      return false;
    } // condtion check height

    for (int i = 0; i < t1.height(); i++) {
      try {
        if (!t1.row(i).equals(t2.row(i))) {
          return false;
        } // condtion check
      } catch (Exception e) {
        return false;
      } // try/catch
    } // loop
    return true;
  } // equal(t1, t2)

  /**
   * checks if it was built the same
   * 
   * @param t1
   * @param t2
   * @return
   * @throws Exception
   */
  static boolean eqv(TextBlock t1, TextBlock t2) throws Exception {
    // if the lines are the same,
    if ((equal(t1, t2)) &&
        (t1.elements().length == t2.elements().length) &&
        (t1.getClass() == t2.getClass())) {
      // if the length of t1 is 0, then true
      if (t1.elements().length == 0) {
        return true;
      } // else

      boolean _final = true;

      for (int i = 0; i < t1.elements().length; i++) {
        // update final with true and false
        _final = _final && eqv(t1.elements()[i], t2.elements()[i]);
      } // loop

      return _final;
    } else {
      // if the check is not true
      return false;
    } // condition check
  } // eqv(t1, t2)

  /**
   * check if t1 and t2 are same in memory location
   * 
   * @param t1
   * @param t2
   * @return
   */
  static boolean eq(TextBlock t1, TextBlock t2) {
    return (t1 == t2);
  } // eq(t1, t2)

} // class TBUtils

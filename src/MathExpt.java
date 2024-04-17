import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A few simple experiments with our utilities.
 *
 * @author Samuel A. Rebelsky
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    pen.println("Integer");
    // Print some square roots.
    for (Integer i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("Float");
    for (Float i = Float.valueOf(2); i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("Double");
    for (double i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("BigInteger");
    for (BigInteger i = BigInteger.valueOf(2); i.compareTo(BigInteger.valueOf(10)) < 0; i = i
        .add(BigInteger.valueOf(1))) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("BigDecimal");
    for (BigDecimal i = BigDecimal.valueOf(2); i.compareTo(BigDecimal.valueOf(10)) < 0; i = i
        .add(BigDecimal.valueOf(1))) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("double");
    for (double i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("int");
    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt

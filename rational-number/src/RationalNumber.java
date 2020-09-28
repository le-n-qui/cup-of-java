/**
 * A class that supports rational numbers
 * @author Qui Le
 */

public class RationalNumber
{
  private long numerator;
  private long denominator;

  /**
   * Constructor: making objects of RationalNumber class
   * @param n numerator
   * @param d denominator
   */
  public RationalNumber(long n, long d)
  {
    if (d == 0)
      throw new IllegalArgumentException("Input for denominator cannot be zero.");

    if (d < 0)
    {
      numerator = -n;
      denominator = -d;
    }
    else {
      numerator = n;
      denominator = d;
    }

    // Simplify the fraction to get reduced form
    reduce();
  }

  /**
   * Get this object's numerator and denominator
   * @return the string representation of rational number
   */
  public String toString()
  {
    return numerator + "/" + denominator;
  }

  /**
   * Get this object's numerator
   * @return numerator
   */
  public final long getNumerator()
  {
    return numerator;
  }

  /**
   * Get this object's denominator
   * @return denominator
   */
  public final long getDenominator()
  {
    return denominator;
  }

  /**
   * Reduce fraction
   */
  private void reduce()
  {
    long biggestCommonDenom = gcd(numerator, denominator);
    numerator /= biggestCommonDenom;
    denominator /= biggestCommonDenom;
  }

  /**
   * Find the greatest common divisor
   * @param num1 first number
   * @param num2 second number
   * @return greatest common divisor
   */
  private long gcd(long num1, long num2)
  {
    if (num1 < 0)
      num1 = -num1;

    while (num2 > 0)
    {
      long remainder = num1 % num2;
      num1 = num2;
      num2 = remainder;
    }
    return num1;
  }

  /**
   * Add two rational numbers
   * @param other other rational number
   */
  public void add(RationalNumber other)
  {
    // If denominator of our rational number
    // is equal to that of other rational number
    if (denominator == other.getDenominator()) {
      // Just add the numerators together
      numerator += other.getNumerator();
    }
    else {
      // Find the numbers that will help convert our rational number
      // and the other rational number into their equivalent fractions
      long[] multiplicand = lowestCommonDenominator(denominator, other.getDenominator());
      // Convert both our numerator and denominator into their equivalents
      numerator *= multiplicand[0];
      denominator *= multiplicand[0];
      // Convert other numerator into the equivalent
      long otherNumerator = other.getNumerator() * multiplicand[1];
      // We only need to add other numerator into our numerator
      numerator += otherNumerator;
      // Reduce our rational number
      reduce();
    }
  }

  /**
   * Find the lowest common denominator
   * @param num1 first denominator
   * @param num2 second denominator
   * @return lowest common denominator
   */
  private long[] lowestCommonDenominator(long num1, long num2)
  {
    long[] tuple = new long[2];
    long denominator1 = num1;
    long denominator2 = num2;
    long addCounter1 = 1; // denominator1 is itself included; so start counter at 1
    long addCounter2 = 1; // ditto
    // Finding the multiple that is divisible by both denominators
    while (denominator1 != denominator2) {
      if (denominator1 < denominator2) {
        denominator1 += num1;
        addCounter1 += 1;
      } else {
        denominator2 += num2;
        addCounter2 += 1;
      }
    }
    // Keep counters in array to be returned
    tuple[0] = addCounter1;
    tuple[1] = addCounter2;

    return tuple;
  }
}
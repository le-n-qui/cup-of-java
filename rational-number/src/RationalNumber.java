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
    if (denominator == other.getDenominator()) {
      numerator += other.getNumerator();
    }
    else {
      long[] multiples = lowestCommonDenominator(denominator, other.getDenominator());
      numerator *= multiples[0];
      denominator *= multiples[0];

      long otherNumerator = other.getNumerator() * multiples[1];

      numerator += otherNumerator;

      reduce();
    }
  }

  /**
   * Find the lowest common denominator
   */
  private long[] lowestCommonDenominator(long num1, long num2)
  {
    long[] tuple = new long[2];
    long num1_counter = 1; // num1 is itself included; so start counter at 1
    long num2_counter = 1; // ditto
    while (num1 != num2) {
      if (num1 < num2) {
        num1 += num1;
        num1_counter += 1;
      } else {
        num2 += num2;
        num2_counter += 1;
      }
    }
    // Keep counters in array to be returned
    tuple[0] = num1_counter;
    tuple[1] = num2_counter;

    return tuple;
  }
}
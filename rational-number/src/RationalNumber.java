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
    if (d < 0)
    {
      numerator = -n;
      denominator = -d;
    }
    else {
      numerator = n;
      denominator = d;
    }
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
}
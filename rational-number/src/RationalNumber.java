/**
 * A class that supports rational numbers
 * @author Qui Le
 */

public class RationalNumber
{
  private long numerator;
  private long denominator;

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

  public String toString()
  {
    return numerator + "/" + denominator;
  }

  public final long getNumerator()
  {
    return numerator;
  }

  public final long getDenominator()
  {
    return denominator;
  }
}
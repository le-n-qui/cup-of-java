/**
 * Test fixture for RationalNumber class
 * @author Qui Le
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class RationalNumberTest
{
  private RationalNumber ratNum1;
  private RationalNumber ratNum2;
  private RationalNumber ratNum3;
  private RationalNumber ratNum4;

  @Before
  public void setUp()
  {
    ratNum1 = new RationalNumber(4,5);
    ratNum2 = new RationalNumber(2, -3);
    ratNum3 = new RationalNumber(5, 10);
    ratNum4 = new RationalNumber(1, 5);
  }

  @Test
  public void verifyProperPositiveRationalNumber()
  {
    assertEquals(4, ratNum1.getNumerator());
    assertEquals(5, ratNum1.getDenominator());
  }

  @Test
  public void verifyProperNegativeRationalNumber()
  {
    assertEquals(-2, ratNum2.getNumerator());
    assertEquals(3, ratNum2.getDenominator());
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkDenominatorBeingZero()
  {
    RationalNumber num = new RationalNumber(3,0);
  }

  @Test
  public void testReducedRationalNumber()
  {
    assertEquals(1, ratNum3.getNumerator());
    assertEquals(2, ratNum3.getDenominator());
  }

  @Test
  public void addRationalNumbers()
  {
    ratNum1.add(ratNum3);
    assertEquals(13, ratNum1.getNumerator());
    assertEquals(10, ratNum1.getDenominator());
    ratNum1.add(ratNum4);
    assertEquals(3, ratNum1.getNumerator());
    assertEquals(2, ratNum1.getDenominator());
  }
}
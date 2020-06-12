public class Customer {
  private String food;
  /**
   * Constructor without argument
   */
  public Customer() {
    food = "";
  }

  /**
   * Constructor with argument
   */
  public Customer(String food) {
    this.food = food;
  }

  /**
   * Place order
   */
  public void placeOrder(String foodName, Employee emp) {
    food = emp.takeOrder(foodName);
  }

  /**
   * Print food name
   */
  public void printFood() {
    System.out.println("Thanks for the " + food + ".\nHave a wonderful day!");
  }

}

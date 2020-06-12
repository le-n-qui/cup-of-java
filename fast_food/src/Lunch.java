public class Lunch {
  // private fields
  private Customer guest;
  private Employee worker;

  /**
   * Constructor
   */
  public Lunch(Customer c, Employee e) {
    guest = c;
    worker = e;
  }

  /**
   * Request order from Customer
   */
  public void requestOrder(String foodName) {
    guest.placeOrder(foodName, worker);
  }

  /**
   * Show result
   */
  public void result() {
    // ask customer to print food name received from waiter
    guest.printFood();
  }
}

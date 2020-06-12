public class Restaurant {

  public static void main(String[] args) {
    Customer c = new Customer();
    Employee e = new Employee();
    Lunch l = new Lunch(c, e);
    l.requestOrder("Vietnamese sandwich");
    l.result();
    l.requestOrder("Spaghetti with Meatballs");
    l.result();
  }
}

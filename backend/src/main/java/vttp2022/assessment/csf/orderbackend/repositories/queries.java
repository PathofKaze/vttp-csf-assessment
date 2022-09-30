package vttp2022.assessment.csf.orderbackend.repositories;

public interface queries {
    public static final String SQL_INSERT_ORDER =
      "insert into orders(order_id, name, email, size, thick_crust, sauce, toppings, comments) values (?,?,?,?,?,?,?,?)";

    public static final String SQL_SELECT_BY_EMAIL =
      "select order_id, size, thick_crust, sauce, toppings from orders where email=";
}
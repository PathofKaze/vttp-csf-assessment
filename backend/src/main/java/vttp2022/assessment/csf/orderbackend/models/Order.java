package vttp2022.assessment.csf.orderbackend.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

// IMPORTANT: You can add to this class, but you cannot delete its original content

public class Order {

	private Integer orderId;
	private String name;
	private String email;
	private Integer size;
	private String sauce;
	private Boolean thickCrust;
	private List<String> toppings = new LinkedList<>();
	private String comments;

	public void setOrderId(Integer orderId) { this.orderId = orderId; }
	public Integer getOrderId() { return this.orderId; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return this.email; }

	public void setSize(Integer size) { this.size = size; }
	public Integer getSize() { return this.size; }

	public void setSauce(String sauce) { this.sauce = sauce; }
	public String getSauce() { return this.sauce; }

	public void setThickCrust(Boolean thickCrust) { this.thickCrust = thickCrust; }
	public Boolean isThickCrust() { return this.thickCrust; }

	public void setToppings(List<String> toppings) { this.toppings = toppings; }
	public List<String> getToppings() { return this.toppings; }
	public void addTopping(String topping) { this.toppings.add(topping); }

	public void setComments(String comments) { this.comments = comments; }
	public String getComments() { return this.comments; }
}

public static Order create(String json) {

	JsonReader reader = Json.createReader(new StringReader(json));
	JsonObject data = reader.readObject();

	final Order ord = new Order();
	ord.setName(data.getString("name"));
	ord.setEmail(data.getString("email"));
	ord.setSize(data.getInt("size"));
	ord.setSauce(data.getString("sauce"));
	if (data.containsValue("thick")) {
		ord.setThickCrust(true); }
	else {
		ord.setThickCrust(false); }
	for (length.topping)
	ord.setToppings(addTopping(data.getString("toppings")));
	ord.setComments(data.getVoid(("comments"));

	return ord;
}

public JsonObject toJson() {
	return Json.createObjectBuilder()
		.add("id", id)
		.add("name", name)
		.add("email", email)
		.build();
}

public static Order create(SqlRowSet rs) {
	Order order = new Order();
	order.setName(rs.getString("name"));
	order.setEmail(rs.getString("email"));
	order.setSize(rs.getInt("size"));
	order.setSauce(rs.getString("sauce"));
	order.setThickCrust(rs.getBoolean("String"));
	order.setToppings(rs.getString("image_url"));
	return order;
}

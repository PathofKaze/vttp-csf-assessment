package vttp2022.assessment.csf.orderbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.assessment.csf.orderbackend.models.Order;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.services.OrderService;
import vttp2022.assessment.csf.orderbackend.models.OrderResponse;;

@RestController
@RequestMapping(path="/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {
    
    Order ord;
    OrderSummary ords;

    @Autowired
    private OrderService orderSvc;
    
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createOrder(@RequestBody String payload) {
            try {
                ord = Order.create(payload);
            } catch (Exception ex) {
                OrderResponse resp = new OrderResponse();
                resp.setStatus(400);
                resp.setMessage(ex.getMessage());
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(resp.toJson().toString());
        }

        @GetMapping(path="api/order/{email}")
        public ResponseEntity<String> getOrdersByEmail(@PathVariable String email) {

        List<OrderSummary> summaries = orderSvc.getOrdersByEmail(email);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (OrderSummary summary: summaries)
            arrBuilder.add(summary.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    
    }
}

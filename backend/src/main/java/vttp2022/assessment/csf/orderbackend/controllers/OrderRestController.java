package vttp2022.assessment.csf.orderbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.assessment.csf.orderbackend.services.OrderService;

@RestController
@RequestMapping(path="/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {
    
    @Autowired
    private OrderService orderSvc;
    
        @PostMapping(path="/{email}/all")
        public ResponseEntity<String> getBook(@PathVariable String bookId) {
            Optional<Book> opt = orderSvc.createOrder(bookId);
    
            if (opt.isEmpty()) {
                BookResponse resp = new BookResponse();
                resp.setStatus(404);
                resp.setMessage("Book %s not found".formatted(bookId));
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(resp.toJson().toString());
            }
    
            Book book = opt.get();
    
            return ResponseEntity.ok(book.toJson().toString());
        }
}

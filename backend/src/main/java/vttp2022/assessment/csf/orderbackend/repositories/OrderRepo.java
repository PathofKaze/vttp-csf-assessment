package vttp2022.assessment.csf.orderbackend.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.assessment.csf.orderbackend.models.OrderSummary;

import static vttp2022.assessment.csf.orderbackend.repositories.queries.*;

import java.util.Optional;


@Repository
public class OrderRepo {
 
    @Autowired
    private JdbcTemplate template;

    public Optional<OrderSummary> getOrdersByEmail(String email) {
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_BY_EMAIL, email);
        if (rs.next())
            return Optional.of(OrderSummary.create(rs));
        return Optional.empty();
    }
  
 }
    
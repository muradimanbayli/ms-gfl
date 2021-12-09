package net.imanbayli.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequest {
    private String bookName;
    private String author;
    private BigDecimal price;
    private String currency;
}

package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    Buyer buyer;
    Product product;
    int quantity;


}

package com.example.demo.data;

import lombok.Data;

@Data
public class Product {
    String id; //uuid
    Integer productType; // e.g loan/credit card/credit limit...
    String productTypeName;
    Integer productSubType; //Enum?
    String productSubTypeName; // Enum?
    String productSubTypeDescription;

    
}

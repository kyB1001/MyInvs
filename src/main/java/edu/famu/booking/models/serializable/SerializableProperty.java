package edu.famu.booking.models.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableProperty {

    private String address;
    private String type;
    private int price;
    private int bedrooms;
    private int bathrooms;
    private int squareFeet;
    private int age;
    private String description;

}

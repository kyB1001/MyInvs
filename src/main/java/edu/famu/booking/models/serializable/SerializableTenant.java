package edu.famu.booking.models.serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableTenant {

    private String lastname;

    private String firstname;

    private String phone;

    private String property;

    private String email;

}

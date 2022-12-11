package edu.famu.booking.models.parse;

import edu.famu.booking.models.serializable.SerializableTenant;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Tenant")
public class Tenant extends ParseObject{

    final static String LASTNAME = "lastName";

    final static String PHONE = "phone";

    final static String FIRSTNAME = "firstName";

    final static String PROPERTY = "property";

    final static String EMAIL = "email";

    public String getLastname() {
        return getString(LASTNAME);
    }
    public void setLastname(String lastname) {
        put(LASTNAME, lastname);
    }

    public String getFirstname() {
        return getString(FIRSTNAME);
    }
    public void setFirstname(String firstname) {
        put(FIRSTNAME, firstname);
    }

    public String getPhone() {return getString(PHONE);
    }
    public void setPhone(String phone) {
        put(PHONE, phone);
    }

    public String getProperty() {
        return getString(PROPERTY);
    }
    public void setProperty(String property) {
        put(PROPERTY, property);
    }

    public String getEmail() {
        return getString(EMAIL);
    }
    public void setEmail(String email) {
        put(EMAIL, email);
    }

    public SerializableTenant getSerializable() {
        return new SerializableTenant(
                getLastname(), getFirstname(), getPhone(),
                getProperty(), getEmail()
        );

    }


}

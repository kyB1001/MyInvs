package edu.famu.booking.models.parse;

import edu.famu.booking.models.serializable.SerializableProperty;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Property")
public class Property extends ParseObject{

    final static String ADDRESS = "address";

    final static String TYPE = "type";

    final static String PRICE = "price";

    final static String BEDROOMS = "bedrooms";

    final static String BATHROOMS = "bathrooms";

    final static String SQUAREFEET = "squareFeet";

    final static String AGE = "age";

    final static String DESCRIPTION = "description";

    public String getAddress() {
        return getString(ADDRESS);
    }
    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public String getType() {
        return getString(TYPE);
    }
    public void setType(String type) {
        put(TYPE, type);
    }

    public int getPrice() {
        return getInt(PRICE);
    }
    public void setPrice(int price) {
        put(PRICE, price);
    }

    public int getBedrooms() {
        return getInt(BEDROOMS);
    }
    public void setBedrooms(int bedrooms) {
        put(BEDROOMS, bedrooms);
    }

    public int getBathrooms() {
        return getInt(BATHROOMS);
    }
    public void setBathrooms(int bathrooms) {
        put(BEDROOMS, bathrooms);
    }

    public int getSquareFeet() {
        return getInt(SQUAREFEET);
    }
    public void setSquareFeet(int squareft) {
        put(SQUAREFEET, squareft);
    }

    public int getAge() {
        return getInt(AGE);
    }
    public void setAge(int age) {
        put(AGE, age);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }
    public void setDescription(String description) {
        put(DESCRIPTION, description);
    }


    public SerializableProperty getSerializable() {
        return new SerializableProperty(
                getAddress(), getType(), getPrice(),
                getBedrooms(), getBathrooms(), getSquareFeet(), getAge(),
                getDescription()
        );

    }


}

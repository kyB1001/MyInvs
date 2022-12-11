package edu.famu.booking.services;
import edu.famu.booking.models.parse.Property;
import edu.famu.booking.models.serializable.SerializableProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Property> retrieveProperties(String sort)
    {
        logger.info(Parse.isIsRootMode());
        final ArrayList<Property> properties = new ArrayList<>();

        ParseQuery<Property> query = ParseQuery.getQuery(Property.class);
        List<Property> list = null;

        try {
            for (Property p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                properties.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(properties.size());
        return properties;
    }



    public Property getPropertyById(String id)
    {
        Property property = null;

        //defines the query for the product class
        ParseQuery<Property> query = ParseQuery.getQuery(Property.class);

        try{
            property = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return property;
    }

    public String addProperty(SerializableProperty property)
    {
        String message; //message we will return to the user

        //REMAINING CODE GOES HERE
        Property parseProperty = new Property(); //Parse Product Object

//set the value of each of the fields
        parseProperty.setAddress(property.getAddress());
        parseProperty.setType(property.getType());
        parseProperty.setPrice(property.getPrice());
        parseProperty.setBedrooms(property.getBedrooms());
        parseProperty.setBathrooms(property.getBathrooms());
        parseProperty.setSquareFeet(property.getSquareFeet());
        parseProperty.setAge(property.getAge());
        parseProperty.setDescription(property.getDescription());



        try {
            parseProperty.save(); //runs the query to insert the new value
            message = "Property Created"; //set success the return message

        } catch (ParseException e) {
            e.printStackTrace(); //print the error to the console.
            // set the error return message
            message = "Error creating Property. " + e.getMessage();
        }
        return message;
    }



    public String removeProperty(String id)
    {
        String message;

        ParseQuery<Property> query = ParseQuery.getQuery(Property.class);

        try
        {
            Property property = query.get(id); //get product by id
            property.delete(); //delete product
            message = "Property " + id + " deleted."; //success message
        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error while deleting Property. " + e.getMessage(); //error message
        }
        return message;
    }

}

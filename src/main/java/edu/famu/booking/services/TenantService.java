package edu.famu.booking.services;


import edu.famu.booking.models.parse.Tenant;
import edu.famu.booking.models.serializable.SerializableProperty;
import edu.famu.booking.models.serializable.SerializableTenant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TenantService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Tenant> retrieveTenants(String sort)
    {
        logger.info(Parse.isIsRootMode());
        final ArrayList<Tenant> properties = new ArrayList<>();

        ParseQuery<Tenant> query = ParseQuery.getQuery(Tenant.class);


        try {
            List<Tenant> list = query.find();
            for (Tenant p : list) {
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



    public Tenant getTenantById(String id)
    {
        Tenant tenant = null;

        //defines the query for the product class
        ParseQuery<Tenant> query = ParseQuery.getQuery(Tenant.class);

        try{
            tenant = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return tenant;
    }

    public String addTenant(SerializableTenant tenant)
    {
        String message; //message we will return to the user

        //REMAINING CODE GOES HERE
        Tenant parseTenant = new Tenant(); //Parse Product Object

        //set the value of each of the fields
        parseTenant.setLastname(tenant.getLastname());
        parseTenant.setFirstname(tenant.getFirstname());
        parseTenant.setPhone(tenant.getPhone());
        parseTenant.setEmail(tenant.getEmail());
        parseTenant.setProperty(tenant.getProperty());


        try {
            parseTenant.save(); //runs the query to insert the new value
            message = "Property Created"; //set success the return message

        } catch (ParseException e) {
            e.printStackTrace(); //print the error to the console.
            // set the error return message
            message = "Error creating Property. " + e.getMessage();
        }
        return message;
    }


    public String removeTenant(String id)
    {
        String message;

        ParseQuery<Tenant> query = ParseQuery.getQuery(Tenant.class);

        try
        {
            Tenant tenant = query.get(id); //get product by id
            tenant.delete(); //delete product
            message = "Property " + id + " deleted."; //success message
        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error while deleting Property. " + e.getMessage(); //error message
        }
        return message;
    }

}

package edu.famu.booking.controllers;


import edu.famu.booking.models.parse.Property;
import edu.famu.booking.models.serializable.SerializableProperty;
import edu.famu.booking.services.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/property") //sets up the base url for all calls to methods in this file
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    //get all
    @GetMapping(value = {"/"}) //sets the path to this method
    public ArrayList<SerializableProperty> getHotelList(@RequestParam(name = "sort" , required = false, defaultValue = "asc") String sort) {
        ArrayList<SerializableProperty> rooms = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Property> list = propertyService.retrieveProperties(sort);
        for(Property p : list)
        {
            rooms.add(p.getSerializable());
        }
        return rooms;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableProperty getPropertyById(@PathVariable String id){
        return propertyService.getPropertyById(id).getSerializable();
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable String id)
    {
        return propertyService.removeProperty(id);
    }
}

package edu.famu.booking.controllers;


import edu.famu.booking.models.parse.Property;
import edu.famu.booking.models.parse.Tenant;
import edu.famu.booking.models.serializable.SerializableProperty;
import edu.famu.booking.models.serializable.SerializableTenant;
import edu.famu.booking.services.PropertyService;
import edu.famu.booking.services.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/tenant") //sets up the base url for all calls to methods in this file
public class TenantController {

    private TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    //get all
    @GetMapping(value = {"/"}) //sets the path to this method
    public ArrayList<SerializableTenant> getHotelList(@RequestParam(name = "sort" , required = false, defaultValue = "asc") String sort) {
        ArrayList<SerializableTenant> tenants = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Tenant> list = tenantService.retrieveTenants(sort);
        for(Tenant p : list)
        {
            tenants.add(p.getSerializable());
        }
        return tenants;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableTenant getTenantById(@PathVariable String id){
        return tenantService.getTenantById(id).getSerializable();
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable String id)
    {
        return tenantService.removeTenant(id);
    }

}

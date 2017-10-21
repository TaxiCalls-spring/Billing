package com.taxicalls.billing.services;

import com.taxicalls.billing.model.Trip;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "trip")
public interface TripService {

    @RequestMapping(method = RequestMethod.POST, value = "/drivers/available")
    public List<Trip> getAvailableDrivers(Trip trip);

}

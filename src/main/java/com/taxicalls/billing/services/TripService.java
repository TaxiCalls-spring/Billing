package com.taxicalls.billing.services;

import com.taxicalls.billing.model.Trip;
import com.taxicalls.protocol.Response;
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
    public Response getAvailableDrivers(Trip trip);

}

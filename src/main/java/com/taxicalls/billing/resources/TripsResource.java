package com.taxicalls.billing.resources;

import com.taxicalls.billing.model.Billing;
import com.taxicalls.billing.model.Driver;
import com.taxicalls.billing.model.Passenger;
import com.taxicalls.billing.model.Trip;
import com.taxicalls.billing.service.BillingService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripsResource {

    @Autowired
    private BillingService billingService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createTrip(@RequestBody Trip trip) {
        Billing billing = new Billing();
        billing.setPrice(trip.getAddressTo().getCoordinate().getEuclidienDistance(trip.getAddressFrom().getCoordinate()) / trip.getPassengers().size());
        billing.setFromEntity(Driver.class.getSimpleName());
        billing.setFromId(trip.getDriver().getId());
        billing.setToEntity(Passenger.class.getSimpleName());
        for (Passenger passenger : trip.getPassengers()) {
            billing.setToId(passenger.getId());
            billingService.createBilling(billing);
        }
        return Response.successful(billing);
    }

}

package com.taxicalls.billing.resources;

import com.taxicalls.billing.model.Billing;
import com.taxicalls.billing.service.BillingService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billings")
public class BillingsResource {

    @Autowired
    private BillingService billingService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createBilling(@RequestBody Billing billing) {
        return Response.successful(billingService.createBilling(billing));
    }

    @RequestMapping
    public Response getBillings() {
        return Response.successful(billingService.getBillings());
    }

    @RequestMapping(value = "/{id}")
    public Response getBilling(@PathVariable("id") Long id) {
        Billing billing = billingService.getBilling(id);
        if (billing == null) {
            return Response.notFound();
        }
        return Response.successful(billing);
    }
}

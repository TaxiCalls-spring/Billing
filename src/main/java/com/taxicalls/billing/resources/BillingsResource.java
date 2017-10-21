package com.taxicalls.billing.resources;

import com.taxicalls.billing.model.Billing;
import com.taxicalls.billing.service.BillingService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billings")
public class BillingsResource {

    @Autowired
    private BillingService billingService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Billing createBilling(Billing billing) {
        return billingService.createBilling(billing);
    }

    @RequestMapping("/")
    public List<Billing> getBillings() {
        return billingService.getBillings();
    }

    @RequestMapping(value = "/{id}")
    public Billing getBilling(@PathVariable("id") Integer id) {
        return billingService.getBilling(id);
    }

}

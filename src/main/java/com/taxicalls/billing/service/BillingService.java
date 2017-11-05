/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.billing.service;

import com.taxicalls.billing.model.Billing;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxicalls.billing.repository.BillingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author romulo
 */
@Service
public class BillingService {

    protected static final Logger LOGGER = Logger.getLogger(BillingService.class.getName());

    @Autowired
    protected BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
        LOGGER.log(Level.INFO, "BillingRepository says system has {0} accounts", billingRepository.count());
    }

    @Transactional
    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getBillings() {
        LOGGER.log(Level.INFO, "getBillings() invoked");
        List<Billing> billings = new ArrayList<>();
        Iterable<Billing> findAll = billingRepository.findAll();
        for (Billing billing : findAll) {
            billings.add(billing);
        }
        LOGGER.log(Level.INFO, "getBillings() found {0}", billings.size());
        return billings;
    }

    public Billing getBilling(Long id) {
        Billing billing = billingRepository.findOne(id);
        return billing;
    }

}

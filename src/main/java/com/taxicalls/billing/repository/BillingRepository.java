package com.taxicalls.billing.repository;

import com.taxicalls.billing.model.Billing;
import org.springframework.data.repository.CrudRepository;

public interface BillingRepository extends CrudRepository<Billing, Integer> {

}

package com.taxicalls.billing.services;

import com.taxicalls.billing.model.Driver;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "notification")
public interface NotificationService {

    @RequestMapping(method = RequestMethod.POST, value = "/notifications")
    public Response chooseDriver(Driver diver);

}

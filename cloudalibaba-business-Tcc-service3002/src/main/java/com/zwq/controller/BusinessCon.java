package com.zwq.controller;

import com.zwq.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BusinessCon {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/business/transfer", produces = "application/json; charset=utf-8", method = {
            RequestMethod.POST, RequestMethod.GET})
    public boolean businessHal(@RequestBody Map<String, Object> params) {
        try {
            return businessService.businessTransfer(null,params);
        } catch (Exception e) {
            return false;
        }
    }

}

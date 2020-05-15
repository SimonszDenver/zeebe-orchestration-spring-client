package com.objectone.orchestratorclient.api;

import io.zeebe.spring.client.ZeebeClientLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EngineResource {

    @Autowired
    private ZeebeClientLifecycle client;



}

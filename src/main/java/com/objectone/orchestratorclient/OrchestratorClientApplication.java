package com.objectone.orchestratorclient;

import io.zeebe.spring.client.EnableZeebeClient;
import io.zeebe.spring.client.annotation.ZeebeDeployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableZeebeClient
@SpringBootApplication
@ZeebeDeployment(classPathResources = "order-process.bpmn")
public class OrchestratorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestratorClientApplication.class, args);
	}

}

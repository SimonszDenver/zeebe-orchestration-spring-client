package com.objectone.orchestratorclient.api;

import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.spring.client.ZeebeClientLifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class EngineResource {

    private final Logger log = LoggerFactory.getLogger(EngineResource.class);

    @Autowired
    private ZeebeClientLifecycle client;

    @GetMapping("deploy")
    public void deploy() {
        final WorkflowInstanceEvent event =
                client
                        .newCreateInstanceCommand()
                        .bpmnProcessId("order-process")
                        .latestVersion()
                        .variables("{\"a\": \"" + UUID.randomUUID().toString() + "\"}")
                        .send()
                        .join();

        log.info("started instance for workflowKey='{}', bpmnProcessId='{}', version='{}' with workflowInstanceKey='{}'",
                event.getWorkflowKey(), event.getBpmnProcessId(), event.getVersion(), event.getWorkflowInstanceKey());
    }

    @GetMapping("workflow")
    public void workflow() {
        final WorkflowInstanceEvent workflowInstanceEvent =
                client
                        .newCreateInstanceCommand()
                        .bpmnProcessId("order-process")
                        .latestVersion()
                        .send()
                        .join();

        System.out.println(
                "Workflow instance created with key: " + workflowInstanceEvent.getWorkflowInstanceKey());
    }

}

package com.example.demo.rest.controller;

import com.example.demo.entity.Demo;
import com.example.demo.feign.DemoClient;
import com.example.demo.rest.req.DemoValidationReq;
import com.example.demo.service.DemoService;
import javax.inject.Inject;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Inject
  DemoClient demoClient;
  @Inject
  DemoService demoService;
  private static final Logger LOGGER = LogManager.getLogger(DemoController.class);

  @GetMapping("/test")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @GetMapping("/feign")
  public String index2() {
    return demoClient.getDemo();
  }

  @GetMapping("/demoFeign")
  public String index3() {
    return "demo feign";
  }

  @GetMapping("/exception/{toggle}")
  public String index4(@PathVariable Boolean toggle) {
    return demoService.demoService(toggle);
  }

  @PostMapping("/validation")
  public String index5(@Valid @RequestBody DemoValidationReq demoValidationReq) {
    return "success";
  }

  @GetMapping("/demo/jdbc")
  public Iterable<Demo> index6() {
    return demoService.demoService2();
  }


  @PreAuthorize("hasRole('SuperAdmin')")
  @GetMapping("/demo/role")
  public String index7() {
    return "Role Demo";
  }
}

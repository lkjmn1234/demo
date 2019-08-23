package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo", url = "http://localhost:8080")
public interface DemoClient {

  @GetMapping(value = "/demoFeign")
  String getDemo();
}

package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo", url = "http://")
public interface DemoClient {

  @GetMapping(value = "localhost:8080/demoFeign")
  String getDemo();
}

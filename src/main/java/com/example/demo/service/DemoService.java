package com.example.demo.service;

import com.example.demo.entity.Demo;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DemoRepository;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Inject
  DemoRepository demoRepository;

  public String demoService(Boolean toggle) {
    if (toggle) {
      throw new DemoException("");
    }
    return "success without exception";
  }

  public Iterable<Demo> demoService2() {
    return demoRepository.findAll();
  }
}

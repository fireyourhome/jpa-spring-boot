package com.springboot.controller;

import com.springboot.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "pub/{id}")
    public String pubMsg(@PathVariable String id){
        return publisherService.pubMsg(id);
    }
}

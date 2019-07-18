package com.soap.ssh.service.impl;

import com.soap.ssh.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String test() {
        return "test";
    }
}

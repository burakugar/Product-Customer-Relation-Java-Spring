package com.example.demo1.request;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.actuate.endpoint.EndpointId;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
public class CustomerRequest {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Enum gender; // enum
}

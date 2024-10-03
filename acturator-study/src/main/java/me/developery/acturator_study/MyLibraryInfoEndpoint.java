package me.developery.acturator_study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Endpoint(id = "myLibraryInfo")
public class MyLibraryInfoEndpoint {

    @ReadOperation
    public String getPathVariable(@Selector String path1) {
        log.info("path1: {}", path1);
        return path1;
    }
}

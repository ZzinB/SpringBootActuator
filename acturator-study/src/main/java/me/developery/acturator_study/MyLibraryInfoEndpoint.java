package me.developery.acturator_study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Endpoint(id = "myLibraryInfo")
public class MyLibraryInfoEndpoint {

    @WriteOperation
    public void changeSomething(String name, boolean enableSomething){
        log.info("name: {}, enableSomething: {}", name, enableSomething);
    }

    @ReadOperation //read 요청에 대한 메서드
    public List<LibraryInfo> getLibraryInfos(@Nullable String name, boolean includeVersion){
        //TODO: 라이브러리 정보를 읽어서 name, version을 가져오는 코드가 있어야 하나 하드코딩으로 대체
        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setName("logback");
        libraryInfo1.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        List<LibraryInfo> resultList = Arrays.asList(libraryInfo1, libraryInfo2);

        if(name != null){
            resultList = resultList.stream()
                    .filter(libraryInfo -> {
                        return libraryInfo.getName().equals(name);
                    })
                    .toList();
        }
        if(includeVersion == false){
            resultList = resultList.stream()
                    .map(libraryInfo -> {
                        LibraryInfo simpleInfo = new LibraryInfo();
                        simpleInfo.setName(libraryInfo.getName());
                        // version 정보는 포함하지 않음
                        return simpleInfo;
                    })
                    .toList();
        }
        return resultList;
    }
}

package me.developery.acturator_study;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.Arrays;
import java.util.List;

@Endpoint(id = "myLibraryInfo")
public class MyLibraryInfoEndpoint {

    @ReadOperation //read 요청에 대한 메서드
    public List<LibraryInfo> getLibraryInfos(){
        //TODO: 라이브러리 정보를 읽어서 name, version을 가져오는 코드가 있어야 하나 하드코딩으로 대체
        LibraryInfo libraryInfo1 = new LibraryInfo();
        libraryInfo1.setName("logback");
        libraryInfo1.setVersion("1.0.0");

        LibraryInfo libraryInfo2 = new LibraryInfo();
        libraryInfo2.setName("jackson");
        libraryInfo2.setVersion("2.0.0");

        return Arrays.asList(libraryInfo1, libraryInfo2);
    }
}

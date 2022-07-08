package com.epam.task.webservices;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

public class ApiTests {

    private static final String PATH_TO_FILE = "C:\\Users\\Dmytro_Kornieiev\\Desktop\\Course EPAM Middle\\Core\\APIUtils\\src\\main\\java\\com\\epam\\task\\webservices\\rq";
    private static final String BASE_URL = "https://restful-booker.herokuapp.com/booking";
    private static final String EXCEPTION = "FALSE";
    private static final String NAME_OF_BOOK = "\"firstname\":\"Michael\"";
    private static final String ID_BOOK = "/30";
    private static final int HAPPY_STATUS_CODE = 200;
    BasicApiClass basicApiClass = new BasicApiClass();

    @Test
    public void checkNewBookNameWithRequestFromFile() throws IOException {
        String body = basicApiClass.readFromFile(PATH_TO_FILE);
        BookWithID bk = basicApiClass.requestForCreateNewBookWithFile(BASE_URL, body);
        Assertions.assertThat(bk.getFirstname()).as(EXCEPTION).isEqualTo(NAME_OF_BOOK);
    }

    @Test
    public void checkNewBookName() {
        String rp = basicApiClass.requestWithObject();
        Assertions.assertThat(rp).contains(NAME_OF_BOOK);
        System.out.println("The status code recieved: " + rp);
    }

    @Test
    public void checkStatusCode(){
        int code = basicApiClass.requestForGetStatusCode(BASE_URL+ID_BOOK);
        Assertions.assertThat(code).as(EXCEPTION).isEqualTo(HAPPY_STATUS_CODE);
    }

    @Test
    public void getBook() {
        String sb = basicApiClass.requestForGetBook(BASE_URL+ID_BOOK);
        System.out.println(sb);
        Assertions.assertThat(sb).as(EXCEPTION).contains(NAME_OF_BOOK);
    }

}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RestClass {

    @Test
    public void myRequest()
    {
        // Базовый URL
        RestAssured.baseURI = "http://httpbin.org/";

        // Создаем запрос
        RequestSpecification httpRequest = RestAssured.given();

        //Задаем код статуса
        int setStatusCode = 200;

        // Выполненям GET запрос
        Response response = httpRequest.get("/status/" + setStatusCode);

        // Выводим код статуса
        System.out.println("Код статуса: " + response.getStatusCode());
        System.out.println(response.getStatusLine());

        // Проверка на соответсвие статусу
        Assert.assertEquals(response.getStatusCode(), setStatusCode);
    }
}


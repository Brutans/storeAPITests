import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.additionalModels.Category;
import models.additionalModels.Order;
import models.additionalModels.TagsItem;
import models.requestModels.RequestItem;
import models.responseModels.InventoryResponse;
import models.responseModels.ResponsesItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;


import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class Example {


    @Test (description = "Получение кода 200 при создании ордера", priority = 1)
    public void postOrder(){
        Order orderReq = new Order(2L,0L,1,new Date(),"placed",true);
        Order orderResp = given()
                .body(orderReq)
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(Order.class);
        Assert.assertEquals(orderResp,orderReq);
    }
    @Test (description = "Получение кода ошибки 400 при вводе неккоректных данных при создании ордера")
    public void postOrder400(){
        Order order = new Order(-1000L,-1000L,0, new Date(),"5",false);
        int response = given()
                .body(order)
                .contentType(ContentType.XML)
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .extract()
                .response().getStatusCode();
        Assert.assertEquals(400,response);
    }

    @Test (description = "Получение ордера и кода 200",priority = 2)
    public void getOrder(){
        Order expOrder = new Order(2L,null,0,null,null,true);
        Order orderResp = given()
                .get("https://petstore.swagger.io/v2/store/order/2")
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(Order.class);
        Assert.assertEquals(expOrder.getId(),orderResp.getId());
    }

    @Test (description = "Удаление ордера с получением кода 200", priority = 3)
    public void deleteOrder(){
        int response = given()
                .delete("https://petstore.swagger.io/v2/store/order/2")
                .then()
                .extract()
                .response().getStatusCode();
        Assert.assertEquals(200,response);
    }

    @Test (description = "Удаление несуществующего ордера с получением кода ошибки 404", priority = 4)
    public void deleteNonExistentOrder(){
        int response = given()
                .delete("https://petstore.swagger.io/v2/store/order/2")
                .then()
                .extract()
                .response().getStatusCode();
        Assert.assertEquals(404,response);
    }

    @Test (description = "Получение статистики и кода 200")
    public void getInventory(){
        InventoryResponse inventory = given()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200)
                .extract()
                .response().body().as(InventoryResponse.class);
        System.out.println(inventory);
    }



}

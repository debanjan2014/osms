package com.malikov.shopsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malikov.shopsystem.model.OrderStatus;
import com.malikov.shopsystem.model.PaymentType;
import com.malikov.shopsystem.to.OrderTo;
import com.malikov.shopsystem.to.OrderItemTo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
//        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
//            appCtx.getEnvironment().setActiveProfiles(Profiles.ACTIVE_DB, Profiles.DB_IMPLEMENTATION);
//            appCtx.load(
//                    "spring/spring-security.xml",
//                    "spring/spring-app.xml",
//                    "spring/spring-db.xml",
//                    "spring/spring-mvc.xml",
//                    "spring/spring-tools.xml");
//            appCtx.refresh();
//
//            System.out.println(appCtx.getBean(OrderServiceImpl.class).get(1));

//            Zoo zoo = new Zoo("London Zoo", "London");
//            Lion lion = new Lion("Simba");
//            Elephant elephant = new Elephant("Manny");
//            zoo.addAnimal(elephant).add(lion);

            OrderTo orderTo = new OrderTo(2, "Alla", "Kozlovskaya", "(098)12-12-343", "Rovno", "33", PaymentType.PRIVAT_CARD, LocalDate.now(), OrderStatus.READY_FOR_SHIPMENT);
            orderTo.addProduct(new OrderItemTo(1, 4, "Potal kitay 100", 145, 3));
            orderTo.addProduct(new OrderItemTo(2,1,"Shellac Man", 235, 1));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(System.out, orderTo);

//        }
    }
}

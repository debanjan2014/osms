package com.malikov.shopsystem.repository;


import com.malikov.shopsystem.OrderTestData;
import com.malikov.shopsystem.model.Order;
import com.malikov.shopsystem.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;

import static com.malikov.shopsystem.CustomerTestData.CUSTOMER_GOLOV;
import static com.malikov.shopsystem.OrderTestData.*;
import static com.malikov.shopsystem.ProductTestData.POTAL_KITAJ;

public abstract class OrderRepositoryTest extends AbstractRepositoryTest {
/*
    @Autowired
    protected OrderService service;

    // TODO: 1/24/2017 Not equals?? maybe null != null (date_placed)
//    @Test
//    public void testSave() throws Exception {
//        Order newOrder = new Order(CUSTOMER_DROGOV, ADMIN,
//                PaymentType.PRIVAT_CARD,
//                OrderStatus.READY_FOR_SHIPMENT,
//                Arrays.asList(
//                        new OrderItemExtended(SHELLAC_MANETTI.getId(), SHELLAC_MANETTI.getName(), SHELLAC_MANETTI.getPrice(), 8),
//                        new OrderItemExtended(FERRARIO_ROZOVYJ.getId(), FERRARIO_ROZOVYJ.getName(), FERRARIO_ROZOVYJ.getPrice(), 7),
//                        new OrderItemExtended(POTAL_NAZIONALE.getId(), POTAL_NAZIONALE.getName(), POTAL_NAZIONALE.getPrice(), 6)
//                ));
//        Order created = service.create(newOrder);
//        newOrder.setId(created.getId());
//        OrderTestData.MATCHER.assertCollectionEquals(
//                Arrays.asList(ORDER_1, ORDER_2, ORDER_3, ORDER_4, newOrder), service.getPage());
//    }

    @Test
    public void testUpdate() throws Exception {
        Order updated = new Order(ORDER_1);
        updated.setCustomerPhoneNumber("upd_phone_number");
        service.update(updated);
        OrderTestData.MATCHER.assertEquals(updated, service.get(ORDER_1.getId()));
    }

    @Test
    public void testGet() throws Exception {
        Order order = service.get(ORDER_3.getId());
        OrderTestData.MATCHER.assertEquals(ORDER_3, order);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Order> all = service.getAll();
        OrderTestData.MATCHER.assertCollectionEquals(Arrays.asList(ORDER_4, ORDER_3, ORDER_2, ORDER_1), all);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(ORDER_2.getId());
        OrderTestData.MATCHER.assertCollectionEquals(Arrays.asList(ORDER_4, ORDER_3, ORDER_1), service.getAll());
    }

    @Test
    public void testGetByCustomerId() throws Exception {
        Collection<Order> allByCustomerId = service.getByCustomerId(CUSTOMER_GOLOV.getId());
        OrderTestData.MATCHER.assertCollectionEquals(Arrays.asList(ORDER_1, ORDER_2), allByCustomerId);
    }

    @Test
    public void testGetByProductId() throws Exception {
        Collection<Order> allByProductId = service.getByProductId(POTAL_KITAJ.getId());
        OrderTestData.MATCHER.assertCollectionEquals(Arrays.asList(ORDER_2, ORDER_3), allByProductId);
    }
    */
}
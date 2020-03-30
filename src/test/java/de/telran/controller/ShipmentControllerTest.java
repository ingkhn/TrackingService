package de.telran.controller;

import de.telran.configuration.TestConfig;
import de.telran.model.entity.Customer;
import de.telran.model.entity.Shipment;
import de.telran.service.CustomerService;
import de.telran.service.ShipmentService;
import de.telran.service.impl.ShipmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShipmentController.class)
@Import(TestConfig.class)
public class ShipmentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShipmentServiceImpl service;

    @Test
    public void testCreateCustomer_correctResponse() throws Exception {
        Shipment shipmentEntity = new Shipment(null, "Packet", 1L, null);
        Shipment savedShipmentEntity = new Shipment(3L, "Packet", 1L, null);
        when(service.createShipment(shipmentEntity)).thenReturn(savedShipmentEntity);

        mvc.perform(post("/api/customers/1/shipments")
                .content("{\"title\": \"Packet\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.shipment_id").value("3"))
                .andExpect(jsonPath("$.title").value("Packet"));

        verify(service, times(1)).createShipment(shipmentEntity);
    }
}

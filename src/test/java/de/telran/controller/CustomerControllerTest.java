package de.telran.controller;

import de.telran.configuration.TestConfig;
import de.telran.model.entity.Customer;
import de.telran.service.impl.CustomerServiceImpl;
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
@WebMvcTest(CustomerController.class)
@Import(TestConfig.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerServiceImpl service;

    @Test
    public void testCreateCustomer_correctResponse() throws Exception {
        Customer customerEntity = new Customer(null, "petrov", "petrov@gmail.com", null);
        Customer savedCustomerEntity = new Customer(3L, "petrov", "petrov@gmail.com", null);
        when(service.createCustomer(customerEntity)).thenReturn(savedCustomerEntity);

        mvc.perform(post("/api/customers")
                .content("{\"name\": \"petrov\", \"email\": \"petrov@gmail.com\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.customer_id").value("3"))
                .andExpect(jsonPath("$.name").value("petrov"))
                .andExpect(jsonPath("$.email").value("petrov@gmail.com"));

        verify(service, times(1)).createCustomer(customerEntity);
    }

    @Test
    public void testCreateCustomer_wrongName() throws Exception {
        String customer = "{\"name\": \"p\", \"email\": \"bob@domain.com\"}";
        mvc.perform(post("/api/customers")
                .content(customer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateCustomer_emptyName() throws Exception {
        String customer = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
        mvc.perform(post("/api/customers")
                .content(customer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateCustomer_wrongEmail() throws Exception {
        String customer = "{\"name\": \"petrov\", \"email\" : \"bobdomain.com\"}";
        mvc.perform(post("/api/customers")
                .content(customer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateCustomer_emptyEmail() throws Exception {
        String customer = "{\"name\": \"petrov\", \"email\" : \"\"}";
        mvc.perform(post("/api/customers")
                .content(customer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}

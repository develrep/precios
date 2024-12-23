package com.precios.hex;

import com.prices.hex.PricesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = PricesApplication.class)
@AutoConfigureMockMvc
public class PricesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    public void test(Long brandId, Long productId, String date, Integer priceList) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/find")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", date))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(priceList));
    }    
    
    public void testExc(Long brandId, Long productId, String date, String message) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/find")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", date))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(message)
                );
    }    
    
    @Test
    void test1() throws Exception {
        test(1L, 35455L, "2020-06-14T10:00:00.000", 1); // 35.50 EUR
    }

    @Test
    void test2() throws Exception {
        test(1L, 35455L, "2020-06-14T16:00:00.000", 2); // 25.45 EUR
    }
    
    @Test
    void test3() throws Exception {
        test(1L, 35455L, "2020-06-14T21:00:00.000", 1); // 35.50 EUR
    }

    @Test
    void test4() throws Exception {
        test(1L, 35455L, "2020-06-15T10:00:00.000", 3); // 30.50 EUR
    }

    @Test
    void test5() throws Exception {
        test(1L, 35455L, "2020-06-16T21:00:00.000", 4); // 38.95 EUR
    }
    
    @Test
    void test6() throws Exception {
        testExc(1L, 35455L, "2000-06-16T21:00:00.000", "No se encontro la tarifa");
    }
    
}
package org.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductoQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void performTestProductos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void performtTestProductoId() throws Exception{
        mockMvc.perform(get("/productos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("laptop"))
                .andExpect(jsonPath("$.precio").value(12.30));
    }

    @Test
    public void testGetProducto() throws Exception {
        mockMvc.perform(get("/productos/1"))
                .andExpect(status().isOk());
    }
}

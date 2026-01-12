package com.example.cartservice.controller;

import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Item;
import com.example.cartservice.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void testCreateCart() throws Exception {
        Cart cart = new Cart();
        cart.setCartId("test-cart-id");
        when(cartService.createCart()).thenReturn(cart);

        mockMvc.perform(post("/api/carts"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cartId").value("test-cart-id"));
    }

    @Test
    public void testGetCart() throws Exception {
        Cart cart = new Cart();
        cart.setCartId("test-cart-id");
        when(cartService.getCartById("test-cart-id")).thenReturn(Optional.of(cart));

        mockMvc.perform(get("/api/carts/test-cart-id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartId").value("test-cart-id"));
    }

    @Test
    public void testAddItemToCart() throws Exception {
        Cart cart = new Cart();
        cart.setCartId("test-cart-id");
        Item item = new Item("Test Item", 10.0, 2);
        cart.getItems().add(item);
        cart.setTotal(20.0);

        when(cartService.addItemToCart(any(), any())).thenReturn(cart);

        mockMvc.perform(post("/api/carts/test-cart-id/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Item\",\"price\":10.0,\"quantity\":2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(20.0));
    }
}

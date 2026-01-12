package com.example.cartservice.service;

import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Item;
import com.example.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCartById(String cartId) {
        return cartRepository.findById(cartId);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart addItemToCart(String cartId, Item item) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.getItems().add(item);
            calculateTotal(cart);
            return cartRepository.save(cart);
        }
        return null;
    }

    public Cart updateCartStatus(String cartId, String status) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.setStatus(status);
            return cartRepository.save(cart);
        }
        return null;
    }

    public void deleteCart(String cartId) {
        cartRepository.deleteById(cartId);
    }

    private void calculateTotal(Cart cart) {
        double total = 0.0;
        for (Item item : cart.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        cart.setTotal(total);
    }
}

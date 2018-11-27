package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.csci4050.bookstore.Bookstore.service.CartService;
import org.csci4050.bookstore.Bookstore.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addPromotion(@RequestBody final Promotion promotion) {
        promotionService.createPromotion(promotion);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<Object> editPromotion(@RequestBody final Promotion promotion) {
        promotionService.updatePromotion(promotion);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/apply/{promoCode}", method = RequestMethod.POST)
    public ResponseEntity<Object> applyPromotion(@PathVariable final int promoCode, final Principal principal) throws ValidationException {
        final String username = principal.getName();
        final Optional<Promotion> promotionOptional = promotionService.getPromotionWithPromoCode(promoCode);
        if (!promotionOptional.isPresent()) {
            throw new ValidationException("Promotion with promo code <%s> could not be applied", Integer.toString(promoCode));
        }
        final Promotion promotion = promotionOptional.get();
        promotionService.updateCartWithPromotion(promotion, username);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

    @Data
    @Builder
    public static class Promo {
        private int promoCode;
    }
}

package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.csci4050.bookstore.Bookstore.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

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
}

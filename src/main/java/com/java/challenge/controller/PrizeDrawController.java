package com.java.challenge.controller;

import com.java.challenge.model.PrizeDrawRequest;
import com.java.challenge.service.PrizeDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/prize-draw")
public class PrizeDrawController {

    private static final Logger logger = LoggerFactory.getLogger(PrizeDrawController.class);

    private final PrizeDrawService service;

    @Autowired
    public PrizeDrawController(PrizeDrawService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> doPrizeDraw(@RequestBody PrizeDrawRequest request) {

        try {

            if (request == null || request.getOrderedPackage() == null || request.getOrderedPackage().isEmpty()) {
                String msgError = "Invalid argument: orderedPackage is required";
                logger.warn(msgError);
                throw new IllegalArgumentException(msgError);
            }

            return ResponseEntity.ok(service.doPrizeDraw(request));
        } catch (IllegalArgumentException ex) {
            logger.warn("Prize draw ilegal argument:", ex);
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            logger.warn("Prize draw Fail:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }

    }

}

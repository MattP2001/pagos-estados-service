package com.example.pagos;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebhookController {

    @Autowired
    PagoRepository repo;

    @PostMapping("/webhook")
    public String recibir(@RequestBody Map<String, Object> body) {
        String id = (String) body.get("payment_id");
        Pago p = repo.findById(id).orElse(new Pago());
        p.setPaymentId(id);
        p.setStatus((String) body.get("status"));
        p.setAmount(Double.valueOf(body.get("amount").toString()));
        p.setCurrency((String) body.get("currency"));
        repo.save(p);
        return "ok";
    }

    @GetMapping("/pagos/{id}")
    public Pago get(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }
}

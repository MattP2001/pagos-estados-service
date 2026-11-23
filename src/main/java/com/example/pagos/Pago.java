package com.example.pagos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pago {

    @Id
    private String paymentId;
    private String status;
    private Double amount;
    private String currency;

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}

package com.julio.ecommerce.payment;

import com.julio.ecommerce.customer.CustomerResponse;
import com.julio.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

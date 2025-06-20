package com.julio.ecommerce.kafka;

import com.julio.ecommerce.customer.CustomerResponse;
import com.julio.ecommerce.order.PaymentMethod;
import com.julio.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> product

) {

}

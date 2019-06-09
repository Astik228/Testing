package Ordermanager.Testing.models;

import Ordermanager.Testing.enums.MethodsOfPay;
import Ordermanager.Testing.enums.OrderStatuses;

public class ToOrderProduct {
    private Integer userId;
    private Integer productId;
    private Integer amountOfProducts;
    private MethodsOfPay methodsOfPay;


    public Integer getUserId() {
        return userId;
    }

    public MethodsOfPay getMethodsOfPay() {
        return methodsOfPay;
    }

    public void setMethodsOfPay(MethodsOfPay methodsOfPay) {
        this.methodsOfPay = methodsOfPay;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(Integer amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }
}

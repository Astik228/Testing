package Ordermanager.Testing.entities;

import Ordermanager.Testing.enums.MethodsOfPay;
import Ordermanager.Testing.enums.OrderStatuses;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer amountOfProducts;
    @Enumerated(EnumType.ORDINAL)
    private MethodsOfPay methodsOfPay;
//    @Enumerated(EnumType.ORDINAL)
//    private OrderStatuses orderStatuses;


    public OrderProduct() {
    }

    public OrderProduct(User user, Product product, Integer amountOfProducts, MethodsOfPay methodsOfPay) {
        this.user = user;
        this.product = product;
        this.amountOfProducts = amountOfProducts;
        this.methodsOfPay = methodsOfPay;
    }

    public MethodsOfPay getMethodsOfPay() {
        return methodsOfPay;
    }

    public void setMethodsOfPay(MethodsOfPay methodsOfPay) {
        this.methodsOfPay = methodsOfPay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(Integer amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }
}

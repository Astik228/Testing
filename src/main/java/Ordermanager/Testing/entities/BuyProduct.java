package Ordermanager.Testing.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "buyProduct_t")
public class BuyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User  user;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amountOfProducts;

    public BuyProduct() {
    }

    public BuyProduct(User user, Product product, Integer amountOfProducts) {
        this.user = user;
        this.product = product;
        this.amountOfProducts = amountOfProducts;
    }

    @Override
    public String toString() {
        return "BuyProduct{" + "id=" + id + ", user=" + user + ", product=" + product + ", amountOfProducts=" + amountOfProducts + '}';
    }

    public Integer getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(Integer amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

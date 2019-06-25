package Ordermanager.Testing.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "user_products")
public class UserOwnProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private  Integer amountOfProduct;

   public UserOwnProducts (){}


    public UserOwnProducts(User user, Product product, Integer amountOfProduct) {
        this.user = user;
        this.product = product;
        this.amountOfProduct = amountOfProduct;
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

    public Integer getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(Integer amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

}

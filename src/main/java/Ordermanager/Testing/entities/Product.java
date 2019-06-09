package Ordermanager.Testing.entities;

import Ordermanager.Testing.enums.AvailableStatuses;
import Ordermanager.Testing.enums.Country;
import Ordermanager.Testing.enums.MethodsOfPay;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, unique = false)
    private String title;

    @Column(name = "price", nullable = false, unique = false)
    private Double price;
   // @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany
    private List<Comment> comments;

    @Column(name = "country", nullable = false, unique = false)
    private Country country;

    @Column(name = "available", nullable = false, unique = false)
    private AvailableStatuses availableStatuses;

    @Column(name = "description", nullable = false, unique = false)
    private String description;

    @Column(name = "amount", nullable = false, unique = false)
    private Integer amount;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "address")
    private String address;

    public Product() {
    }


    public Product(String title, Double price, List<Comment> comments, Country country, AvailableStatuses availableStatuses, String description, Integer amount, Category category) {
        this.title = title;
        this.price = price;
        this.comments = comments;
        this.country = country;
        this.availableStatuses = availableStatuses;
        this.description = description;
        this.amount = amount;
        this.category = category;

    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                "\n title='" + title +
                "\n price=" + price +
                "\n address="+address+
                "\n comments=" + comments +
                "\n country=" + country +
                "\n availableStatuses=" + availableStatuses +
                "\n description='" + description +
                "\n amount=" + amount +
                "\n category=" + category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AvailableStatuses getAvailableStatuses() {
        return availableStatuses;
    }

    public void setAvailableStatuses(AvailableStatuses availableStatuses) {
        this.availableStatuses = availableStatuses;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

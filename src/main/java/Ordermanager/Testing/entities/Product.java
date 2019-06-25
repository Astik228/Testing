package Ordermanager.Testing.entities;

import Ordermanager.Testing.enums.AvailableStatuses;
import Ordermanager.Testing.enums.Country;
import Ordermanager.Testing.enums.MethodsOfPay;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, unique = false)
    @NotEmpty(message = "*Please provide tittle")
    private String title;

    @Column(name = "price", nullable = false, unique = false)
    private Double price;
   // @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany
    @JsonBackReference
    private List<Comment> comments;


    @Column(name = "available", nullable = false)
    private AvailableStatuses availableStatuses;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "*Please provide description")
    private String description;

    @Column(name = "amount", nullable = false, unique = false)
    private Integer amount;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide address")
    private String address;

    @Column(name = "phone_number")
    private String number;


    public Product() {
    }


    public Product(@NotEmpty(message = "*Please provide tittle") String title, Double price, List<Comment> comments, AvailableStatuses availableStatuses, @NotEmpty(message = "*Please provide description") String description, Integer amount, Category category, @NotEmpty(message = "*Please provide address") String address, String number) {
        this.title = title;
        this.price = price;
        this.comments = comments;
        this.availableStatuses = availableStatuses;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                "\n title='" + title +
                "\n price=" + price +
                "\n address="+address+
                "\n comments=" + comments +
                "\n availableStatuses=" + availableStatuses +
                "\n description='" + description +
                "\n amount=" + amount +
                "\n category=" + category+
                "\n phone number="+number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

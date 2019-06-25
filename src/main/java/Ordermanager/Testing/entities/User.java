package Ordermanager.Testing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email",nullable = false,unique = true)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;


    @Column(name = "password",nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "name",nullable = false,unique = true)
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "last_name",nullable = false)
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @JsonIgnore
    @Column(name = "active")
    private int active;

    //  @JsonIgnore
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "wishes")
    @OneToMany
    private List<Product> wishes;

    @Column(name = "products")
    @OneToMany
    private List<Product> products;
@Column(name = "phone_number",nullable = false,unique = true)
private String number;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email, @Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password, @NotEmpty(message = "*Please provide your name") String name, @NotEmpty(message = "*Please provide your last name") String lastName, int active, List<Product> wishes, List<Product> products, String number, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
        this.wishes = wishes;
        this.products = products;
        this.number = number;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User: " +
                "\nid=" + id +
                "\n email='" + email +
                "\n password='" + password +
                "\n name='" + name +
                "\n lastName='" + lastName +
                "\n active=" + active +
                "\n products=" + products +
                "\n wishes=" + wishes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getWishes() {
        return wishes;
    }

    public void setWishes(List<Product> wishes) {
        this.wishes = wishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.util.Collection;

@NamedQuery(
        name = "DrinksEntity.findAll",
        query = "SELECT l FROM DrinksEntity l"
)

@Entity
@Table(name = "drinks", schema = "dt170gprojekt", catalog = "")
public class DrinksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "drink_id", nullable = false)
    private Long drinkId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @OneToMany(mappedBy = "drinksByDrinkId")
    private Collection<PurchasedDrinksEntity> purchasedDrinksByDrinkId;

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrinksEntity that = (DrinksEntity) o;

        if (drinkId != that.drinkId) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = drinkId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        return Math.toIntExact(result);
    }

    public Collection<PurchasedDrinksEntity> getPurchasedDrinksByDrinkId() {
        return purchasedDrinksByDrinkId;
    }

    public void setPurchasedDrinksByDrinkId(Collection<PurchasedDrinksEntity> purchasedDrinksByDrinkId) {
        this.purchasedDrinksByDrinkId = purchasedDrinksByDrinkId;
    }
}

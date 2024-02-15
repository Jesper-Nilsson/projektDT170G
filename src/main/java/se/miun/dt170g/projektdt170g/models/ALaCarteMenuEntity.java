package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.util.Collection;

@NamedQueries({
        @NamedQuery(
                name = "ALaCarteMenuEntity.findType",
                query = "SELECT l FROM ALaCarteMenuEntity l WHERE l.type = :type"
        ),
        @NamedQuery(
                name = "ALaCarteMenuEntity.findAll",
                query = "SELECT l FROM ALaCarteMenuEntity l"
        )
})
@Entity
@Table(name = "a_la_carte_menu", schema = "dt170gprojekt", catalog = "")
public class ALaCarteMenuEntity {
    static public final String findByType = "ALaCarteMenuEntity.findType";
    static public final String findAll = "ALaCarteMenuEntity.findAll";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "a_la_carte_id", nullable = false)
    private int aLaCarteId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "type", nullable = false, length = 255)
    private String type;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    /*@OneToMany(mappedBy = "aLaCarteMenuByALaCarteId")
    private Collection<PurchasedALaCarteEntity> purchasedALaCartesByALaCarteId;*/

    public int getaLaCarteId() {
        return aLaCarteId;
    }

    public void setaLaCarteId(int aLaCarteId) {
        this.aLaCarteId = aLaCarteId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        ALaCarteMenuEntity that = (ALaCarteMenuEntity) o;

        if (aLaCarteId != that.aLaCarteId) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aLaCarteId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    /*public Collection<PurchasedALaCarteEntity> getPurchasedALaCartesByALaCarteId() {
        return purchasedALaCartesByALaCarteId;
    }

    public void setPurchasedALaCartesByALaCarteId(Collection<PurchasedALaCarteEntity> purchasedALaCartesByALaCarteId) {
        this.purchasedALaCartesByALaCarteId = purchasedALaCartesByALaCarteId;
    }*/
}

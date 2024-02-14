package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "dt170gprojekt", catalog = "")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "telephone")
    private int telephone;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (telephone != that.telephone) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + telephone;
        return result;
    }
}

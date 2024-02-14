package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "receipt", schema = "dt170gprojekt", catalog = "")
public class ReceiptEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "receipt_id")
    private int receiptId;
    @Basic
    @Column(name = "date")
    private Date date;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptEntity that = (ReceiptEntity) o;

        if (receiptId != that.receiptId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = receiptId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}

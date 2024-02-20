package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

@Entity
@Table(name = "table_session", schema = "dt170gprojekt")
public class TableSessionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "session_id", nullable = false)
    private int sessionId;
    @Basic
    @Column(name = "table_number", nullable = false)
    private int tableNumber;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableSessionEntity that = (TableSessionEntity) o;

        if (sessionId != that.sessionId) return false;
        if (tableNumber != that.tableNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + tableNumber;
        return result;
    }
}

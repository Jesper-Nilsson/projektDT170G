package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

@NamedQuery(
        name = "TableSessionEntity.findAll",
        query = "SELECT l FROM TableSessionEntity l"
)


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

    @Basic
    @Column(name = "table_size", nullable = false)
    private int tableSize;

    @Basic
    @Column(name = "table_status", nullable = false)
    private int tableStatus;

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

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSzie) {
        this.tableSize = tableSzie;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableSessionEntity that = (TableSessionEntity) o;

        if (sessionId != that.sessionId) return false;
        if (tableNumber != that.tableNumber) return false;
        if (tableSize != that.tableSize) return false;
        if (tableStatus != that.tableStatus) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + tableNumber;
        return result;
    }
}

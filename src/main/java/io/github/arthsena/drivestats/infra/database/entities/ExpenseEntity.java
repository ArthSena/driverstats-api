package io.github.arthsena.drivestats.infra.database.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "drivestats-expenses")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExpenseEntity extends PanacheEntityBase {

    @Id private UUID id;

    private double amount;

    private LocalDateTime date;

    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId", nullable=true, unique=false)
    private ExpenseCategoryEntity category;

    @ManyToOne
    @JoinColumn(name="ownerId", nullable=false)
    private UserEntity owner;

    public ExpenseEntity(UserEntity owner, ExpenseCategoryEntity category, double amount, String description){
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = LocalDateTime.now();
    }
}

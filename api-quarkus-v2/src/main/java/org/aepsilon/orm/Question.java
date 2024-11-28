package org.aepsilon.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Question extends PanacheEntity {
    public String label;

}
package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_order_kind")
public class OrderKind {

    @Id
    @Column(name = "order_kind_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 50)
    @Column(name = "order_kind_name")
    private String name;

    @OneToMany(mappedBy = "orderKind", fetch = FetchType.LAZY)
    private List<Order> violations;

}

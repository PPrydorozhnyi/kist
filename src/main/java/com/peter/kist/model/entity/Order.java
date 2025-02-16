package com.peter.kist.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pr_order")
public class Order {

    @Id
    @Column(name = "order_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer orderNo;

    private Date orderDate;

    @Length(max = 250)
    private String orderText;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_kind_id")
    private OrderKind orderKind;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Violation> violations;
}

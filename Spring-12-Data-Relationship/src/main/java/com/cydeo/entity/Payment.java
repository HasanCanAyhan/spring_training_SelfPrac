package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    //every payment has payment detail

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    //Spring creates relationship, but it does not know what kind of relation
    //it depends on business logic

    //@OneToOne(cascade = CascadeType.ALL) //
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) // child still over there
    //foreign key column created : join done  //one payment has only one payment detail
    //wih cascade statement , child one  will be filled which is here paymentDetail fields
    @JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;



    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }


}

package com.myrecipe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Cart createCart(Member member){
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }

}

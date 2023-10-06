package it.unical.demacs.pierluigi.fintedapp.data.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;

    @Column(name = "title")
    private String title;

    @Column(name = "starting_price")
    private Long startingPrice;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> postImages;
    
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "publish_date")
    private Date publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User buyer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;
}

package com.OS.api.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_product")
   private Integer idProduct;
   @Column(name = "name")
   private String name;
   @Column(name = "description")
   private String description;
   @Temporal(TemporalType.DATE)
   @Column(name = "date_removed")
   private LocalDate dateRemoved;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_brand", nullable = false)
   private BrandModel brand;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_product_type", nullable = false)
   private ProductTypeModel productType;
   @OneToMany(mappedBy = "productModel", fetch = FetchType.LAZY)
   private List <ImageModel> images;
   //@ManyToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "id_favorite", nullable = false)
   //private UserFavoriteProductModel userFavoriteProductModel;

}

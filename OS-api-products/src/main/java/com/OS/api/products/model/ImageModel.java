package com.OS.api.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "image")
public class ImageModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_image")
   private Integer idImage;
   @Column(name = "url")
   private String url;
   @Column(name = "date_added")
   private Date dateAdded;
   @Column(name = "date_removed")
   private Date dateRemoved;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_product", nullable = false)
   private ProductModel productModel;

}

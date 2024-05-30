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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
   @Column(name = "fecha_alta")
   private Date dateAdded;
   @Column(name = "fecha_baja")
   private Date dateRemoved;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_producto", nullable = false)
   private ProductModel productModel;

}

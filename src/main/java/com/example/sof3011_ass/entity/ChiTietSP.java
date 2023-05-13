package com.example.sof3011_ass.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX idNSX;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP idDongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "giaBan")
    private BigDecimal giaBan;
}

package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
public class Denuncia {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String latitude;
    private String longitude;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "denunciante_id", referencedColumnName = "id")
    private Denunciante denunciante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "denuncia_id", referencedColumnName = "id")
    private DadosDenuncia denuncia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco Endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Denunciante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    public DadosDenuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(DadosDenuncia denuncia) {
        this.denuncia = denuncia;
    }

    public com.example.demo.domain.Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(com.example.demo.domain.Endereco endereco) {
        Endereco = endereco;
    }

    public Denuncia() {
    }
}

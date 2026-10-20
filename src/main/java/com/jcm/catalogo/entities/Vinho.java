package com.jcm.catalogo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "table_vinho")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vinho {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String origem;
    private String tipo; // Tinto, Branco, Rosé, Espumante
    private String uva;  // Malbec, Cabernet Sauvignon, Chardonnay
    private Double preco;
    private String harmonizacao;
    private String descricao;
    private String imagem;
    private String codSistema;
}

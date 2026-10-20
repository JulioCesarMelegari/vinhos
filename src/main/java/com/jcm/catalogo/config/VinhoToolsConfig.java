package com.jcm.catalogo.config;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.jcm.catalogo.entities.VinhoRequest;
import com.jcm.catalogo.entities.VinhoResponse;
import com.jcm.catalogo.repositories.VinhoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class VinhoToolsConfig {

    private final VinhoRepository vinhoRepository;

  
    @Tool(name = "consultarCatalogoDeVinhos", 
            description = "Busca vinhos no catálogo por tipo (tinto, branco), uva (malbec, cabernet) ou origem/país (argentino, chileno, português, etc)")
      public VinhoResponse consultarCatalogoDeVinhos(VinhoRequest request) {
          var vinhos = vinhoRepository.buscarPorFiltrosOpcionais(
              request.tipo(), 
              request.uva(), 
              request.origem()
          );
          return new VinhoResponse(vinhos);
      }
}
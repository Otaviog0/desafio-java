package com.example.demo.services;

import com.example.demo.domain.Denuncia;
import com.example.demo.domain.Endereco;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repo;
    @Autowired
    private GeoLocationService geoLocationService;

    public Denuncia insert(Denuncia denuncia) throws EntityNotFound {
        denuncia.setId(null);
        Endereco endereco = geoLocationService.getGeoLocation(denuncia.getLatitude(), denuncia.getLongitude());
        denuncia.setEndereco(endereco);
        System.out.println(">>>>>>>>>>>>>" + denuncia.toString());
        if (denuncia.getEndereco().getLogradouro() != null) {
          return repo.save(denuncia);
        }

        return denuncia;
    }
}

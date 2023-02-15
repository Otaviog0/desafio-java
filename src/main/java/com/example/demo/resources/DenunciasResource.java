package com.example.demo.resources;

import com.example.demo.domain.Denuncia;
import com.example.demo.domain.ErrorResponse;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1/denuncias")
public class DenunciasResource {

    @Autowired
    private DenunciaService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Denuncia denuncia) throws EntityNotFound {
        Denuncia novaDenuncia = service.insert(denuncia);
        if(novaDenuncia.getId() == null) {
            throw new EntityNotFound("Endereço não encontrado para essa localidade.");
        }

        return new ResponseEntity<>(novaDenuncia, HttpStatus.CREATED);
    }

}

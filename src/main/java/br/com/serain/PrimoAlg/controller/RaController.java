package br.com.serain.PrimoAlg.controller;

import br.com.serain.PrimoAlg.model.RA;
import br.com.serain.PrimoAlg.service.Algoritmos.RaPrimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/primos")
public class RaController {

    @Autowired
    RaPrimoService raPrimoService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RA ra){

        return  ResponseEntity.ok().body(raPrimoService.primo(ra));

    }


}

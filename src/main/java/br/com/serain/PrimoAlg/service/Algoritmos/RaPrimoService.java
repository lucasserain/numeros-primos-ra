package br.com.serain.PrimoAlg.service.Algoritmos;

import br.com.serain.PrimoAlg.model.RA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RaPrimoService {

    @Autowired
    CheckPrimo checkPrimo;

    public RA primo(RA raObject){
        String ra = raObject.getRa();
        Integer aaa= 0;
        Integer bbb;
        Integer ccc;
        Integer produto = 0;
        Integer numerosPrimos = 0;
        Integer somaPrimos = 0;
        List<Integer> allPrimos = new ArrayList<>();

        aaa = Integer.parseInt(ra.substring(0,3));
        bbb = Integer.parseInt(ra.substring(3,6));
        ccc = Integer.parseInt(ra.substring(6,9));

        produto = bbb * ccc;
        Boolean isMenor = produto < 5000;
        Integer atual = produto;

        while(numerosPrimos < aaa){
            if(checkPrimo.Alg3(atual) ==1){
                allPrimos.add(atual);
                numerosPrimos++;
                somaPrimos = somaPrimos + atual;
            }
            if(isMenor)
                atual++;
            else
                atual--;
        }

        raObject.setSomaPrimos(somaPrimos);
        raObject.setTotalPrimos(numerosPrimos);
        Collections.sort(allPrimos);
        raObject.setTodosPrimos(allPrimos);

        return raObject;
    }

}

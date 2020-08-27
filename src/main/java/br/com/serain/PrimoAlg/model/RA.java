package br.com.serain.PrimoAlg.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RA {
    private String ra;
    private Integer totalPrimos;
    private Integer somaPrimos;
    private List<Integer> todosPrimos;
}

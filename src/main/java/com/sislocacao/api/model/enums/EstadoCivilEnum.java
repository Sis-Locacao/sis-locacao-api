package com.sislocacao.api.model.enums;

public enum EstadoCivilEnum {	
	SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo");
    
    private final String descricao;
    
    EstadoCivilEnum(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}

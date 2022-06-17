package br.com.stoc.model;

public enum ePermissão {
	ALMOXARIFE("ROLE_ALMOXARIFE"),
	ADMINISTRADOR("ROLE_ADMINISTRADOR");
	
	public final String valor;
	ePermissão(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor() {
		return valor;
	}
}

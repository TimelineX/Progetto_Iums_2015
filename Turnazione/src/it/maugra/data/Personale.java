package it.maugra.data;

public abstract class Personale {
	private Integer perid;
	private String Cognome;
	private String Nome;
	public static enum Ruolo {
		AGENTE,  AGENTE_SCELTO, ASSISTENTE, ASSISTENTE_CAPO
		}
	
	public Integer getPerid() {
		return perid;
	}
	public void setPerid(Integer perid) {
		this.perid = perid;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	

}

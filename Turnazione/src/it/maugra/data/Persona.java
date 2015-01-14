package it.maugra.data;

public class Persona {
	private String PerId;
	private String Nome;
	private String Cognome;
	private String Qualifica;
	
	/* Generazione metodi Setter e Getter */ 
	
	public String getPerId() {
		return PerId;
	}
	public void setPerId(String perId) {
		PerId = perId;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getQualifica() {
		return Qualifica;
	}
	public void setQualifica(String qualifica) {
		Qualifica = qualifica;
	}

}

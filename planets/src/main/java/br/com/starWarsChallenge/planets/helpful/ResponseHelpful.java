package br.com.starWarsChallenge.planets.helpful;

import java.util.List;

public class ResponseHelpful<T> {
	
	 private T dados;
     private String msg;
     private List<String> erros;

     public ResponseHelpful(T dados, String msg) {
         this.dados = dados;
         this.msg = msg;
     }

     public ResponseHelpful(String msg) {
         this.msg = msg;
     }
     
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }

	public T getDados() {
		return dados;
	}

	public void setDados(T dados) {
		this.dados = dados;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
     
     

}

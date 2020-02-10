package br.com.starWarsChallenge.planets.exception;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1934079739801937898L;

	public BusinessException() {
	}

	public BusinessException(final String msg) {
		super(msg);
	}

	public BusinessException(final Throwable erro) {
		super(erro);
	}

	public BusinessException(final String msg, final Throwable erro) {
		super(msg, erro);
	}
	
	
}

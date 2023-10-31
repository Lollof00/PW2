package com.candidatoDB.pw2.entity;

import java.util.ArrayList;
import java.util.List;

public class UtenteQuiz {

	private int id_utente_quiz;
	private List<Quiz> id_quiz = new ArrayList<Quiz>();
	private int id_user;
	private int punteggio;
	
	public UtenteQuiz() {
		super();
	}
	public UtenteQuiz(int id_utente_quiz, List<Quiz> id_quiz, int id_user, int punteggio) {
		super();
		this.id_utente_quiz = id_utente_quiz;
		this.id_quiz = id_quiz;
		this.id_user = id_user;
		this.punteggio = punteggio;
	}
	public int getId_utente_quiz() {
		return id_utente_quiz;
	}
	public void setId_utente_quiz(int id_utente_quiz) {
		this.id_utente_quiz = id_utente_quiz;
	}
	public List<Quiz> getId_quiz() {
		return id_quiz;
	}
	public void setId_quiz(List<Quiz> id_quiz) {
		this.id_quiz = id_quiz;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	@Override
	public String toString() {
		return "UtenteQuiz [id_utente_quiz=" + id_utente_quiz + ", id_quiz=" + id_quiz + ", id_user=" + id_user
				+ ", punteggio=" + punteggio + "]";
	}
	
	
}
package com.candidatoDB.pw2.interfaces.impl;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import com.candidatoDB.pw2.entity.Citta;

import com.candidatoDB.pw2.entity.Esperienza;

import com.candidatoDB.pw2.entity.Quiz;

import com.candidatoDB.pw2.entity.Utente;

import com.candidatoDB.pw2.interfaces.UtenteDAO;

import com.servlets.pw2.controller.DBUtil;

import com.servlets.pw2.controller.SQLServerConnection;

public class UtenteIMPL implements UtenteDAO {

	private SQLServerConnection connection = new SQLServerConnection();

	public UtenteIMPL() {

		connection.Connect();

	}

	@Override

	public void save(Utente utente) {

		String sql = "INSERT INTO Utente(nome,cognome,codice_fiscale,email,data_nascita,indirizzo,id_citta,cap,telefono,password,token) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getCodice_fiscale());

			statement.setString(4, utente.getEmail());

			statement.setDate(5, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(6, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(7, Types.INTEGER);

			}

			statement.setString(8, utente.getCap());

			statement.setString(9, utente.getTelefono());

			statement.setString(10, utente.getPassword());

			statement.setString(11, utente.getToken());

			statement.executeUpdate();

			// resultSet = statement.getGeneratedKeys();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			// DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

	}

	@Override

	public void updateAll(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,codice_fiscale=?,email=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,telefono=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?, token=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getCodice_fiscale());

			statement.setString(4, utente.getEmail());

			statement.setDate(5, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(6, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(7, Types.INTEGER);

			} else {

				statement.setInt(7, utente.getId_citta().getId_citta());

			}

			statement.setString(8, utente.getCap());

			statement.setString(9, utente.getTelefono());

			statement.setString(10, utente.getRuolo_admin());

			statement.setString(11, utente.getPassword());

			statement.setString(12, utente.getFoto_profilo());

			statement.setString(13, utente.getGenere());

			statement.setInt(16, utente.getId_user());

			statement.setString(14, utente.getCV());

			statement.setString(15, utente.getToken());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	@Override

	public void updateMail(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,email=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getEmail());

			statement.setDate(4, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(5, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(6, Types.INTEGER);

			} else {

				statement.setInt(6, utente.getId_citta().getId_citta());

			}

			statement.setString(7, utente.getCap());

			statement.setString(8, utente.getRuolo_admin());

			statement.setString(9, utente.getPassword());

			statement.setString(10, utente.getFoto_profilo());

			statement.setString(11, utente.getGenere());

			statement.setInt(13, utente.getId_user());

			statement.setString(12, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateCodF(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,codice_fiscale=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getCodice_fiscale());

			statement.setDate(4, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(5, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(6, Types.INTEGER);

			} else {

				statement.setInt(6, utente.getId_citta().getId_citta());

			}

			statement.setString(7, utente.getCap());

			statement.setString(8, utente.getRuolo_admin());

			statement.setString(9, utente.getPassword());

			statement.setString(10, utente.getFoto_profilo());

			statement.setString(11, utente.getGenere());

			statement.setInt(13, utente.getId_user());

			statement.setString(12, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateTel(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,telefono=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setDate(3, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(4, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(5, Types.INTEGER);

			} else {

				statement.setInt(5, utente.getId_citta().getId_citta());

			}

			statement.setString(6, utente.getCap());

			statement.setString(7, utente.getTelefono());

			statement.setString(8, utente.getRuolo_admin());

			statement.setString(9, utente.getPassword());

			statement.setString(10, utente.getFoto_profilo());

			statement.setString(11, utente.getGenere());

			statement.setInt(13, utente.getId_user());

			statement.setString(12, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateMailAndTel(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,email=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,telefono=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getEmail());

			statement.setDate(4, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(5, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(6, Types.INTEGER);

			} else {

				statement.setInt(6, utente.getId_citta().getId_citta());

			}

			statement.setString(7, utente.getCap());

			statement.setString(8, utente.getTelefono());

			statement.setString(9, utente.getRuolo_admin());

			statement.setString(10, utente.getPassword());

			statement.setString(11, utente.getFoto_profilo());

			statement.setString(12, utente.getGenere());

			statement.setInt(14, utente.getId_user());

			statement.setString(13, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateMailAndCodF(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,codice_fiscale=?,email=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getCodice_fiscale());

			statement.setString(4, utente.getEmail());

			statement.setDate(5, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(6, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(7, Types.INTEGER);

			} else {

				statement.setInt(7, utente.getId_citta().getId_citta());

			}

			statement.setString(8, utente.getCap());

			statement.setString(9, utente.getRuolo_admin());

			statement.setString(10, utente.getPassword());

			statement.setString(11, utente.getFoto_profilo());

			statement.setString(12, utente.getGenere());

			statement.setInt(14, utente.getId_user());

			statement.setString(13, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateTelAndCodF(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,codice_fiscale=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,telefono=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setString(3, utente.getCodice_fiscale());

			statement.setDate(4, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(5, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(6, Types.INTEGER);

			} else {

				statement.setInt(6, utente.getId_citta().getId_citta());

			}

			statement.setString(7, utente.getCap());

			statement.setString(8, utente.getTelefono());

			statement.setString(9, utente.getRuolo_admin());

			statement.setString(10, utente.getPassword());

			statement.setString(11, utente.getFoto_profilo());

			statement.setString(12, utente.getGenere());

			statement.setInt(14, utente.getId_user());

			statement.setString(13, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	public void updateOnlyNotUnique(Utente utente) {

		String sql = "UPDATE Utente SET nome=?,cognome=?,data_nascita=?,indirizzo=?,id_citta=?,cap=?,ruolo_admin=?,password=?, foto_profilo=?, genere=?, CV=?  WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			// statement.setInt(1, utente.getId_user());

			statement.setString(1, utente.getNome());

			statement.setString(2, utente.getCognome());

			statement.setDate(3, new java.sql.Date(utente.getData_nascita().getTime()));

			statement.setString(4, utente.getIndirizzo());

			if (utente.getId_citta() == null) {

				statement.setNull(5, Types.INTEGER);

			} else {

				statement.setInt(5, utente.getId_citta().getId_citta());

			}

			statement.setString(6, utente.getCap());

			statement.setString(7, utente.getRuolo_admin());

			statement.setString(8, utente.getPassword());

			statement.setString(9, utente.getFoto_profilo());

			statement.setString(10, utente.getGenere());

			statement.setInt(12, utente.getId_user());

			statement.setString(11, utente.getCV());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

	}

	@Override
	public void UpdatePrimoLogin(Utente user) {
		String sql = "UPDATE Utente SET primo_login=? WHERE id_user=?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setBoolean(1, user.getPrimo_login());

			statement.setInt(2, user.getId_user());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}
	}

	@Override

	public Utente findById(int id_user) {

		Utente utente = new Utente();

		// Citta cittaUtente = new Citta();

		String sql = "SELECT Utente.id_user, Utente.nome, Utente.cognome, Utente.codice_fiscale, Utente.email, Utente.data_nascita, Utente.indirizzo, Utente.id_citta, Utente.cap, Utente.telefono, Utente.password, Utente.foto_profilo, Utente.genere, Utente.ruolo_admin, Utente.CV, Utente.token, Utente.primo_login from Utente where Utente.id_user=?";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, id_user);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				utente.setId_user(resultSet.getInt(1));

				utente.setNome(resultSet.getString(2));

				utente.setCognome(resultSet.getString(3));

				utente.setCodice_fiscale(resultSet.getString(4));

				utente.setEmail(resultSet.getString(5));

				if (resultSet.getDate(6) != null) {

					utente.setData_nascita(new java.sql.Date(resultSet.getDate(6).getTime()));

				}

				utente.setIndirizzo(resultSet.getString(7));

				if (resultSet.getString(8) == null) {

					System.out.println("No citta");

					// utente.setId_citta(cittaUtente);

				} else {

					utente.setId_citta(getUserCitta(utente));

					System.out.println("SI citta");

				}

				utente.setCap(resultSet.getString(9));

				utente.setTelefono(resultSet.getString(10));

				utente.setPassword(resultSet.getString(11));

				utente.setFoto_profilo(resultSet.getString(12));

				utente.setGenere(resultSet.getString(13));

				utente.setRuolo_admin(resultSet.getString(14));

				utente.setCV(resultSet.getString(15));

				utente.setToken(resultSet.getString(16));

				utente.setPrimo_login(resultSet.getBoolean(17));

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

		return utente;

	}

	@Override

	public List<Esperienza> findEsperienzeById(int id_user) {

		List<Esperienza> esperienze = new ArrayList<Esperienza>();

		String sql = "SELECT Esperienza.id_esperienza,Esperienza.anni,Esperienza.descrizione_attivita,Esperienza.azienda,Esperienza.data_inizio,Esperienza.data_fine,Esperienza.ral, Esperienza.tipo_contratto, Esperienza.settore, Esperienza.posizione_lavorativa FROM Esperienza  INNER JOIN Utente  ON Esperienza.id_user = Utente.id_user WHERE Utente.id_user = ?;";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, id_user);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Esperienza esperienza = new Esperienza();

				esperienza.setId_esperienza(resultSet.getInt(1));

				esperienza.setAnni(resultSet.getInt(2));

				esperienza.setDescrizione_attivita(resultSet.getString(3));

				Utente utente = new Utente();

				utente.setId_user(resultSet.getInt(4));

				esperienza.setUtente(utente);

				esperienza.setAzienda(resultSet.getString(5));

				esperienza.setData_inizio(new java.sql.Date(resultSet.getDate(6).getTime()));

				esperienza.setData_fine(new java.sql.Date(resultSet.getDate(7).getTime()));

				esperienza.setRal(resultSet.getInt(8));

				esperienza.setTipo_contratto(resultSet.getString(9));

				esperienza.setSettore(resultSet.getString(10));

				esperienza.setPosizione_lavorativa(resultSet.getString(11));

				esperienze.add(esperienza);

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

		return esperienze;

	}

	@Override

	public List<Quiz> findByUtenteQuiz(int id_utente_quiz) {

		// TODO Auto-generated method stub

		return null;

	}

	@Override

	public int findPunteggioById(int id_utente_quiz) {

		// TODO Auto-generated method stub

		return 0;

	}

	@Override

	public void deleteEsperienza(Esperienza esperienza) {

		String sql = "DELETE FROM Utente INNER JOIN Eseperienza ON Utente.id_user = Esperienza.id_user WHERE id_esperienza = ?";

		PreparedStatement statement = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, esperienza.getId_esperienza());

			statement.executeUpdate();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

	}

	@Override

	public Citta getUserCitta(Utente utente) {

		Citta cittaUtente = new Citta();

		String sql = "SELECT Citta.nome, Citta.id_citta, Citta.id_regione from Citta inner join Utente on Citta.id_citta = Utente.id_citta where Utente.id_user=?";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, utente.getId_user());

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				cittaUtente.setNome(resultSet.getString(1));

				cittaUtente.setId_citta(resultSet.getInt(2));

				CittaIMPL cittaIMPL = new CittaIMPL();

				cittaUtente.setRegione(cittaIMPL.getRegione(resultSet.getInt(3)));

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

		return cittaUtente;

	}

	@Override

	public ArrayList<Utente> getTop3UserByIdCandidatura(int id_posizione) {

		ArrayList<Utente> top_3_utenti = new ArrayList<>();

		String sql = "WITH ranked_users AS (\n" +
				"    SELECT \n" +
				"        U.id_user,\n" +
				"        U.nome,\n" +
				"        U.cognome,\n" +
				"        COUNT(US.id_skill) AS SkillsVerificate,\n" +
				"        UQ.punteggio AS PunteggioQuiz,\n" +
				"        ROW_NUMBER() OVER (PARTITION BY U.id_user ORDER BY UQ.punteggio DESC, COUNT(US.id_skill) DESC) as user_rank\n" +
				"    FROM\n" +
				"        Utente U\n" +
				"    JOIN \n" +
				"        CandidaturaUser CU ON U.id_user = CU.id_user\n" +
				"    JOIN \n" +
				"        Posizione P ON CU.id_posizione = P.id_posizione\n" +
				"    LEFT JOIN \n" +
				"        UserSkills US ON U.id_user = US.id_user AND US.verificata = 1\n" +
				"    LEFT JOIN \n" +
				"        UtenteQuiz UQ ON U.id_user = UQ.id_user\n" +
				"    LEFT JOIN \n" +
				"        Quiz Q ON P.id_quiz = Q.id_quiz AND UQ.id_quiz = Q.id_quiz\n" +
				"    WHERE\n" +
				"        P.id_posizione = ?\n" +
				"    GROUP BY \n" +
				"        U.id_user, U.nome, U.cognome, UQ.punteggio\n" +
				")\n" +
				"SELECT * FROM ranked_users WHERE user_rank = 1\n" +
				"ORDER BY PunteggioQuiz DESC, SkillsVerificate DESC \n" +
				"OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, id_posizione);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				UtenteIMPL utenteIMPL = new UtenteIMPL();

				Utente utente = utenteIMPL.findById(resultSet.getInt("id_user"));

				top_3_utenti.add(utente);

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

		return top_3_utenti;

	}

	@Override

	public ArrayList<Utente> getAllUserByIdCandidatura(int id_posizione) {

		ArrayList<Utente> all_users_candidatura = new ArrayList<>();

		String sql =  "WITH ranked_users AS (\n" +
				"    SELECT \n" +
				"        U.id_user,\n" +
				"        U.nome,\n" +
				"        U.cognome,\n" +
				"        COUNT(US.id_skill) AS SkillsVerificate,\n" +
				"        UQ.punteggio AS PunteggioQuiz,\n" +
				"        ROW_NUMBER() OVER (PARTITION BY U.id_user ORDER BY UQ.punteggio DESC, COUNT(US.id_skill) DESC) as user_rank\n" +
				"    FROM\n" +
				"        Utente U\n" +
				"    JOIN \n" +
				"        CandidaturaUser CU ON U.id_user = CU.id_user\n" +
				"    JOIN \n" +
				"        Posizione P ON CU.id_posizione = P.id_posizione\n" +
				"    LEFT JOIN \n" +
				"        UserSkills US ON U.id_user = US.id_user AND US.verificata = 1\n" +
				"    LEFT JOIN \n" +
				"        UtenteQuiz UQ ON U.id_user = UQ.id_user\n" +
				"    LEFT JOIN \n" +
				"        Quiz Q ON P.id_quiz = Q.id_quiz AND UQ.id_quiz = Q.id_quiz\n" +
				"    WHERE\n" +
				"        P.id_posizione = ?\n" +
				"    GROUP BY \n" +
				"        U.id_user, U.nome, U.cognome, UQ.punteggio\n" +
				")\n" +
				"SELECT * FROM ranked_users WHERE user_rank = 1\n" +
				"ORDER BY PunteggioQuiz DESC, SkillsVerificate DESC \n";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, id_posizione);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				UtenteIMPL utenteIMPL = new UtenteIMPL();

				Utente utente = utenteIMPL.findById(resultSet.getInt("id_user"));

				all_users_candidatura.add(utente);

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

		return all_users_candidatura;


	}

	public ArrayList<String> getEmptyParameters(Utente utente) {

		ArrayList<String> campi_vuoti = new ArrayList<>();

		String sql = "SELECT codice_fiscale, data_nascita, indirizzo, cap, telefono, genere, foto_profilo, id_citta  from Utente where id_user=?";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, utente.getId_user());

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				if (resultSet.getString(1) == null) {

					campi_vuoti.add("Codice Fiscale");

				}

				if (resultSet.getString(2) == null) {

					campi_vuoti.add("Data di nascita");

				}

				if (resultSet.getString(3) == null) {

					campi_vuoti.add("Indirizzo");

				}

				if (resultSet.getString(4) == null) {

					campi_vuoti.add("Cap");

				}

				if (resultSet.getString(5) == null) {

					campi_vuoti.add("Telefono");

				}

				if (resultSet.getString(6) == null) {

					campi_vuoti.add("Genere");

				}

				if (resultSet.getString(7) == null) {

					campi_vuoti.add("Foto profilo");

				}

				if (resultSet.getString(8) == null) {

					campi_vuoti.add("Citta di nascita");

				}

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close((Connection) connection);

		}

		return campi_vuoti;

	}
	//-----------------------------------------------------------------------------------------------
	public Integer findByIdUtenteQuiz(int id_utente_quiz) {

		Utente utente = new Utente();

		// Citta cittaUtente = new Citta();

		String sql = "SELECT u.id_user from Utente u join utenteQuiz uq on u.id_user=uq.id_user where uq.id_utente_quiz=?";

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			statement = connection.getConnection().prepareStatement(sql);

			statement.setInt(1, id_utente_quiz);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				utente.setId_user(resultSet.getInt("id_user"));

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			DBUtil.close(resultSet);

			DBUtil.close(statement);

			// DBUtil.close(connection.getConnection());

		}

		return utente.getId_user();

	}


}

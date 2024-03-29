package com.candidatoDB.pw2.interfaces;
import java.sql.PreparedStatement;
import java.util.List;

import com.candidatoDB.pw2.entity.*;

public interface IstruzioneDAO {

    void save(Istruzione istruzioni);

	void update(Istruzione istruzioni);
	
	List<Istruzione> getAllInstruction(int id_user);

	void deleteIstruzioneUtente(int id_istruzione);
}


package poo4.Main;

import javafx.application.Application;
import poo4.Database.UtilBD;
import poo4.IHC.Login;

public class Main {

	public static void main(String[] args) {
		
		UtilBD.initBD();

		Application.launch(Login.class);
		
		UtilBD.fecharConexao();

	}

}

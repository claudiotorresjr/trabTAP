import java.util.*;
import java.text.*;

public class UsuarioFactory{
	public Usuario criaUsuario(String novoNome, String novoTelefone, String novoStatus, String novoFoto){

		return new Usuario(novoNome, novoTelefone, novoStatus, novoFoto);
	}
}
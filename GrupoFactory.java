import java.util.*;
import java.text.*;

public class GrupoFactory{
	public Grupo criaGrupo(Usuario novoAdmin, String novoNome, String novoDescricao){

		return new Grupo(novoAdmin, novoNome, novoDescricao);
	}
}
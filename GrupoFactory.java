import java.util.*;
import java.text.*;

public class GrupoFactory{
	public Grupo criaNovoGrupo(Usuario novoAdmin, String novoNome, String novoDescricao){

		return new Grupo(novoAdmin, novoNome, novoDescricao);
	}
}
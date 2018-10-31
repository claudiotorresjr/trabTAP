import java.util.*;
import java.text.*;

interface Observavel{
	public void atualizaObservadores(Mensagem mensagem, Usuario naoViu);
	//public void apagarMensagemGrupo(mensagem);
}

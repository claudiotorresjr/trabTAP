import java.util.*;
import java.text.*;

public interface MensagemCommand{
	void enviarMensagem(String tipo, String conteudo, Grupo grupo, Usuario naoViu);
	void apagarMensagem(Mensagem mensagem);
}
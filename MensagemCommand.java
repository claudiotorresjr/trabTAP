import java.util.*;
import java.text.*;

public interface MensagemCommand{
	void enviarMensagem(String tipo, String conteudo, Grupo grupo);
	//void naoVisualizouMensagem(Grupo grupo);
}
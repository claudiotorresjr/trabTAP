import java.util.*;
import java.text.*;

interface Observador{
	public void atualiza(Mensagem novaMensagem, ArrayList <Mensagem> mensagens);       //atualiza as mensagens do observador
}
import java.util.*;
import java.text.*;

public class MensagemTexto extends Mensagem{

	// Construtor
	public MensagemTexto(Usuario sender, String tipo, String conteudo, Grupo grupo){
		this.setUsuario(sender);	    				//seta quem mandou da mensagem
		this.setTipo(tipo);								//seta tipo da mensagem
		this.setConteudo(conteudo);						//seta conteudo da mensagem
		this.setGrupo(grupo);							//seta o grupo que foi enviada e mensagem
		this.setHorarioMensagem();	    				//seta horario da mensagem
		this.criaVistoPor();				            // Cria lista de observadores
		this.setEnvio(" disse: ");	    		        //seta quem mandou da mensagem
		this.setApagada(false);	   						
	}
}
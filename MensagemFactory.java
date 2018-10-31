import java.util.*;
import java.text.*;

public class MensagemFactory{
	public Mensagem criaMensagem(Usuario sender, String tipo, String conteudo, Grupo grupo){
		//retorna o tipo de mensagem especifico para cada tipo
		if(tipo.equals("texto")){
			return new MensagemTexto(sender, tipo, conteudo, grupo);
		}else if(tipo.equals("foto")){
			return new MensagemFoto(sender, tipo, conteudo, grupo);
		}else if(tipo.equals("video")){
			return new MensagemVideo(sender, tipo, conteudo, grupo);
		}if(tipo.equals("audio")){
			return new MensagemAudio(sender, tipo, conteudo, grupo);
		}else{
			return null;
		}
	}
}
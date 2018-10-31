import java.util.*;
import java.text.*;

public class Mensagem{
	//atributos privados
	private Date horarioMensagem;   					// Hora em que a mensagem foi enviada
	private Usuario usuario;        					// Usuário que mandou a mensagem
	private Grupo grupo;        					    // grupo que esta a mensagem
	private String tipo; 								//guarda o tipo da mensagem
	private String conteudo;							//guarda o conteudo da mensagem
	private ArrayList <Usuario> vistoPor;               // Lista de usuarios que visualizaram
	private String envio;   							//mostra no grupo a frase adequada para o que foi enviado
	private boolean apagada;							//sinaliza se a mensagem foi apagada ou nao

	// Seters
	public void setTipo(String novoTipo){
		tipo = novoTipo;
	}
	public void setConteudo(String novoConteudo){
		conteudo = novoConteudo;
	}
	public void setHorarioMensagem(){
		horarioMensagem = new Date();
	}
	public void setUsuario(Usuario novoUsuario){
		usuario = novoUsuario;
	}
	public void setGrupo(Grupo novoGrupo){
		grupo = novoGrupo;
	}
	public void setVistoPor(Usuario novoUsuario){
		vistoPor.add(novoUsuario);
	}
	public void setEnvio(String metodo){
		envio = metodo;
	}
	public void setApagada(boolean apagada){
		this.apagada = apagada;
	}

	// Geters.
	public String getTipo(){
		return (tipo);
	}
	public String getConteudo(){
		return (conteudo);
	}
	public Date getHorarioMensagem(){
		return (horarioMensagem);
	}
	public Usuario getUsuario(){
		return (usuario);
	}
	public Grupo getGrupo(){
		return (grupo);
	}
	public int getNumeroVistoPor(){
		return (vistoPor.size());
	}
	public ArrayList <Usuario> getArrayVistoPor(){
		return (vistoPor);
	}
	public Usuario getVistoPor(int indice){
		return (vistoPor.get(indice));
	}
	public String getEnvio(){
		return (envio);
	}
	public boolean getApagada(){
		return (apagada);
	}
	public void removeVistoPor(Usuario naoViu){
		vistoPor.remove(naoViu);
	}
	public void criaVistoPor(){
		vistoPor = new ArrayList <Usuario>();
	}
}
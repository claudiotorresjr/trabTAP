import java.util.*;
import java.text.*;

public class Grupo implements Observavel{

	private String nome;								//nome do grupo
	private String descricao;							//descrição do grupo
	private ArrayList <Usuario> usuariosComuns;         // Lista de usuarios comuns
	private ArrayList <Usuario> observadores;           // Lista de observadores (todos os participantes)
	private ArrayList <Mensagem> mensagens;             // Lista de mensagens
	private Usuario admin; 								// admin do grupo (quem o criou)
	
	// Seters
	public void setMensagens(Mensagem novaMensagem){
		mensagens.add(novaMensagem);
	}
	public void setUsuariosComuns(Usuario novoMembro){
		usuariosComuns.add(novoMembro);
	}
	public void setObservadores(Usuario novoMembro){
		observadores.add(novoMembro);
	}

	// Geters
	public String getNome(){
		return(nome);
	}
	public int getNumeroUsuarios(){
		return observadores.size();
	}
	public int getNumeroMensagens(){
		return mensagens.size();
	}
	public Usuario getMembro(int indice){
		return(observadores.get(indice));
	}
	public Usuario getAdmin(){
		return(admin);
	}
	public int getIndiceMembro(Usuario membroProcurado){
		return(observadores.indexOf(membroProcurado));
	}
	public Mensagem getMensagem(int indice){
		return(mensagens.get(indice));
	}
	public int getIndiceMensagem(Mensagem mensagemProcurada){
		return(mensagens.indexOf(mensagemProcurada));
	}

	//interfaces
	//manda a atualização para todos os observadores do grupo
	public void atualizaObservadores(Mensagem novaMensagem, Usuario naoViu){
		if(!novaMensagem.getApagada()){
			this.setMensagens(novaMensagem);
		}
		//seta os usuarios que visualizaram a mensagem
		for(int i = 0; i < this.getNumeroUsuarios(); ++i){
			if(this.getMembro(i) != naoViu && !novaMensagem.getApagada()){
				novaMensagem.setVistoPor(this.getMembro(i));
			}
		}
		//manda a mensagem para a tela de cada usuario que a viu
		for(int i = 0; i < observadores.size(); ++i){
			if(this.getMembro(i) != naoViu){
				observadores.get(i).atualiza(novaMensagem, this.mensagens);
			}
		}
	}

	// Construtor
	public Grupo(Usuario novoAdmin, String novoNome, String novoDescricao){
		nome = novoNome;                                  // Seta o nome do grupo
		descricao = novoDescricao;                        // Seta a descrição do grupo 
		admin = novoAdmin;                                // Seta administrador do grupo 	
		usuariosComuns = new ArrayList <Usuario>();       // Cria lista de membros
		observadores = new ArrayList <Usuario>();         // Cria lista de observadores
		mensagens = new ArrayList <Mensagem>();           // Cria lista de observadores
		observadores.add(novoAdmin);
		System.out.println("---> "+novoAdmin.getNome()+" criou o grupo '"+this.getNome()+"'.\n");
		System.out.println("-------------------------------------------------------------");
	}
}
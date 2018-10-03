import java.util.*;
import java.text.*;

public class Grupo{

	private String nome;								//nome do grupo
	private String descricao;							//descrição do grupo
	private ArrayList <Usuario> usuariosComuns;         // Lista de usuarios comuns
	private Usuario admin; 								// admin do grupo (quem o criou)
	
	// Geters
	public String getNome(){
		return(nome);
	}
	public int getNumeroUsuariosComuns(){
		return usuariosComuns.size();
	}
	public Usuario getMembro(int indice){
		return(usuariosComuns.get(indice));
	}
	public Usuario getAdmin(){
		return(admin);
	}
	public int getIndiceMembro(Usuario membroProcurado){
		return(usuariosComuns.indexOf(membroProcurado));
	}

	// Adiciona um novo membro a lista de membros
	public void adicionaMembro(Usuario ehAdmin, Usuario novoMembro){
		if(ehAdmin == admin){
			usuariosComuns.add(novoMembro);
			System.out.println(ehAdmin.getNome()+" adicionou "+novoMembro.getNome()+" com sucesso.");
		}else{
			System.out.println(ehAdmin.getNome()+" não pode adicionar "+novoMembro.getNome()+" pois não é administrador do grupo.");
		}
	}

	// Construtor
	public Grupo(Usuario novoAdmin, String novoNome, String novoDescricao){
        nome = novoNome;                                  // Seta o nome do grupo
        descricao = novoDescricao;                        // Seta a descrição do grupo 
        admin = novoAdmin;                                // Seta administrador do grupo 
		usuariosComuns = new ArrayList <Usuario>();       // Cria lista de membros
		//observadores = new ArrayList <Usuario>();       // Cria lista de observadores
    }
}
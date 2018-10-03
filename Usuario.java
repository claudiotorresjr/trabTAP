import java.util.*;
import java.text.*;

public class Usuario{
	//atributos privados
    private String nome; //nome do usuario
    private String telefone; // telefone do usuario
	private String status; //status do usuario
	private String foto; //foto do usuario (seria q tipo?)

	private ArrayList <Usuario> meusGrupos;         // Lista de observadores
	private ArrayList <Usuario> observadores;       // Lista de observadores
	
	// Geters
	public String getNome(){
		return(nome);
	}
	
	//Seters
	private void setNome(String novoNome){
		nome = novoNome;
	}
	private void setTelefone(String novoTelefone){
		telefone = novoTelefone;
	}
	private void setStatus(String novoStatus){
		status = novoStatus;
	}
	private void setFoto(String novoFoto){
		foto = novoFoto;
	}

	// Construtor
    public Usuario(String novoNome, String novoTelefone, String novoStatus, String novoFoto){
        this.setNome(novoNome);                           // Seta o nome do usuario
        this.setTelefone(novoTelefone);                   // Seta o telefone do usuario
        this.setStatus(novoStatus);                       // Seta o status do usuario
        this.setFoto(novoFoto);                           // Seta a foto do usuario
       //meusGrupos = new ArrayList <Grupo>();             // Cria lista de grupos
        observadores = new ArrayList <Usuario>();         // Cria lista de observadores
    }
}
import java.util.*;
import java.text.*;

public class Usuario implements Observador, MensagemCommand{
	// atributos privados
    private String nome; 							// Nome do usuario
    private String telefone; 						// Telefone do usuario
	private String status; 							// Status do usuario
	private String foto; 							// Foto do usuario (seria q tipo?)

	private ArrayList <Grupo> meusGrupos;			// Lista de grupos que a pessoa é membro
	
	// Geters
	public String getNome(){
		return(nome);
	}
	public int getIndiceGrupo(Grupo grupoProcurado){
		return(meusGrupos.indexOf(grupoProcurado));
	}
	public Grupo getGrupo(int indice){
		return(meusGrupos.get(indice));
	}
	
	// Seters
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
	private void setGrupo(Grupo novoGrupo){
		meusGrupos.add(novoGrupo);
	}
	private void removeGrupo(Grupo novoGrupo){
		meusGrupos.remove(novoGrupo);
	}

	// Cria um grupo
	public Grupo criaGrupo(Grupo grupo, String novoNome, String novoDescricao){
		GrupoFactory gp = new GrupoFactory();
		grupo = gp.criaNovoGrupo(this, novoNome, novoDescricao);
		this.setGrupo(grupo);
		return (grupo);
	}

	// Adiciona um novo membro a lista de membros do grupo
	public void adicionaMembro(Usuario novoMembro, Grupo grupo){
		System.out.println("---> " + this.getNome() + " esta tentando adicionar " + novoMembro.getNome() + " ao grupo '" + grupo.getNome() + "'...\n");
		if(this == grupo.getAdmin()){
			if(grupo.getIndiceMembro(novoMembro) < 0){
				grupo.setUsuariosComuns(novoMembro);
				grupo.setObservadores(novoMembro);
				novoMembro.setGrupo(grupo);
				System.out.println(this.getNome() + " adicionou " + novoMembro.getNome() + " com sucesso.");
				System.out.println("-------------------------------------------------------------");
			}else{
				System.out.println(novoMembro.getNome() + " já está no grupo.");
				System.out.println("-------------------------------------------------------------");
			}
		}else{
			System.out.println(this.getNome() + " não pode adicionar " + novoMembro.getNome() + " pois não é administrador do grupo.");
			System.out.println("-------------------------------------------------------------");
		}
	}

	// Interfaces
	// Implementa o metodo de MensagemCommand para:
	// enviar mensagem
	public void enviarMensagem(String tipo, String conteudo, Grupo grupo, Usuario naoViu){
		//verifica se o usuario que quer enviar a mensagem se encontra no grupo
		if(this.getIndiceGrupo(grupo) < 0){
			System.out.println(" Mensagem não enviada pois " + this.getNome() + " não faz parte do grupo '" + grupo.getNome() + "'");
			System.out.println("-------------------------------------------------------------");
		}else{
			MensagemFactory msgf = new MensagemFactory();
			Mensagem mensagem = msgf.criaMensagem(this, tipo, conteudo, grupo);

			System.out.println("\n\n-------------------------------------------------------------");
			System.out.println(this.getNome() + " enviou uma mensagem de " + mensagem.getTipo() + " no grupo: '" + grupo.getNome() + "'");
			System.out.println("-------------------------------------------------------------");
			grupo.atualizaObservadores(mensagem, naoViu);
		}
	}

	// apagar a mensagem
	public void apagarMensagem(Mensagem mensagem){
		//verifica se o usuario que quer apagar a mensagem se encontra no grupo
		if(this.getIndiceGrupo(mensagem.getGrupo()) < 0){
			System.out.println(" Mensagem não apagada pois " + this.getNome() + " não faz parte do grupo '" + mensagem.getGrupo().getNome() + "'");
			System.out.println("-------------------------------------------------------------");
		}else{
			System.out.println();
			System.out.println();
			System.out.println("-------------------------------------------------------------");
			System.out.println(this.getNome() + " esta apagando sua mensagem do grupo " + mensagem.getGrupo().getNome() + "...");
			System.out.println("-------------------------------------------------------------");
			mensagem.setApagada(true);
			mensagem.getGrupo().atualizaObservadores(mensagem, null);
		}
	}


	// Imprime a atualização feita por algum objeto observavel
	public void atualiza(Mensagem novaMensagem, ArrayList <Mensagem> mensagens){
		int i, j;
		System.out.println("\n\n=========== Grupo '" + novaMensagem.getGrupo().getNome() + "' de " + this.getNome() + "  ===========");

		//laço para cada usuario poder ver ou nao a mensagem caso seja apagada
		for(i = 0; i < mensagens.size(); ++i){

			//verifica se o usuario viu a mensagem
			for(j = 0; j < mensagens.get(i).getNumeroVistoPor(); ++j){
				if(this == mensagens.get(i).getVistoPor(j)){
					j = -1;
					break;
				}
			}
			//se nao viu e ela foi apagada, aparece "mensagem apagada"
			if(mensagens.get(i).getApagada() && j != -1){
				System.out.println("(mensagem apagada)");
			//se viu, aparece a mensagem para o usuario mesmo tendo sido apagada
			}else{
				System.out.println(mensagens.get(i).getUsuario().getNome() + mensagens.get(i).getEnvio() + mensagens.get(i).getConteudo() + " ( " + mensagens.get(i).getHorarioMensagem() + " ) ");
			}
		}
		System.out.println();
		//mostra quem visualizou a ultima mensagem enviada
		for(i = 0; i < novaMensagem.getNumeroVistoPor(); ++i){
			if(novaMensagem.getVistoPor(i) != this && novaMensagem.getVistoPor(i) != novaMensagem.getUsuario()){
				System.out.println("\t\t\t\t(visto por: " + novaMensagem.getVistoPor(i).getNome() + " )");
			}
		}

	}

	// Construtor
    public Usuario(String novoNome, String novoTelefone, String novoStatus, String novoFoto){
		this.setNome(novoNome);                           // Seta o nome do usuario
		this.setTelefone(novoTelefone);                   // Seta o telefone do usuario
		this.setStatus(novoStatus);                       // Seta o status do usuario
		this.setFoto(novoFoto);                           // Seta a foto do usuario
		meusGrupos = new ArrayList <Grupo>();             // Cria lista de grupos
    }
}

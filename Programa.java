import java.util.*;

class Programa{
	public static void main(String args[]){
		// Inicializa os usuários.
		UsuarioFactory usrfac = new UsuarioFactory();
		Usuario p1, p2, p3, p4 = null;
		GrupoFactory gp = new GrupoFactory();
		Grupo g1, g2, g3 = null; 

		//Criação de 4 usuários
		p1 = usrfac.criaUsuario("Claudio", "24011996", "Só quero que o semestre acabe :(", "semFoto");
		p2 = usrfac.criaUsuario("Gabriel", "22012006", "To na área galera", "semFoto");
		p3 = usrfac.criaUsuario("Arthur", "28022018", "Não tenho nem 1 ano de idade e já tenho whats", "semFoto");
		p4 = usrfac.criaUsuario("Joao", "11042014", "Que que eu to fazendo aqui? Sei nem ler", "semFoto");

		//criando 3 grupos e atribuindo os administradores respectivos		
		// p1 cria os grupos g1 e g2
		g1 = gp.criaGrupo(p1, "Breezers", "turma 7 IBM");
		System.out.println("---> "+p1.getNome()+" criou o grupo '"+g1.getNome()+"'.\n");
		g2 = gp.criaGrupo(p1, "Reides UFPR politecnico", "reides para pokemon go do politecnico");
		System.out.println("---> "+p1.getNome()+" criou o grupo '"+g2.getNome()+"'.\n");
		
		// p3 cria os grupos g3
		g3 = gp.criaGrupo(p3, "trabalho TAP", "grupo para discutir sobre o trabalho de TAP");
		System.out.println("---> "+p3.getNome()+" criou o grupo '"+g3.getNome()+"'.\n");

		// p1 inclui p2, p3 e p4 no grupo g1
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("---> "+p1.getNome()+" esta tentando adicionar "+p2.getNome()+", "+p3.getNome()+" e "+p4.getNome()+" ao grupo '"+g1.getNome()+"'...\n");
		g1.adicionaMembro(p1, p2);
		g1.adicionaMembro(p1, p3);
		g1.adicionaMembro(p1, p4);
		
		//p1 inclui p2 e p3 no grupo g2
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("---> "+p1.getNome()+" esta tentando adicionar "+p2.getNome()+" e "+p3.getNome()+" ao grupo '"+g2.getNome()+"'...\n");
		g2.adicionaMembro(p1, p2);
		g2.adicionaMembro(p1, p3);

		// p2 inclui p3 no grupo g2
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("---> "+p2.getNome()+" esta tentando adicionar "+p3.getNome()+" ao grupo '"+g2.getNome()+"'...\n");
		g2.adicionaMembro(p2, p3);

		//p3 inclui p4 no grupo g3
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("---> "+p3.getNome()+" esta tentando adicionar "+p4.getNome()+" ao grupo '"+g3.getNome()+"'...\n");
		g3.adicionaMembro(p3, p4);



	}
}
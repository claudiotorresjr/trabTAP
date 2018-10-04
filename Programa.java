import java.util.*;

class Programa{
	public static void main(String args[]){
		// Inicializa os usuários.
		Grupo g1 = null; 
		Grupo g2 = null; 
		Grupo g3 = null; 
		UsuarioFactory usrfac = new UsuarioFactory();

		//Criação de 4 usuários
		Usuario p1 = usrfac.criaUsuario("p1", "24011996", "Só quero que o semestre acabe :(", "semFoto");
		Usuario p2 = usrfac.criaUsuario("p2", "22012006", "To na área galera", "semFoto");
		Usuario p3 = usrfac.criaUsuario("p3", "28022018", "Não tenho nem 1 ano de idade e já tenho whats", "semFoto");
		Usuario p4 = usrfac.criaUsuario("p4", "11042014", "Que que eu to fazendo aqui? Sei nem ler", "semFoto");

		//criando 3 grupos e atribuindo os administradores respectivos		
		// p1 cria os grupos g1 e g2
		g1 = p1.criaGrupo(g1, "Breezers", "turma 7 IBM");
		g2 = p1.criaGrupo(g2, "Reides UFPR politecnico", "reides para pokemon go do politecnico");
		
		// p3 cria os grupos g3
		g3 = p3.criaGrupo(g3, "trabalho TAP", "grupo para discutir sobre o trabalho de TAP");

		// p1 inclui p2, p3 e p4 no grupo g1
		p1.adicionaMembro(p2, g1);
		p1.adicionaMembro(p3, g1);
		p1.adicionaMembro(p4, g1);
		
		//p1 inclui p2 e p3 no grupo g2
		p1.adicionaMembro(p2, g2);
		p1.adicionaMembro(p3, g2);

		// p2 inclui p3 no grupo g2
		p2.adicionaMembro(p3, g2);

		//p3 inclui p4 no grupo g3
		p3.adicionaMembro(p4, g3);

		//p2 envia mensagem para g1;
		//(todos visualizam)
		p2.enviarMensagem("video", "zé empinando a motoca", g1);
		

		//p1 envia mensagem para g1;
		//(todos visualizam)
		p1.enviarMensagem("foto", "o zé caido no chao", g1);


		//p2 envia mensagem para g2;
		//(todos menos p3 visualizam)
		p2.enviarMensagem("audio", "Ta chovendo ai? Aqui ta chovendo", g2, p3);

		//p3 envia mensagem para g3;
		//(todos menos p2 visualizam)
		p3.enviarMensagem("texto", "Me perdi de tanto grupo :o", g3, p2);

		//p3 envia mensagem para g2;
		//(p2 e p1 visualizam)
		p3.enviarMensagem("texto", "Meu deus tio! cê manda isso todo dia", g2);

		//p3 cancela mensagem para g3

		//p3 envia mensagem para g3;
		//(todos visualizam)
		p3.enviarMensagem("audio", "Pq um grupo só eu e vc? ", g3);
	}
}
import java.util.*;

class Programa{
	public static void main(String args[]){
		// Inicializa os grupo.
		Grupo g1 = null; 
		Grupo g2 = null; 
		Grupo g3 = null; 
		//cria a fabrica de usuarios
		UsuarioFactory usrfac = new UsuarioFactory();

		//Criação de 4 usuários
		Usuario p1 = usrfac.criaUsuario("Cláudio", "24011996", "Só quero que o semestre acabe :(", "semFoto");
		Usuario p2 = usrfac.criaUsuario("Gabriel", "22012006", "To na área galera", "semFoto");
		Usuario p3 = usrfac.criaUsuario("Arthur", "28022018", "Não tenho nem 1 ano de idade e já tenho whats", "semFoto");
		Usuario p4 = usrfac.criaUsuario("João", "11042014", "Que que eu to fazendo aqui? Sei nem ler", "semFoto");

		//criando 3 grupos e atribuindo os administradores respectivos		
		// p1 cria os grupos g1 e g2
		g1 = p1.criaGrupo(g1, "IBM-2017", "turma 7 IBM");
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

		//p3 inclui p4 no grupo g3
		p3.adicionaMembro(p4, g3);

		//p2 envia mensagem para g1;
		//(todos visualizam)
		p2.enviarMensagem("video", "zé empinando a motoca", g1, null);
		

		//p1 envia mensagem para g1;
		//(todos visualizam)
		p1.enviarMensagem("foto", "o zé caido no chao", g1, null);

		

		//p2 envia mensagem para g2;
		//(todos menos p3 visualizam)
		p2.enviarMensagem("audio", "Ta chovendo ai? Se tiver nao tem como participar", g2, p3);

		//p3 envia mensagem para g3;
		p3.enviarMensagem("texto", "Me perdi de tanto grupo :o", g3, null);

		//p3 envia mensagem para g2;
		//(p2 e p1 visualizam)
		p3.enviarMensagem("texto", "Parou de chover. Mas qualquer coisa temos guarda chuva :)", g2, null);

		//p3 cancela mensagem para g3
		p3.apagarMensagem(g3.getMensagem(g3.getNumeroMensagens() - 1));

		//p3 envia mensagem para g3;
		//(todos visualizam)
		p3.enviarMensagem("audio", "Pq um grupo só eu e vc? ", g3, null);
	}
}
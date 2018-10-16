package br.com.caelum.financas.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Telefone;
import br.com.caelum.financas.modelo.Usuario;
import br.com.caelum.financas.util.JPAUtil;

public class TesteUsuario {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Diego");
        
		Telefone telefone1 = new Telefone();
		telefone1.setDdd(11);
		telefone1.setNumero(957995397);
		
		Telefone telefone2 = new Telefone();
		telefone2.setDdd(11);
		telefone2.setNumero(999999999);
		
		List<Telefone> telefones = new ArrayList<>();
		telefones.add(telefone1);
		telefones.add(telefone2);
		
		usuario.setTelefones(telefones);
		
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        em.close();
	}
}

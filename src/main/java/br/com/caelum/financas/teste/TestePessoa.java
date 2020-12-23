package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Endereco;
import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TestePessoa {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();

        //Pessoa saved = create();

        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, 13L);

        pessoa.getEnderecos().clear();

        Endereco e1 = new Endereco();
        e1.setDescricao("XXX XXX XXX, XX");

        pessoa.adicionar(e1);

        Endereco e2 = new Endereco();
        e2.setDescricao("Rua Boa Esperanca, 187");

        pessoa.adicionar(e2);

        em.merge(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public static Pessoa create() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(37);
        pessoa.setNome("Diego Duarte");

        Endereco e1 = new Endereco();
        e1.setDescricao("Rua Amadeu Simei, 7");

        Endereco e2 = new Endereco();
        e2.setDescricao("Rua Boa Esperanca, 187");

        pessoa.adicionar(e1);
        pessoa.adicionar(e2);

        return pessoa;
    }
}

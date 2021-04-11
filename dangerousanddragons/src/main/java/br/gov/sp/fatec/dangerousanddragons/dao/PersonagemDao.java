package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Personagem;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import java.util.List;

public interface PersonagemDao {

    Personagem cadastrarPersonagem(String nome, String raca, String classe, Usuario proprietario);

    Personagem buscarPersonagem(Long idPersonagem);

    List<Personagem> buscarPersonagemPorNome(String nome);

    Personagem salvarPersonagem(Personagem personagem);

    Personagem commitPersonagem(Personagem personagem);

    void removerPersonagem(Long idPersonagem);

    List<Personagem> todosPersonagem();

}

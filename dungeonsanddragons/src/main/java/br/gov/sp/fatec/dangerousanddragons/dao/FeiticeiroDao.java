package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Feiticeiro;
import br.gov.sp.fatec.dangerousanddragons.model.Personagem;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import java.util.List;

public interface FeiticeiroDao {
    public Feiticeiro cadastrarFeiticeiro(String nome, String raca, String classe, Usuario proprietario);

    public Feiticeiro buscarFeiticeiro(Long idFeiticeiro);

    List<Feiticeiro> buscarFeiticeiroPorNome(String nome);

    public Feiticeiro salvarFeiticeiro(Feiticeiro feiticeiro);

    public Feiticeiro commitFeiticeiro(Feiticeiro feiticeiro);

    public void removerFeiticeiro(Long idFeiticeiro);
}

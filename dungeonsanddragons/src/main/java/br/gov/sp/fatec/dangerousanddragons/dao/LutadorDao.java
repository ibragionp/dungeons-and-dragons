package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Lutador;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import java.util.List;

public interface LutadorDao {
    public Lutador cadastrarLutador(String nome, String raca, String classe, Usuario proprietario);

    public Lutador buscarLutador(Long idLutador);

    public List<Lutador> buscarLutadorPorNome(String nome);

    public Lutador salvarLutador(Lutador lutador);

    public Lutador commitLutador(Lutador lutador);

    public void removerLutador(Long idLutador);
}

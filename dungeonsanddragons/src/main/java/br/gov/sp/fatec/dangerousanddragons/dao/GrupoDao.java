package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Grupo;

public interface GrupoDao {
    public Grupo commitGrupo(Grupo grupo);

    public Grupo buscarGrupo(Long mestreId, String nomeGrupo);

    public void removerGrupo(Long mestreId, String nomeGrupo);
}

package com.udemy.compras.domain;

import com.udemy.compras.graphql.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
    @Query("select c from Compra c where c.cliente = :cliente")
    List<Compra> findAllByCliente(@Param("cliente") Cliente c);

    List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade);

    @Query("select new com.udemy.compras.graphql.dto.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p")
    List<CompraResumo> findAllComprasResumo();
}

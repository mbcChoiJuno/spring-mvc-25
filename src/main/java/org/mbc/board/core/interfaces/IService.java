package org.mbc.board.core.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<K, V> {

    public V findById(K id);

    public List<V> findAll();

    public boolean post(V dto);

    public boolean update(V dto);

    public boolean delete(K id);
}

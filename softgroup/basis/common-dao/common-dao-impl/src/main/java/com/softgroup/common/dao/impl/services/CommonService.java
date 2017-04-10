package com.softgroup.common.dao.impl.services;

import com.softgroup.common.dao.impl.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author AlexKazmirchuk
 * @since 13.03.17.
 */

public abstract class CommonService
        <E extends Serializable, R extends BaseRepository<E>> {

    @Autowired
    private R repository;

    public E add(E entity){
        return repository.save(entity);
    }

    public E getById(String id){
        return repository.findOne(id);
    }

    public void delete(String id){
        repository.delete(id);
    }

    public E edit(E entity){
        return repository.save(entity);
    }

    public List<E> getAll(){
        return repository.findAll();
    }

    public R getRepository() {
        return repository;
    }

    public List<E> getAllByIds(List<String> ids){
        return repository.findAll(ids);
    }
}

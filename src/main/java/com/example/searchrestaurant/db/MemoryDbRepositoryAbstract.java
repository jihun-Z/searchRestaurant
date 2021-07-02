package com.example.searchrestaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db=new ArrayList<>();

    private int index=0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it ->it.getIndex() == index).findFirst();//첫번째 아이템을 찾아 반환
    }

    @Override
    public T save(T entity) {
        var optionalEntity=db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if (optionalEntity.isEmpty()){
            //db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{
            //db에 이미 데이터가 있는 경우우
            var preIndex= optionalEntity.get().getIndex();
            entity.setIndex(preIndex);
            deleteById(preIndex);
            db.add(entity);
            return entity;
       }

    }

    @Override
    public void deleteById(int index) {
        var optionalEntity=db.stream().filter(it -> it.getIndex()== index).findFirst();
        if(optionalEntity.isPresent()){ // 현재값과 동일하면 지워라
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}

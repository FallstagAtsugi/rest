package com.example.rest.repository;

import com.example.rest.repository.entity.MemberData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberMapper mapper;

    public List<MemberData> findAll(){
        return mapper.findAll();
    }

    public MemberData findById(int id){
        return mapper.findById(id);
    }

    public void create(String name, int age){
        mapper.create(name, age);
    }

    public void update(int id, String name, int age){
        mapper.update(id,name, age);
    }

    public void deleteById(int id){
        mapper.deleteById(id);
    }

}

package com.example.rest.service;

import com.example.rest.repository.MemberRepository;
import com.example.rest.repository.entity.MemberData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public List<MemberData> findAll(){
        return memberRepository.findAll();
    }

    public MemberData findById(int id){
        return memberRepository.findById(id);
    }

    public void create(List<MemberData> memberData){
        for(MemberData data: memberData){
            memberRepository.create(data.getName(), data.getAge());
        }
        System.out.println("登録完了");
    }

    public void update(int id, MemberData memberData){
        memberRepository.update(id, memberData.getName(), memberData.getAge());
        System.out.println("更新完了");
    }

    public void deleteById(int id){
        memberRepository.deleteById(id);
        System.out.println("削除完了");
    }

}

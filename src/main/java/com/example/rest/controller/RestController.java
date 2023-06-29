package com.example.rest.controller;

import com.example.rest.repository.entity.MemberData;
import com.example.rest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful な URL
 * https://qiita.com/mserizawa/items/b833e407d89abd21ee72#restful-%E3%81%AA-url-%E3%81%AB%E3%81%97%E3%82%88%E3%81%86
 * 総コミット数：23  作成ブランチ：7
 * 合計行数（+追加行数 -削除行数）：799 (+727, -72)
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class RestController {

    private final MemberService memberService;

    @GetMapping
    public List<MemberData> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberData findById(@PathVariable int id){
        return  memberService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public void create(@RequestBody List<MemberData> memberData){
        memberService.create(memberData);
    }

    @PutMapping("/{id}")
    @ResponseBody
    //Bug: id が存在しないと updateできない → id重複なしなら新規登録したい
    public void update(@PathVariable int id, @RequestBody MemberData memberData){
        memberService.update(id, memberData);
    }

    @DeleteMapping("/{id}")
    //Bug：id で delete すると id が欠番になる
    public void deleteById(@PathVariable int id){
        memberService.deleteById(id);
    }
    //実装手順: branch作成, PullRequest作成, 空コミット, 実装orリファクタ, マージ
    //実装感想： 1.O/Rマッパー(Mybatis, Prizma, etc…)は　DB操作には必須
    //         3.【課題】フロント → エンドの疎通の理解が必要(Json形式のリクエスト作成方法, URL組立てBackEndに送信する方法)
    //         4.【苦労予想】テスト設計,　異常系制御, 言語ごとのテストフレームワーク, エビデンス取得作業
}

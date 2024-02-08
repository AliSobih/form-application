package com.example.maping.rest;


import com.example.maping.entity.Skill;
import com.example.maping.repository.SkillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/skill")
public class SkillsRest {

  private final SkillRepo skillRepo;

  @PostMapping
  private boolean save(@RequestBody Skill skill) {
    skillRepo.save(skill);
    return true;
  }

}

package com.deneme.denemeservice.controller;

import com.deneme.denemeservice.model.PersonnelDto;
import com.deneme.denemeservice.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * localhost:8080/personnel
 * GET PUT DELETE POST
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("personnel")
public class PersonnelController {

  private final PersonnelService personnelService;

  @GetMapping("/{tcIdentity}")
  public ResponseEntity<PersonnelDto> get(@PathVariable("tcIdentity") Long tcIdentity) {
    return ResponseEntity.ok(personnelService.get(tcIdentity));
  }

  @PostMapping
  public ResponseEntity<PersonnelDto> save(@RequestBody PersonnelDto personnelDto) {
    return ResponseEntity.ok(personnelService.save(personnelDto));
  }

  @PutMapping("/{tcIdentity}")
  public ResponseEntity<PersonnelDto> update(@PathVariable("tcIdentity") Long tcIdentity, @RequestBody PersonnelDto personnelDto) {
    return ResponseEntity.ok(personnelService.update(tcIdentity, personnelDto));
  }

  @DeleteMapping
  public void delete(Long tcIdentity) {
    personnelService.delete(tcIdentity);
  }

}

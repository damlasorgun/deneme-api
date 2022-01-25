package com.deneme.denemeservice.service;

import com.deneme.denemeservice.entity.PersonnelEntity;
import com.deneme.denemeservice.model.PersonnelDto;
import com.deneme.denemeservice.repository.PersonnelRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class PersonnelServiceImpl implements PersonnelService{

  private final PersonnelRepository personnelRepository;
  private final ModelMapper modelMapper;

  @Override
  public PersonnelDto get(Long tcIdentity) {
    PersonnelEntity personnelEntity = personnelRepository.findByTcIdentity(tcIdentity)
        .orElseThrow(() -> new IllegalArgumentException());
    return modelMapper.map(personnelEntity, PersonnelDto.class);
  }

  @Override
  public PersonnelDto save(PersonnelDto personnelDto) {
    PersonnelEntity personnelEntity = modelMapper.map(personnelDto, PersonnelEntity.class);
    personnelEntity = personnelRepository.save(personnelEntity);
    personnelDto.setTcIdentity(personnelEntity.getTcIdentity());
    return personnelDto;
  }


  @Transactional
  @Override
  public PersonnelDto update(Long tcIdentity, PersonnelDto personnelDto) {
    Assert.isNull(tcIdentity, "TC cannot be null");
    Optional<PersonnelEntity> personnelEntity1 = personnelRepository.findByTcIdentity(tcIdentity);
    PersonnelEntity personnelEntity = personnelEntity1.map(it -> {
      it.setBirthDate(personnelDto.getBirthDate());
      it.setName(personnelDto.getName());
      it.setSurname(personnelDto.getSurname());
      return it;
    }).orElseThrow(IllegalArgumentException::new);
    return modelMapper.map(personnelRepository.save(personnelEntity), PersonnelDto.class);
  }

  @Transactional
  @Override
  public void delete(Long id) {
    PersonnelEntity account = personnelRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException());
    personnelRepository.delete(account);
  }

}

package com.deneme.denemeservice.service;

import com.deneme.denemeservice.model.PersonnelDto;

public interface PersonnelService {

  PersonnelDto get(Long tcIdentity);

  PersonnelDto save(PersonnelDto personnelDto);

  PersonnelDto update(Long tcIdentity, PersonnelDto personnelDto);

  void delete(Long tcIdentity);

}

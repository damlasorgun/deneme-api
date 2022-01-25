package com.deneme.denemeservice.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonnelDto {

  private Long tcIdentity;

  private String name;

  private String surname;

  private String email;

  private Date birthDate;

  public String getNameSurname() {
    return this.name + " " + this.surname;
  }

}

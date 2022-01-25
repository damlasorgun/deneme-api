package com.deneme.denemeservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"tcIdentity"})
@ToString
@Getter
@Setter
@Entity
@Table(name = "personnel", schema = "authorization")
public class PersonnelEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tcIdentity;

  private String name;

  private String surname;

  private String email;

  private Date birthDate;


}

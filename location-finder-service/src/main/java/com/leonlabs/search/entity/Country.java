package com.leonlabs.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "country")
@Data
@EqualsAndHashCode(callSuper=false)
public class Country extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	private Integer id;

	@Column(name="name", nullable = false)
	private String name;

	@Column(name="isd_code", nullable = false)
	private Integer isdCode;


}

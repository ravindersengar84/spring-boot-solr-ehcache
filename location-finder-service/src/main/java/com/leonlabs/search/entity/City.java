package com.leonlabs.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "city")
@Data
@EqualsAndHashCode(callSuper=false)
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
public class City extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	private Integer id;

	@Column(name="name", nullable = false)
	private String name;

	@Column(name="state_id", nullable = false)
	private Integer stateId;

}

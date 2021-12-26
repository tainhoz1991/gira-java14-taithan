package Cybersoft.javabackend.girajava14taithan.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import Cybersoft.javabackend.girajava14taithan.commo.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gira_group_role") // ten cua table
public class GroupRole extends BaseEntity{

	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "code", unique = true)
	private String code;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "gira_role_group_role",
		joinColumns = @JoinColumn(name = "group_role_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
			) // cau hinh table gira_role_group_role trong moi quan he many-many
	private Set<Role> roles = new LinkedHashSet<Role>();
	
}

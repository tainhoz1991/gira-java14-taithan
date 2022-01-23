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
import Cybersoft.javabackend.girajava14taithan.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
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
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "gira_group_role_user",
		joinColumns = @JoinColumn(name = "group_role_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private Set<User> users = new LinkedHashSet<>();
	
	// helper method
	public void addUser(User user) {
		// khi tao moi user thi cai group user cua group role -> users
		// se phai add user do vao
		users.add(user);
		// sau do ban than thang user moi duoc tao se co thuoc tinh
		// groupRole va 01 list, nen ta lay cai list do -> getGroups
		// va add chinh cai group ma nay add user (this -> GroupRole hien tai)
		user.getGroups().add(this);
	}
	
	public void removeUser(User user) {
		users.remove(user);
		user.getGroups().remove(this);
	}
	
	public void clearUser() {
		users.forEach(t -> t.getGroups().remove(this));
		users.clear();
	}
}

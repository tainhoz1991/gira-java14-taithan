package Cybersoft.javabackend.girajava14taithan.commo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
// Tat ca cac thuoc tinh chung cho entity duoc khai bao trong day
@MappedSuperclass // o duoi DB cung nhan cac thuoc tinh nay khi co class extends no
public class BaseEntity implements Serializable{
	@Id
	@GeneratedValue
	protected Long id;
	
	@Version
	protected int version;
	
	@CreatedBy
	@Column(name = "created_by")
	protected String createdBy;
	
	@CreatedDate
	@Column(name = "created_at")
	protected LocalDateTime createAt;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;
}

package com.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于保存Users表中的一行用户信息
 * 
 * @author 费琪琪
 *
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 2504015899170623862L;

	/**
	 * 用户编号
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;
	/**
	 * 用户身份证
	 */
	@Column(name = "user_number")
	private String userNumber;
	/**
	 * 用户密码
	 */
	@Column(name = "user_password")
	private String userPassword;
	/**
	 * 用户性别
	 */
	@Column(name = "user_sex")
	private Integer userSex;
	/**
	 * 联系电话
	 */
	@Column(name = "user_phone")
	private String userPhone;
	/**
	 * 收货地址
	 */
	@Column(name = "user_site")
	private String userSite;
	/**
	 * 用户生日
	 */
	@Column(name = "user_birthday")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date userBirthday;
	/**
	 * 用户邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;
	/**
	 * 用户头像
	 */
	@Column(name = "user_photo")
	private String userPhoto;
	/**
	 * 权限编号
	 */
	@Column(name = "jdiction_id")
	private Integer jdictionId;

	/**
	 * 用户状态
	 */
	@Column(name = "user_status")
	private Integer userStatus;

}

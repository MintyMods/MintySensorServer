package info.mintymods.repository.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.type.CalendarType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class Profile {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true)
	private String nickname;

	private LocalDate birthday;
	private CalendarType birthdayType;
	private String mobileNumber;
	private String homeNumber;
	private String job;
	private String postCode;
	private String address1;
	private String address2;

	@CreatedDate
	@Column
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column
	private LocalDateTime updatedDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", nullable = false, foreignKey = @ForeignKey(name = "FK_profile_account"))
	private Account account;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "profile")
	private ProfileImage profileImage;

	public Profile() {
	}

	public long getId() {
		return this.id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public LocalDate getBirthday() {
		return this.birthday;
	}

	public CalendarType getBirthdayType() {
		return this.birthdayType;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public String getHomeNumber() {
		return this.homeNumber;
	}

	public String getJob() {
		return this.job;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public String getAddress1() {
		return this.address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return this.updatedDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public ProfileImage getProfileImage() {
		return this.profileImage;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setNickname(final String nickname) {
		this.nickname = nickname;
	}

	public void setBirthday(final LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setBirthdayType(final CalendarType birthdayType) {
		this.birthdayType = birthdayType;
	}

	public void setMobileNumber(final String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setHomeNumber(final String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public void setJob(final String job) {
		this.job = job;
	}

	public void setPostCode(final String postCode) {
		this.postCode = postCode;
	}

	public void setAddress1(final String address1) {
		this.address1 = address1;
	}

	public void setAddress2(final String address2) {
		this.address2 = address2;
	}

	public void setCreatedDate(final LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(final LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setAccount(final Account account) {
		this.account = account;
	}

	public void setProfileImage(final ProfileImage profileImage) {
		this.profileImage = profileImage;
	}

}

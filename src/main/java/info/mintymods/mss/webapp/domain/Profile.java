package info.mintymods.mss.webapp.domain;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import info.mintymods.mss.webapp.enums.CalendarType;
import info.mintymods.mss.webapp.enums.MaritalStatus;
import info.mintymods.mss.webapp.enums.Sex;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class Profile {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true)
	private String nickname;

	private Sex sex;
	private LocalDate birthday;
	private CalendarType birthdayType;
	private MaritalStatus maritalStatus;
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

	public long getId() { return this.id; }

	public String getNickname() { return this.nickname; }

	public Sex getSex() { return this.sex; }

	public LocalDate getBirthday() { return this.birthday; }

	public CalendarType getBirthdayType() { return this.birthdayType; }

	public MaritalStatus getMaritalStatus() { return this.maritalStatus; }

	public String getMobileNumber() { return this.mobileNumber; }

	public String getHomeNumber() { return this.homeNumber; }

	public String getJob() { return this.job; }

	public String getPostCode() { return this.postCode; }

	public String getAddress1() { return this.address1; }

	public String getAddress2() { return this.address2; }

	public LocalDateTime getCreatedDate() { return this.createdDate; }

	public LocalDateTime getUpdatedDate() { return this.updatedDate; }

	public Account getAccount() { return this.account; }

	public ProfileImage getProfileImage() { return this.profileImage; }

	public void setId(final long id) { this.id = id; }

	public void setNickname(final String nickname) { this.nickname = nickname; }

	public void setSex(final Sex sex) { this.sex = sex; }

	public void setBirthday(final LocalDate birthday) { this.birthday = birthday; }

	public void setBirthdayType(final CalendarType birthdayType) { this.birthdayType = birthdayType; }

	public void setMaritalStatus(final MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }

	public void setMobileNumber(final String mobileNumber) { this.mobileNumber = mobileNumber; }

	public void setHomeNumber(final String homeNumber) { this.homeNumber = homeNumber; }

	public void setJob(final String job) { this.job = job; }

	public void setPostCode(final String postCode) { this.postCode = postCode; }

	public void setAddress1(final String address1) { this.address1 = address1; }

	public void setAddress2(final String address2) { this.address2 = address2; }

	public void setCreatedDate(final LocalDateTime createdDate) { this.createdDate = createdDate; }

	public void setUpdatedDate(final LocalDateTime updatedDate) { this.updatedDate = updatedDate; }

	public void setAccount(final Account account) { this.account = account; }

	public void setProfileImage(final ProfileImage profileImage) { this.profileImage = profileImage; }

	@java.lang.Override
	public java.lang.String toString() {
		return "Profile(id=" + this.getId() + ", nickname=" + this.getNickname() + ", sex=" + this.getSex()
				+ ", birthday=" + this.getBirthday() + ", birthdayType=" + this.getBirthdayType() + ", maritalStatus="
				+ this.getMaritalStatus() + ", mobileNumber=" + this.getMobileNumber() + ", homeNumber="
				+ this.getHomeNumber() + ", job=" + this.getJob() + ", postCode=" + this.getPostCode() + ", address1="
				+ this.getAddress1() + ", address2=" + this.getAddress2() + ", createdDate=" + this.getCreatedDate()
				+ ", updatedDate=" + this.getUpdatedDate() + ", account=" + this.getAccount() + ", profileImage="
				+ this.getProfileImage() + ")";
	}
}

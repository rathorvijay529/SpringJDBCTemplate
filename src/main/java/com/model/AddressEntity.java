package com.model;

public class AddressEntity {
	private Integer employeeId;
	private Integer addressId;
	private String fullAddress;
	private String city;
	private Integer pincode;

	public AddressEntity() {
		super();
	}

	public AddressEntity(Integer employeeId, Integer addressId, String fullAddress, String city, Integer pincode) {
		super();
		this.employeeId = employeeId;
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.city = city;
		this.pincode = pincode;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [employeeId=" + employeeId + ", addressId=" + addressId + ", fullAddress=" + fullAddress + ", city="
				+ city + ", pincode=" + pincode + "]";
	}

	
}

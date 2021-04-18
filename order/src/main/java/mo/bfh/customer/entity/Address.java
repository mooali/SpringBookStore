package mo.bfh.customer.entity;


import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {


    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String stateProvince;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;

    public Address() {
    }

    public Address(String street, String city, String stateProvince, String postalCode, String country) {
        this.street = street;
        this.stateProvince = stateProvince;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


    public String getStreet() {
        return street;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

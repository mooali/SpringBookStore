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
    @Min(5)
    private Integer postalCode;
    @NotBlank
    private String country;

    public Address(@NotBlank String street, @NotBlank String city, @Min(5) Integer postalCode, @NotBlank String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

package mo.bfh.customer.entity;


import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Embeddable
public class CreditCard {

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    @NotBlank
    private String number;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer expirationMonth;

    @NotNull
    @Min(2021) //better use Calendar.getInstance().get(Calendar.YEAR); (actuall year)
    private Integer expirationYear;

    public CreditCard(CreditCardType creditCardType,String number,Integer expirationMonth, Integer expirationYear) {
        this.creditCardType = creditCardType;
        this.number = number;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public CreditCard() {
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}

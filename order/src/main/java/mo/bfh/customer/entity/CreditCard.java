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

    @NotNull
    @Enumerated(EnumType.STRING)
    private CreditCardType type;

    @NotBlank
    private String number;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer expirationMonth;

    @NotNull
    @Min(2020) //better use Calendar.getInstance().get(Calendar.YEAR); (actuall year)
    private Integer expirationYear;

    public CreditCard(CreditCardType type,String number,Integer expirationMonth, Integer expirationYear) {
        this.type = type;
        this.number = number;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public CreditCard() {
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
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

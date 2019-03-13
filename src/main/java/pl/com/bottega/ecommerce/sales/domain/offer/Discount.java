package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String discountCause;

    private BigDecimal value;

    public Discount(String discountCause, BigDecimal value) {
        this.discountCause = discountCause;
        this.value = value;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setDiscount(BigDecimal value) {
        this.value = value;
    }
}

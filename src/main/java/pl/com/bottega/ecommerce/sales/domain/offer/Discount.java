package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String discountCause;

    private Money value;

    public Discount(String discountCause, Money value) {
        this.discountCause = discountCause;
        this.value = value;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

}

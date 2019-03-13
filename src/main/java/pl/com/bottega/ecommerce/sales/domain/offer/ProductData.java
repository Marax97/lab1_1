package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class ProductData {

    private String id;

    private String name;

    private Money price;

    private String productType;

    private Date productSnapshotDate;

    public ProductData(String id, String name, Money price, String productType, Date productSnapshotDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
        result = prime * result + (productSnapshotDate == null ? 0 : productSnapshotDate.hashCode());
        result = prime * result + (productType == null ? 0 : productType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProductData other = (ProductData) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        if (productSnapshotDate == null) {
            if (other.productSnapshotDate != null) {
                return false;
            }
        } else if (!productSnapshotDate.equals(other.productSnapshotDate)) {
            return false;
        }
        if (productType == null) {
            if (other.productType != null) {
                return false;
            }
        } else if (!productType.equals(other.productType)) {
            return false;
        }
        return true;
    }

}

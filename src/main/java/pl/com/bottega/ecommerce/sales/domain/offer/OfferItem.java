/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class OfferItem {

    private int quantity;

    private ProductData productData;

    private Money totalCost;

    private Discount discount;

    public OfferItem(int quantity, ProductData productData, Money totalCost, Discount discount) {
        this.quantity = quantity;
        this.productData = productData;
        this.totalCost = totalCost;
        this.discount = discount;

        totalCost.setValue(productData.getPrice()
                                      .getValue()
                                      .multiply(new BigDecimal(quantity)));
        if (discount != null) {
            totalCost.setValue(totalCost.getValue()
                                        .subtract(discount.getValue()
                                                          .getValue()));
        }
    }

    public OfferItem(int quantity, ProductData productData, Money totalCost) {
        this(quantity, productData, totalCost, null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, productData, discount, totalCost);
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
        OfferItem other = (OfferItem) obj;
        return Objects.equals(currency, other.currency)
               && Objects.equals(discount, other.discount)
               && Objects.equals(discountCause, other.discountCause)
               && Objects.equals(productId, other.productId)
               && Objects.equals(productName, other.productName)
               && Objects.equals(productPrice, other.productPrice)
               && Objects.equals(productSnapshotDate, other.productSnapshotDate)
               && Objects.equals(productType, other.productType)
               && quantity == other.quantity
               && Objects.equals(totalCost, other.totalCost);
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }

        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (productType != other.productType) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}

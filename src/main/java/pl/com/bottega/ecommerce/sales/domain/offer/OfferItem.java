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

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (productData.getPrice() == null) {
            if (other.productData.getPrice() != null) {
                return false;
            }
        } else if (!productData.getPrice()
                               .equals(other.productData.getPrice())) {
            return false;
        }
        if (productData.getName() == null) {
            if (other.productData.getName() != null) {
                return false;
            }
        } else if (!productData.getName()
                               .equals(other.productData.getName())) {
            return false;
        }

        if (productData.getId() == null) {
            if (other.productData.getId() != null) {
                return false;
            }
        } else if (!productData.getId()
                               .equals(other.productData.getId())) {
            return false;
        }
        if (productData.getType() != other.productData.getType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue()
                     .compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (productData == null ? 0 : productData.hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
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
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (productData == null) {
            if (other.productData != null) {
                return false;
            }
        } else if (!productData.equals(other.productData)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals(other.totalCost)) {
            return false;
        }
        return true;
    }

}

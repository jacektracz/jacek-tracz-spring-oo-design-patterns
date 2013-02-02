/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.catalog.api;

import java.math.BigDecimal;


/**
 * The interface {@code InternationalPrice} allows to associate a set of prices in different currencies to
 * a given object.
 */
public interface InternationalPrice {

    /**
     *
     * @return an array of {@code Price} in the various currencies
     */
    public abstract Price[] getPrices();

    /**
     *
     * @param currency  the currency
     * @return          the price associated with that currency
     *
     * @throws CatalogApiException if there is no entry
     */
    public abstract BigDecimal getPrice(Currency currency) throws CatalogApiException;

    /**
     *
     * @return whether this is a zero price
     */
    public abstract boolean isZero();

}

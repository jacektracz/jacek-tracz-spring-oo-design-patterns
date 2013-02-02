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

package com.ning.billing.payment.provider;

import java.util.List;
import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ning.billing.payment.PaymentTestSuiteNoDB;
import com.ning.billing.payment.api.PaymentMethodPlugin.PaymentMethodKVInfo;

import com.google.common.collect.ImmutableList;

public class TestDefaultNoOpPaymentMethodPlugin extends PaymentTestSuiteNoDB {

    @Test(groups = "fast")
    public void testEquals() throws Exception {
        final String externalId = UUID.randomUUID().toString();
        final boolean isDefault = false;
        final List<PaymentMethodKVInfo> props = ImmutableList.<PaymentMethodKVInfo>of(new PaymentMethodKVInfo(UUID.randomUUID().toString(), UUID.randomUUID().toString(), false));

        final DefaultNoOpPaymentMethodPlugin paymentMethod = new DefaultNoOpPaymentMethodPlugin(externalId, isDefault, props);
        Assert.assertEquals(paymentMethod, paymentMethod);

        final DefaultNoOpPaymentMethodPlugin samePaymentMethod = new DefaultNoOpPaymentMethodPlugin(externalId, isDefault, props);
        Assert.assertEquals(samePaymentMethod, paymentMethod);

        final DefaultNoOpPaymentMethodPlugin otherPaymentMethod = new DefaultNoOpPaymentMethodPlugin(externalId, isDefault, ImmutableList.<PaymentMethodKVInfo>of());
        Assert.assertNotEquals(otherPaymentMethod, paymentMethod);
    }

    @Test(groups = "fast")
    public void testEqualsForPaymentMethodKVInfo() throws Exception {
        final String key = UUID.randomUUID().toString();
        final Object value = UUID.randomUUID();
        final boolean updatable = false;

        final PaymentMethodKVInfo kvInfo = new PaymentMethodKVInfo(key, value, updatable);
        Assert.assertEquals(kvInfo, kvInfo);

        final PaymentMethodKVInfo sameKvInfo = new PaymentMethodKVInfo(key, value, updatable);
        Assert.assertEquals(sameKvInfo, kvInfo);

        final PaymentMethodKVInfo otherKvInfo = new PaymentMethodKVInfo(key, value, !updatable);
        Assert.assertNotEquals(otherKvInfo, kvInfo);
    }
}

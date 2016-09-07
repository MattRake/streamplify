/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beryx.streamplify;

import java.math.BigInteger;
import java.util.stream.Stream;

public abstract class StreamableProxy<T,S extends StreamableProxy<T,S>> implements Streamable<T, S> {
    protected abstract Streamable<T, ?> getDelegate();

    public S withAdditionalCharacteristics(int additionalCharacteristics) {
        getDelegate().withAdditionalCharacteristics(additionalCharacteristics);
        return (S)this;
    }
    
    @Override
    public Stream<T> stream() {
        return getDelegate().stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return getDelegate().parallelStream();
    }

    @Override
    public long count() {
        return getDelegate().count();
    }

    @Override
    public BigInteger bigCount() {
        return getDelegate().bigCount();
    }

    @Override
    public S skip(long n) {
        return (S)getDelegate().skip(n);
    }

    @Override
    public S skip(BigInteger n) {
        return (S)getDelegate().skip(n);
    }
}
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cdancy.bitbucket.rest.domain.commit;

import java.util.List;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.cdancy.bitbucket.rest.domain.common.Error;
import com.cdancy.bitbucket.rest.domain.common.ErrorsHolder;
import com.cdancy.bitbucket.rest.domain.common.Page;
import com.cdancy.bitbucket.rest.BitbucketUtils;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CommitPage implements Page<Commit>, ErrorsHolder {

    @Nullable
    public abstract Integer authorCount();
    
    @Nullable
    public abstract Integer totalCount();

    @SerializedNames({ "start", "limit", "size", "nextPageStart", 
            "isLastPage", "values", "errors", "authorCount", "totalCount" })
    public static CommitPage create(final int start, 
            final int limit, 
            final int size, 
            final int nextPageStart, 
            final boolean isLastPage,
            @Nullable final List<Commit> values, 
            @Nullable final List<Error> errors, 
            final Integer authorCount, 
            final Integer totalCount) {
        return new AutoValue_CommitPage(start, 
                limit, 
                size, 
                nextPageStart, 
                isLastPage,
                BitbucketUtils.nullToEmpty(values), 
                BitbucketUtils.nullToEmpty(errors), 
                authorCount, 
                totalCount);
    }
}
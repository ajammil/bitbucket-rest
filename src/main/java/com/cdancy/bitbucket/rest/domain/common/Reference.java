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

package com.cdancy.bitbucket.rest.domain.common;

import com.cdancy.bitbucket.rest.domain.pullrequest.MinimalRepository;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Reference {

    // default to 'refs/heads/master' if null
    @Nullable
    public abstract String id();

    @Nullable
    public abstract MinimalRepository repository();

    @Nullable
    public abstract String state();

    @Nullable
    public abstract Boolean tag();

    @Nullable
    public abstract String displayId();

    @Nullable
    public abstract String latestCommit();

    Reference() {
    }

    @Deprecated
    public static Reference create(final String id, final MinimalRepository repository) {
        String displayId = null;
        if (id != null) {
            final String[] parts = id.split("/");
            displayId = parts[parts.length - 1];
        }
        return create(id, repository, displayId);
    }

    @Deprecated
    public static Reference create(final String id,
            final MinimalRepository repository, 
            final String displayId) {
        
        return create(id, repository, null, null, displayId, null);
    }

    @SerializedNames({ "id", "repository", "state", "tag", "displayId", "latestCommit" })
    public static Reference create(final String id,
                                   final MinimalRepository repository,
                                   final String state,
                                   final Boolean tag,
                                   final String displayId,
                                   final String latestCommit) {
        
        return new AutoValue_Reference(id != null ? id : "refs/heads/master",
            repository,
            state,
            tag,
            displayId,
            latestCommit);
    }
}

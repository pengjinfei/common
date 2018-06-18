/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.pengjinfei.common.job.console.service.impl;

import com.dangdang.ddframe.job.lite.lifecycle.api.*;
import com.google.common.base.Optional;
import com.pengjinfei.common.job.ElasticjobProperties;
import com.pengjinfei.common.job.console.service.JobAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作业API服务实现类.
 * 
 * @author zhangliang 
 */
@Service
public final class JobAPIServiceImpl implements JobAPIService {

    private final ElasticjobProperties regCenterConfig;

    @Autowired
    public JobAPIServiceImpl(ElasticjobProperties regCenterConfig) {
        this.regCenterConfig = regCenterConfig;
    }

    @Override
    public JobSettingsAPI getJobSettingsAPI() {
        return JobAPIFactory.createJobSettingsAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
    @Override
    public JobOperateAPI getJobOperatorAPI() {

        return JobAPIFactory.createJobOperateAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
    @Override
    public ShardingOperateAPI getShardingOperateAPI() {

        return JobAPIFactory.createShardingOperateAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
    @Override
    public JobStatisticsAPI getJobStatisticsAPI() {

        return JobAPIFactory.createJobStatisticsAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
    @Override
    public ServerStatisticsAPI getServerStatisticsAPI() {

        return JobAPIFactory.createServerStatisticsAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
    @Override
    public ShardingStatisticsAPI getShardingStatisticsAPI() {

        return JobAPIFactory.createShardingStatisticsAPI(regCenterConfig.getZkAddressList(), regCenterConfig.getNamespace(), Optional.fromNullable(regCenterConfig.getDigest()));
    }
    
}

/*
 * Copyright 2013-2014 Grzegorz Ligas <ligasgr@gmail.com> and other contributors
 * (see the CONTRIBUTORS file).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.xquery.runner.rt.xqj;

import org.intellij.xquery.runner.rt.RunnerAppTest;
import org.intellij.xquery.runner.rt.XQueryDataSourceType;
import org.junit.Ignore;

import java.io.File;

import static org.intellij.xquery.runner.rt.XQueryRunConfigBuilder.runConfig;

/**
 * User: ligasgr
 * Date: 16/03/14
 * Time: 16:08
 */
@Ignore("works only when Exist instance is up")
public class ExistRunnerAppTest extends RunnerAppTest {

    @Override
    protected String getDataSourceType() {
        return XQueryDataSourceType.EXIST.toString();
    }

    protected String prepareConfigurationWithContextItemForMainFile(File xqueryMainFile, String contextItemValue,
                                                                    String contextItemType) {
        return runConfig()
                .withTypeName(getDataSourceType())
                .withMainFileName(xqueryMainFile.getAbsolutePath())
                .withContextItemType(contextItemType)
                .withContextItemValue(contextItemValue)
                .withConnectionData("localhost", "8080", "admin", "admin")
                .build();
    }

    protected String prepareConfigurationWithVariableForMainFile(File xqueryMainFile, String value, String type) {
        return runConfig()
                .withTypeName(getDataSourceType())
                .withMainFileName(xqueryMainFile.getAbsolutePath())
                .withVariable("v", value, type)
                .withConnectionData("localhost", "8080", "admin", "admin")
                .build();
    }
}

package act.test;

/*-
 * #%L
 * ACT Framework
 * %%
 * Copyright (C) 2014 - 2020 ActFramework
 * %%
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
 * #L%
 */

import act.util.ProgressGauge;

import javax.validation.ValidationException;

/**
 * A `TestEngine` runs {@link Scenario test scenario} and {@link TestSession test session}.
 */
public interface TestEngine {

    /**
     * Returns name of this test engine.
     *
     * Note test engine name must be unique across implmentations.
     *
     * @return test engine name
     */
    String getName();

    /**
     * Validate a {@link Scenario test scenario}.
     *
     * If there are any issue with the test scenario then a {@link ValidationException}
     * shall be raised.
     *
     * @param scenario a test scenario to be validated.
     * @param session the test session that contains the scenario.
     * @throws ValidationException in case any issue with the test session
     */
    void validate(Scenario scenario, TestSession session) throws ValidationException;

    /**
     * Run a {@link Scenario test scenario}.
     *
     * @param scenario the scenario to run by the test engine.
     * @param session the test session that contains the scenario.
     * @param gauge the progress gauge to track progress.
     * @return `true` if run pass, `false` otherwise.
     */
    boolean run(Scenario scenario, TestSession session, ProgressGauge gauge);


}

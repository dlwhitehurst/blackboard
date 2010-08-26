/**
 * Copyright 2010 David L. Whitehurst
 * 
 * Licensed under the Apache License, Version 2.0 
 * (the "License"); You may not use this file except 
 * in compliance with the License. You may obtain a 
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific 
 * language governing permissions and limitations under the 
 * License.
 * 
 */
package org.dlw.ai.blackboard.domain;

/**
 * <p>
 * The {@link Assertion} class is a special kind of {@link Assumption} that is
 * not retractable. Once the {@link Assertion} has been made, the
 * {@link org.dlw.ai.blackboard.Cryptographer} has accepted the
 * {@link Assumption} to be true and will no longer allow the
 * {@link org.dlw.ai.blackboard.knowledge.KnowledgeSource} to interject its
 * thoughts or facts surrounding the assertion's domain.
 * </p>
 * 
 * <blockquote><i>Assertion - "(def.) a confident or forceful statement of fact
 * or belief"</i></blockquote>
 * 
 * @author dlwhitehurst
 * @version 1.0.0-RC
 * 
 */
public class Assertion extends Assumption {

    /*
     * (non-Javadoc)
     * 
     * @see org.dlw.ai.cryptogram.domain.Assumption#isRetractable()
     */
    @Override
    public final boolean isRetractable() {
        return false;
    }

}

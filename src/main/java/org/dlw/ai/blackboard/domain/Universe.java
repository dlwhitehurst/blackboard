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
 * This class represents the top level domain object, however at this time a
 * particular use for this has not been specified. The class remains an
 * abstraction until such time as the "problem domain" has increased in depth
 * and complexity.
 * 
 * <blockquote><i>Universe - "(def.) a sphere of thought or
 * activity.</i></blockquote>
 * 
 * @author dlwhitehurst
 * 
 */
public abstract class Universe {

    /**
     * Domain object definition, <i>never</i> set as constant. This object
     * attribute is very important to our understanding, knowledge,
     * intelligence, etc. because it answers the question "what is it?". And,
     * how do our senses perceive this impression (image, sound, thought,
     * experience, smell, touch, etc.)? Therefore, this impression(s) is
     * different for each individual. Webster, Oxford, and or any other
     * dictionary provides a definition for us that provides a baseline
     * impression for our <i>knowledge</i>if we seek this impression and
     * <i>definition</i> for our own understanding.
     */
    protected String def;

    /**
     * @return the def
     */
    public abstract String getDef();

    /**
     * @param def
     *            the def to set
     */
    public abstract void setDef(String def);

}

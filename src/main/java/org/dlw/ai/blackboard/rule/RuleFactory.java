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
package org.dlw.ai.blackboard.rule;

import java.util.ArrayList;

import org.dlw.ai.blackboard.domain.Antecedent;
import org.dlw.ai.blackboard.domain.Consequent;
import org.dlw.ai.blackboard.exception.UnknownKnowledgeSourceException;
import org.dlw.ai.blackboard.knowledge.KnowledgeSourceType;

/**
 * <p>
 * This static factory class provides for the creation of the {@link Rule}
 * object. The objects are returned from a static method based on the input of a
 * {@link org.dlw.ai.blackboard.knowledge.KnowledgeSourceType}
 * </p>
 * 
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version 1.0.0-RC
 * 
 */
public final class RuleFactory {

    private RuleFactory() {
    }

    public static ArrayList<Rule> createRules(KnowledgeSourceType type) {
        ArrayList<Rule> rules = new ArrayList<Rule>();
        
        Rule rule = new Rule();

        switch (type) {

        case COMMON_PREFIX_KNOWLEDGE_SOURCE:
            break;

        case COMMON_SUFFIX_KNOWLEDGE_SOURCE:
            break;

        case CONSONANT_KNOWLEDGE_SOURCE:
            break;

        case DIRECT_SUBSTITUTION_KNOWLEDGE_SOURCE:
            rule = ruleDirectSubstitutionKS(rule);
            rules.add(rule);
            break;

        case DOUBLE_LETTER_KNOWLEDGE_SOURCE:
            break;
            
        case LEGAL_STRING_KNOWLEDGE_SOURCE:
            break;

        case LETTER_FREQUENCY_KNOWLEDGE_SOURCE:
            break;

        case PATTERN_MATCHING_KNOWLEDGE_SOURCE:
            break;

        case SENTENCE_STRUCTURE_KNOWLEDGE_SOURCE:
            break;

        case SMALL_WORD_KNOWLEDGE_SOURCE:
            break;

        case SOLVED_KNOWLEDGE_SOURCE:
            rule = ruleSolvedKS(rule);
            rules.add(rule);
            break;

        case VOWEL_KNOWLEDGE_SOURCE:
            break;

        case WORD_STRUCTURE_KNOWLEDGE_SOURCE:
            break;

        default:
            throw new UnknownKnowledgeSourceException("Unknown knowledge source detected");
        }
        
        return rules;
    }

    private static Rule ruleDirectSubstitutionKS(Rule rule) {
        rule = loadConversionRule(rule, "W","V");
        return rule;
    }
    
    private static Rule ruleSolvedKS(Rule rule) {

        Antecedent antecedent = new Antecedent();
        antecedent.setFullyQualifiedClass("org.dlw.ai.blackboard.Blackboard");
        antecedent.setMethodName("isSolved");
        Consequent consequent = new Consequent();
        consequent.setFullyQualifiedClass("org.dlw.ai.blackboard.Controller");
        consequent.setMethodName("done");
        
        rule = loadMethodRule(rule, antecedent, consequent);
        
        return rule;
    }
    
    private static Rule loadMethodRule(Rule rule, Antecedent antecedent, Consequent consequent) {
        
        rule.setAntecedent(antecedent);
        rule.setConsequent(consequent);
        rule.setRuleType(RuleType.METHOD);
         
        
        return rule;
        
    }
    
    private static Rule loadConversionRule(Rule rule, final String cipher, final String plainText) {
        rule.setBefore(cipher);
        rule.setAfter(plainText);
        rule.setRuleType(RuleType.CONVERSION);
        return rule;
    }
}

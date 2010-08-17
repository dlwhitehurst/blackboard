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
package org.dlw.ai.blackboard;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.ai.blackboard.util.SystemConstants;
import org.dlw.ai.blackboard.util.UniversalContext;

/**
 * The Blackboard project is an example of an Artificial Intelligence model that
 * was created by Grady Booch in his book Object Oriented Design and Analysis.
 * Class names and snippets were given in C++ syntactic notation and the design
 * is somewhat followed verbatim. The class designs and code snippets are,
 * however written in Java here and modified to suit the conversion. Some code
 * is entirely different and hopefully refactored for efficiency and economy.
 * 
 * A cryptic sentence e.g. Q AZWS DSSC KAS DXZNN DASNN is solved by this system
 * to be I HAVE SEEN THE SMALL SHELL.
 * 
 * @author dlwhitehurst
 * 
 */
public class Main {

	/**
	 * Attribute cipher string sentence
	 */
	final static String CODED_STRING = "Q AZWS DSSC KAS DXZNN DASNN";

	/**
	 * Attribute class logger
	 */
	private final static Log log = LogFactory.getLog(Main.class);

	/**
	 * Main method to solve ciphertext problem. Coded string is passed to
	 * solveProblem and {@link Cryptographer} is instantiated to optimistically decode
	 * the string until it is solved
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Solve our problem
		 */
		final String answer = solveProblem(CODED_STRING);

		/**
		 * Notify results
		 */
		if (log.isInfoEnabled()) {
			log.info("SYSTEM FINAL REPLY: " + answer);
		} else {
			System.err.println(SystemConstants.INFO_LEVEL_FATAL);
			System.exit(0); // die
		}
	}

	/**
	 * Private method to solve the problem
	 * 
	 * @param ciphertext
	 * @return
	 */
	private static String solveProblem(String ciphertext) {

		Cryptographer theCryptographer = (Cryptographer) UniversalContext
				.getApplicationContext().getBean("cryptographer");
		return theCryptographer.decipher(ciphertext);
	}

}

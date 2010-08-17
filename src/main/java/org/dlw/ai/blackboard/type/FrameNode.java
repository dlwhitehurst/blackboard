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
package org.dlw.ai.blackboard.type;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dlwhitehurst
 *
 */
public class FrameNode {
	
	protected String term;
	@SuppressWarnings("unchecked")
	protected HashMap map;
	protected ArrayList<FrameNode> children = new ArrayList<FrameNode>();
	
	@SuppressWarnings("unused")
	private FrameNode() {}
	
	public FrameNode(String term) {
		this.term = term;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FrameNode frameNode = FrameNode.createFrameNode("Patty-Likes");
		System.out.println("The framenode identifier is: " + frameNode.getTerm());
	}

	@SuppressWarnings("unchecked")
	public static FrameNode createFrameNode(String term) {

		Object retobj = null;
		
		try {
	           Class cls = Class.forName("org.dlw.ai.cryptogram.type.FrameNode");
	           Class partypes[] = new Class[1];
	            partypes[0] = String.class;
	            Constructor ct 
	              = cls.getConstructor(partypes);
	            Object arglist[] = new Object[1];
	            arglist[0] = new String(term);
	            
				retobj = ct.newInstance(arglist);
	            @SuppressWarnings("unused")
				int i = 1;
	         }
	         catch (Throwable e) {
	            System.err.println(e);
	         }
		return (FrameNode) retobj;
	}

	public boolean isTerminal() {
		return false;
	}
	
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @return the map
	 */
	@SuppressWarnings("unchecked")
	public HashMap getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	@SuppressWarnings("unchecked")
	public void setMap(HashMap map) {
		this.map = map;
	}

	/**
	 * @return the children
	 */
	public ArrayList<FrameNode> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<FrameNode> children) {
		this.children = children;
	}

}

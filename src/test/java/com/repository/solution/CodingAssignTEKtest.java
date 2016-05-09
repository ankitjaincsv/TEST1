/**
 * 
 */
package com.repository.solution;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * @author ankit-pc
 *
 */
public class CodingAssignTEKtest {

	@Test
	public void test1() {
		//check whether the file is present or not
		boolean flag = RepositorySolution.documentRepositorySolution("F:\\MyProject");
		assertTrue(flag);
	}
}

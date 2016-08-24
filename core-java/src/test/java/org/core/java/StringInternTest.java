package org.core.java;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;


public class StringInternTest {
	
	@Test
	public void checkStringLiteralRefISEqual(){
		String ref1 = "abc";
		String ref2 = "abc";
		Assert.assertEquals(true, ref1 == ref2);		
	}
	
	@Test
	public void checkStringRefWithoutIntern(){
		String ref1 = "abc";
		String ref2 = new String("abc");
		Assert.assertEquals(false, ref1 == ref2);
	}
	
	@Test
	public void checkStringRefWithIntern(){
		String ref1 = "abc";
		String ref2 = new String("abc");
		ref2 = ref2.intern();
		Assert.assertEquals(true, ref1.equals(ref2));
	}


}

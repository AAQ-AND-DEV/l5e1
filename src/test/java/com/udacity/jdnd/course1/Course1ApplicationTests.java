package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Course1ApplicationTests {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	void testReverseFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();
	    assertEquals(20, fbs.buzzFizz("Buzz", 4));
	    assertEquals(15, fbs.buzzFizz("FizzBuzz", 1));

	}

	@Test
	void testBuzzFizzExceptionFail(){
		FizzBuzzService fbs = new FizzBuzzService();
		assertThrows(IllegalArgumentException.class, ()->{
			fbs.buzzFizz("zero", 5);
		});

		assertThrows(IllegalArgumentException.class, ()->{
			fbs.buzzFizz("Buzz", 0);
		});

		assertThrows(IllegalArgumentException.class, ()->{
			fbs.buzzFizz("Buzz", -5);
		});
	}

	//probly should fail, since really FizzBuzz would be the output of
	//the standard BuzzFizz for 75
	@Test
	void testAmbiguousFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();
		assertEquals(75, fbs.buzzFizz("Fizz", 25));
		assertEquals(75, fbs.buzzFizz("Buzz", 15));
		assertEquals(75, fbs.buzzFizz("FizzBuzz", 5));
	}
}

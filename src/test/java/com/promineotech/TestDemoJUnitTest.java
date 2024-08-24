package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() {
		 testDemo = new TestDemo();
	}
	
	@ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		 if (!expectException) {
			 assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		 } else {
			 assertThatThrownBy(() -> testDemo.addPositive(a, b))
             .isInstanceOf(IllegalArgumentException.class);
		 }
	}

	static Stream<Arguments> argumentsForAddPositive() {
		  return Stream.of(
		            arguments(2, 6, 8, false),
		            arguments(1, 1, 2, false),
		            arguments(0, 1, 1, true),
		            arguments(-1, 1, 0, true),
		            arguments(5, 0, 5, true),
		            arguments(-4, -4, -7, true));
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {				// testing of the Add Positive method
		
		assertThat(testDemo.addPositive(8, 12)).isEqualTo(20);
		assertThat(testDemo.addPositive(14, 27)).isEqualTo(41);
		assertThat(testDemo.addPositive(2, 5)).isEqualTo(7);
		assertThat(testDemo.addPositive(80, 72)).isEqualTo(152);
		assertThat(testDemo.addPositive(22, 22)).isEqualTo(44);
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersMultiplyCorrectly() {
		
		
		assertThat(testDemo.multiplyPositive(11, 8)).isEqualTo(88);			//testing of the Multiply Positive method
		assertThat(testDemo.multiplyPositive(4, 10)).isEqualTo(40);
		
		
		assertThatThrownBy(() -> testDemo.multiplyPositive(-5, 8)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.multiplyPositive(-9, 2)).isInstanceOf(IllegalArgumentException.class);
		
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {							//testing of the Random Number Squared method
		
		TestDemo testDemo = new TestDemo();
		TestDemo mockDemo = spy(testDemo);
		doReturn(7).when(mockDemo).getRandomInt();
		
		int sevenSquared = mockDemo.randomNumberSquared();
		assertThat(sevenSquared).isEqualTo(49);
		
	}

}

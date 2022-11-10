package com.example.demo;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class MoodAnalyserTest {
	@Test
	void testMoodAnalysis() {
		//class containing method
		MoodAnalyser moodAnalyser = new MoodAnalyser();
		//result of calling analyseMood
		String mood = moodAnalyser.analyseMood("sdfsdf");
		//assertThat it is of String "SAD"
		assertThat(mood, CoreMatchers.is("SAD"));
	}
	@Test
	void HappyMoods() {
		MoodAnalyser moodAnalyser = new MoodAnalyser();
		String mood = moodAnalyser.analyseMood("fsdfsdf");
		assertThat(mood, CoreMatchers.is("HAPPY"));
	}
}
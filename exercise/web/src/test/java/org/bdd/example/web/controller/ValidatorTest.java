package org.bdd.example.web.controller;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(Enclosed.class)
public class ValidatorTest {

    public static class IntegerValidator {
        @Test
        public void shouldValidatePositiveIntegers() {
            assertThat(Validator.isInteger("1"), is(true));
        }

        @Test
        public void shouldValidateNegativeIntegers() {
            assertThat(Validator.isInteger("-1"), is(true));
        }

        @Test
        public void shouldValidateSignedPositiveIntegers() {
            assertThat(Validator.isInteger("+1"), is(true));
        }

        @Test
        public void shouldNotValidateANumberWithWhiteSpace() {
            assertThat(Validator.isInteger("  1   "), is(false));
        }

        @Test
        public void shouldNotValidateTextAsAnInteger() {
            assertThat(Validator.isInteger("text"), is(false));
        }

        @Test
        public void shouldNotValidateAnEmptyString() {
            assertThat(Validator.isInteger(""), is(false));
        }
    }
}

package pl.sdacademy.unit.test.basic.exercises.tdd.task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void shouldTransferCorrectAmount() {
        //given
        Account credit = new Account(1000, "11111111111111111111111111", new Customer("aaa", "bbb"));
        Account debit = new Account(2000, "22222222222222222222222222", new Customer("ccc", "ddd"));
        //when
        debit.transferMoney(credit, 100);
        //then
        assertEquals(1100, credit.getBalance());
        assertEquals(1900, debit.getBalance());
        assertThat(credit.getBalance()).isEqualTo(1100);
        assertThat(debit.getBalance()).isEqualTo(1900);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "111111111111111111111111111", " ", " 11111111111111111111111111"})
    void shouldThrowExceptionIfCreditAccountNumberIsWrong(String creditAccountNumber) {
        //given
        Account credit = new Account(1000, creditAccountNumber, new Customer("aaa", "bbb"));
        Account debit = new Account(2000, "22222222222222222222222222", new Customer("ccc", "ddd"));
        //when
        //then
        assertThatThrownBy(() -> debit.transferMoney(credit, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong account number: " + credit.getAccountNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "222222222222222222222222222", " ", " 22222222222222222222222222"})
    void shouldThrowExceptionIfDebitAccountNumberIsWrong(String debitAccountNumber) {
        //given
        Account credit = new Account(1000, "11111111111111111111111111", new Customer("aaa", "bbb"));
        Account debit = new Account(2000, "debitAccountNumber", new Customer("ccc", "ddd"));
        //when
        //then
        assertThatThrownBy(() -> debit.transferMoney(credit, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong account number: " + debit.getAccountNumber());
    }

    @ParameterizedTest
    @ValueSource(floats = {10000, 0, -1})
    void shouldThrowExceptionIfAmountIsWrong(float amount) {
        //given
        Account credit = new Account(1000, "11111111111111111111111111", new Customer("aaa", "bbb"));
        Account debit = new Account(2000, "22222222222222222222222222", new Customer("ccc", "ddd"));
        //when
        //then
        assertThatThrownBy(() -> debit.transferMoney(credit, amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong value of amount");
    }
}
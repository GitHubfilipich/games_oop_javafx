package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenBishopBlackA1ThenPositionEqualA1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.A1);
    }

    @Test
    void whenBishopBlackCopyThenBishopBlackCopyPositionEqualBishopBlackPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure bishopBlackCopy = bishopBlack.copy(bishopBlack.position());
        assertThat(bishopBlackCopy.position()).isEqualTo(bishopBlack.position());
    }

    @Test
    void whenBishopBlackC1WayG5ThenEqualD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expexted = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).containsExactly(expexted);
    }

    @Test
    void whenBishopBlackA1WayC2ThenThrowImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.C2);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from A1 to C2");
    }
}
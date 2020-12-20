package org.caloean.DataStructures.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void crudOperations() {
        ArrayList<Integer> list = new ArrayList<>(2);
        assertThat(list.size()).isEqualTo(0);

        list.add(0);
        list.add(-1);
        list.add(0);
        list.add(-3);

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(0);
        assertThat(list.get(1)).isEqualTo(-1);
        assertThat(list.get(2)).isEqualTo(0);
        assertThat(list.get(3)).isEqualTo(-3);

        list.remove(0);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(-1);
        assertThat(list.get(1)).isEqualTo(0);
        assertThat(list.get(2)).isEqualTo(-3);
        assertThat(list.list[3]).isEqualTo(null);

        list.remove(2);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(-1);
        assertThat(list.get(1)).isEqualTo(0);
        assertThat(list.list[2]).isEqualTo(null);
    }

    @Test
    public void badArraySize() {
        assertThrows(NegativeArraySizeException.class, () -> new ArrayList<Integer>(-1));
    }

    @Test
    public void badIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(-1));
    }
}

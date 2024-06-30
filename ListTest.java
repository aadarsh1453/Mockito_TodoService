package Business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void listMockSizeMethodTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }

    @Test
    void listMockSizeReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(5);
        assertEquals(2,listMock.size());
        assertEquals(5,listMock.size());
    }

    @Test
    void listMockSizeGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Tushar");
        assertEquals("Tushar",listMock.get(0));
        when(listMock.get(1)).thenReturn("Vedant");
        assertEquals("Vedant",listMock.get(1));
        when(listMock.get(anyInt())).thenReturn("Anjali").thenReturn("Tushar");
        assertEquals("Anjali",listMock.get(0));
        assertEquals("Tushar",listMock.get(1));
    }

    @Test
    void listMockSizeBDD() {
        //Given
        List<String> listBDD = mock(List.class);
        given(listBDD.get(anyInt())).willReturn("Tushar").willReturn("Anjali");
        //When
        String f = listBDD.get(0);
        String s = listBDD.get(1);
        //Then
        assertThat(f    ,is("Tushar"));
        assertThat(s,is("Anjali"));
    }


    @Test()
    public void listMockThrowsException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);

    }
}
